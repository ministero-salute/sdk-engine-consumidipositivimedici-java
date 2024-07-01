/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns.tracciato;

import it.mds.sdk.flusso.cns.parser.regole.RecordDtoCns;
import it.mds.sdk.flusso.cns.parser.regole.conf.ConfigurazioneFlussoCns;
import it.mds.sdk.flusso.cns.tracciato.output.Dataroot;
import it.mds.sdk.libreriaregole.tracciato.TracciatoSplitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.net.URL;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("tracciatoSplitter")
public class TracciatoSplitterImpl implements TracciatoSplitter<RecordDtoCns> {

    private static final String XML_FILENAME_TEMPLATE = "SDK_CDM_CNS_%s_%s.xml" ;
    @Override
    public List<Path> dividiTracciato(Path tracciato) {
        return Collections.emptyList();
    }

    @Override
    public List<Path> dividiTracciato(List<RecordDtoCns> records, String idRun) {

        ConfigurazioneFlussoCns conf = new ConfigurazioneFlussoCns();
        String fileName = String.format(XML_FILENAME_TEMPLATE,records.get(0).getCampiInput().getPeriodoRiferimentoInput(), idRun);
        Path xml = Path.of(conf.getXmlOutput().getPercorso(),fileName);

        try {
            URL urlXsd = this.getClass().getClassLoader().getResource("CNS.xsd");
            log.debug("URL dell'XSD per la validazione idrun {} : {}", idRun, urlXsd);


            return List.of(xml);


        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            log.error("[{}].dividiTracciato  - records[{}]  - idRun[{}] -" + e.getMessage(),
                    this.getClass().getName(),
                    e
            );
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Impossibile validare il csv in ingresso. message: " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private Dataroot.REGIONE creaRegione(String codiceRegione) {
        Dataroot.REGIONE regioneEr = new Dataroot.REGIONE();
        regioneEr.setCodReg(codiceRegione);
        return regioneEr;
    }

    private Dataroot.REGIONE.PERIODO creaPeriodo(String anno, String mese) {
        Dataroot.REGIONE.PERIODO periodo = new Dataroot.REGIONE.PERIODO();
        periodo.setAnno(anno);
        periodo.setMese(mese);
        return periodo;
    }

    private Dataroot.REGIONE.PERIODO.AS creaAs(String codAs) {
        Dataroot.REGIONE.PERIODO.AS as = new Dataroot.REGIONE.PERIODO.AS();
        as.setCodAs(codAs);
        return as;
    }

    private Dataroot.REGIONE.PERIODO.AS.STRUTTURA creaStruttura(String codStruttura, String tipoStuttura) {
        Dataroot.REGIONE.PERIODO.AS.STRUTTURA struttura = new Dataroot.REGIONE.PERIODO.AS.STRUTTURA();
        struttura.setCodStr(codStruttura);
        struttura.setTipoStr(tipoStuttura);
        return struttura;
    }

    private Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP creaCodiceUnitaOperativa(RecordDtoCns recordDtoCns) {
        Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP unitop = new Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP();
        unitop.setCodUnOp(recordDtoCns.getCodiceUnitaOperativa());
        return unitop;
    }

    private Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP.OPERAZIONE creaOperazione(RecordDtoCns recordDtoCns) {
        Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP.OPERAZIONE operazione = new Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP.OPERAZIONE();
        operazione.setTipoOp(recordDtoCns.getTipoOperazione());
        return operazione;
    }

    private Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP.OPERAZIONE.DISPOSITIVO creaDispositivo(RecordDtoCns recordDtoCns) {
        Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP.OPERAZIONE.DISPOSITIVO dispositivo = new Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP.OPERAZIONE.DISPOSITIVO();
        dispositivo.setTipoDispositivo(recordDtoCns.getTipoDispositivoMedico());
        dispositivo.setTipoDestiUtili(recordDtoCns.getTipoDestinazioneDiUtilizzo());
        dispositivo.setDestiUtili(recordDtoCns.getDestinazioneDiUtilizzo());
        if (recordDtoCns.getIdentificativoDiIscrizioneInBancaDatiRepertorio() != null) {
            dispositivo.setNumRep(Long.parseLong(recordDtoCns.getIdentificativoDiIscrizioneInBancaDatiRepertorio()));
        }
        dispositivo.setCosto(recordDtoCns.getCostoDacquisto());
        dispositivo.setQta(recordDtoCns.getQuantitaDistribuita());
        return dispositivo;
    }

    public Dataroot creaDataroot(List<RecordDtoCns> records, Dataroot dataRoot) {
        if (dataRoot == null) {
            dataRoot = new Dataroot();

            //Regione che è unica per il file
            Dataroot.REGIONE regione = creaRegione(records.get(0).getCodiceRegione());

            //Periodo che è unico per il file
            Dataroot.REGIONE.PERIODO periodo = creaPeriodo(records.get(0).getAnnoDiConsegna(), records.get(0).getMeseDiConsegna());
            regione.setPERIODO(periodo);
            dataRoot.setREGIONE(regione);

            //AS
            for (RecordDtoCns r : records) {
                Dataroot.REGIONE.PERIODO.AS currentAs = dataRoot.getREGIONE().getPERIODO().getAS()
                        .stream()
                        .filter(as -> r.getCodiceAziendaSanitaria().equalsIgnoreCase(as.getCodAs()))
                        .findFirst()
                        .orElse(null);
                if (currentAs == null) {
                    currentAs = creaAs(r.getCodiceAziendaSanitaria());
                    dataRoot.getREGIONE().getPERIODO().getAS().add(currentAs);

                }

                //Struttura
                Dataroot.REGIONE.PERIODO.AS.STRUTTURA currentStruttura = currentAs.getSTRUTTURA()
                        .stream()
                        .filter(st -> r.getCodiceStrutturaUtilizzatrice().equalsIgnoreCase(st.getCodStr()) &&
                                ((r.getTipoStrutturaUtilizzatrice() == null && st.getTipoStr() == null) ||
                                        (r.getTipoStrutturaUtilizzatrice() != null && r.getTipoStrutturaUtilizzatrice().equalsIgnoreCase(st.getTipoStr())))
                        )
                        .findFirst()
                        .orElse(null);
                if (currentStruttura == null) {
                    currentStruttura = creaStruttura(r.getCodiceStrutturaUtilizzatrice(), r.getTipoStrutturaUtilizzatrice());
                    currentAs.getSTRUTTURA().add(currentStruttura);
                }

                //Codice Unità Operativa
                Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP currentUnitaOperativa = currentStruttura.getUNITOP()
                        .stream()
                        .filter(unitop -> r.getCodiceUnitaOperativa().equalsIgnoreCase(unitop.getCodUnOp()))
                        .findFirst()
                        .orElse(null);
                if (currentUnitaOperativa == null) {
                    currentUnitaOperativa = creaCodiceUnitaOperativa(r);
                    currentStruttura.getUNITOP().add(currentUnitaOperativa);
                }

                //Operazione
                Dataroot.REGIONE.PERIODO.AS.STRUTTURA.UNITOP.OPERAZIONE currentOperazione = currentUnitaOperativa.getOPERAZIONE()
                        .stream()
                        .filter(op -> r.getTipoOperazione().equalsIgnoreCase(op.getTipoOp()))
                        .findFirst()
                        .orElse(null);
                if (currentOperazione == null) {
                    currentOperazione = creaOperazione(r);
                    currentUnitaOperativa.getOPERAZIONE().add(currentOperazione);
                }

                //Dispositivi
                currentOperazione.getDISPOSITIVO().add(creaDispositivo(r));
            }
        }
        return dataRoot;
    }
}
