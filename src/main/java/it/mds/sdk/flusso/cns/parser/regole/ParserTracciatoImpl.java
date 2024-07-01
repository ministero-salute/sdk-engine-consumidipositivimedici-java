/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns.parser.regole;


import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import it.mds.sdk.connettore.anagrafiche.gestore.anagrafica.CacheSQLite;
import it.mds.sdk.connettore.anagrafiche.tabella.EsitoCDM;
import it.mds.sdk.connettore.anagrafiche.tabella.RecordCDM;
import it.mds.sdk.connettore.anagrafiche.tabella.TabellaAnagrafica;
import it.mds.sdk.flusso.cns.parser.regole.conf.ConfigurazioneFlussoCns;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import it.mds.sdk.libreriaregole.parser.ParserTracciato;
import it.mds.sdk.rest.exception.ParseCSVException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Component("parserTracciatoCns")
public class ParserTracciatoImpl implements ParserTracciato {

    private final int CHUNK_SIZE_CDM = 100000;
    private ConfigurazioneFlussoCns conf = new ConfigurazioneFlussoCns();

    /**
     * Il metodo converte un File.csv in una List<RecordDtoGenerico> usando come separatore "~"
     *
     * @param tracciato, File.csv di input
     * @return una lista di RecordDtoDir
     */
    @Override
    public List<RecordDtoGenerico> parseTracciato(File tracciato) {
        char separatore = conf.getSeparatore().getSeparatore().charAt(0);
        try (FileReader fileReader = new FileReader(tracciato)) {
            List<RecordDtoGenerico> dirList = new CsvToBeanBuilder<RecordDtoGenerico>(fileReader)
                    .withType(RecordDtoCns.class)
                    .withSeparator(separatore)
                    .withSkipLines(1)   //Salta la prima riga del file CSV
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .build()
                    .parse();
            fileReader.close();

            return dirList;

        } catch (IOException e) {
            log.debug(e.getMessage(), e);
        } catch (Exception ex) {
            throw new ParseCSVException(ex.getMessage());
        }

        return Collections.emptyList();
    }

    public List<EsitoCDM> parseTracciatoBloccoCDM(File tracciato) {

        log.info("Inizio parse tracciato file {} scrittura, filtraggio record e drop table", tracciato.getName());

        StopWatch stopWatch = new StopWatch();
        String nomeTabella = "CDM";

        log.info("Inizio lettura file {} e scrittura nella tabella {}", tracciato.getName(), nomeTabella);

        stopWatch.start();

        try (Reader reader = Files.newBufferedReader(tracciato.toPath())) {

            Iterator<RecordDtoCns> it = new CsvToBeanBuilder<RecordDtoCns>(reader)
                    .withType(RecordDtoCns.class)
                    .withSeparator('~')
                    .withSkipLines(1)   //Salta la prima riga del file CSV
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .build()
                    .iterator();

            int count = 0;
            int idRecord = 0;
            List<RecordCDM> list = new ArrayList<>();

            CacheSQLite cacheSQLite = CacheSQLite.getInstance();
            cacheSQLite.creaTabellaCDM(nomeTabella);

            while (it.hasNext()) {
                count++;
                idRecord++;
                RecordDtoGenerico recordGen = it.next();
                RecordCDM recordCDM = createRecordCDMFromRecordGenerico(recordGen, idRecord);

                list.add(recordCDM);

                if (count == CHUNK_SIZE_CDM || !it.hasNext()) {
                    count = 0;
                    TabellaAnagrafica<RecordCDM> tabellaAnagraficaCDM = new TabellaAnagrafica<>();
                    tabellaAnagraficaCDM.setRecordsAnagrafica(list);
                    tabellaAnagraficaCDM.setNome(nomeTabella);

                    cacheSQLite.addRecordCDM(tabellaAnagraficaCDM);
                    list.clear();
                }
            }

            log.info("Fine lettura file {} e scrittura nella tabella {}", tracciato.getName(), nomeTabella);
            log.info("Inizio filtraggio elementi scartati dalla tabella {}", nomeTabella);
            TabellaAnagrafica<EsitoCDM> tabellaAnagraficaCDM = new TabellaAnagrafica<>();
            tabellaAnagraficaCDM.setNome(nomeTabella);

            var listaScartati = cacheSQLite.selectFilterCNS(tabellaAnagraficaCDM);
            log.info("Fine filtraggio elementi scartati dalla tabella {}", nomeTabella);
            if (!cacheSQLite.dropTableCDM(nomeTabella)) {
                log.debug("La Tabella {} non è stata droppata.", nomeTabella);
                throw new SQLException();
            }
            stopWatch.stop();
            log.info("Fine parse tracciato file {} scrittura, filtraggio record e drop table {} in {} ms", tracciato.getName(), nomeTabella, stopWatch.getLastTaskTimeMillis());

            return listaScartati;

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new ParseCSVException(ex.getMessage());
        }
    }

    public List<RecordDtoGenerico> parseTracciatoBlocco(File tracciato, int inizio, int fine) {
        StopWatch stopWatch = new StopWatch();
        char separatore = conf.getSeparatore().getSeparatore().charAt(0);
        log.info("Inizio lettura file {} da riga {} a riga {}", tracciato.getName(), inizio, fine);
        stopWatch.start();
        try (Reader reader = Files.newBufferedReader(tracciato.toPath())) {
            List<RecordDtoGenerico> res = new ArrayList<>();
            Iterator<RecordDtoCns> it = new CsvToBeanBuilder<RecordDtoCns>(reader)
                    .withType(RecordDtoCns.class)
                    .withSeparator(separatore)
                    .withSkipLines(inizio + 1)   //Salta la prima riga del file CSV
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .build()
                    .iterator();
            int count = inizio;
            int totaleRecordElaborati = 0;
            while (it.hasNext() && count < fine) {
                count++;
                RecordDtoGenerico recordGen = it.next();
                res.add(recordGen);
                totaleRecordElaborati++;
            }
            stopWatch.stop();
            log.info("Fine lettura file {} da riga {} a riga {} con {} record in {} ms", tracciato.getName(), inizio,
                    fine, totaleRecordElaborati, stopWatch.getLastTaskTimeMillis());

            return res;
        } catch (Exception e) {
            throw new ParseCSVException(e.getMessage());
        }
    }

    private RecordCDM createRecordCDMFromRecordGenerico(RecordDtoGenerico recordGen, int idRecord) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        log.debug("{}.createRecordCDMFromRecordGenerico - Mapping record {} ", this.getClass().getName(), idRecord);
        return new RecordCDM(
                idRecord,
                (String) recordGen.getCampo("codiceAziendaSanitaria"),
                (String) recordGen.getCampo("tipoStrutturaUtilizzatrice"),
                (String) recordGen.getCampo("codiceStrutturaUtilizzatrice"),
                (String) recordGen.getCampo("codiceUnitaOperativa")
        );
    }


}
