/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns.controller;

import it.mds.sdk.connettore.anagrafiche.tabella.EsitoCDM;
import it.mds.sdk.flusso.cns.parser.regole.RecordDtoCns;
import it.mds.sdk.flusso.cns.parser.regole.conf.ConfigurazioneFlussoCns;
import it.mds.sdk.flusso.cns.service.FlussoCnsService;
import it.mds.sdk.gestoreesiti.GestoreRunLog;
import it.mds.sdk.gestoreesiti.Progressivo;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.gestoreesiti.modelli.StatoRun;
import it.mds.sdk.gestoreesiti.modelli.TipoElaborazione;
import it.mds.sdk.gestorefile.GestoreFile;
import it.mds.sdk.gestorefile.factory.GestoreFileFactory;
import it.mds.sdk.libreriaregole.parser.ParserRegole;
import it.mds.sdk.libreriaregole.parser.ParserTracciato;
import it.mds.sdk.libreriaregole.regole.beans.RegoleFlusso;
import it.mds.sdk.rest.api.controller.ValidazioneController;
import it.mds.sdk.rest.persistence.entity.FlussoRequest;
import it.mds.sdk.rest.persistence.entity.RecordRequest;
import it.mds.sdk.rest.persistence.entity.RisultatoInizioValidazione;
import it.mds.sdk.rest.persistence.entity.RisultatoValidazione;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

@RestController
@Configuration
@EnableAsync
@Slf4j
public class FlussoCnsControllerRest implements ValidazioneController<RecordDtoCns> {

    private final ParserRegole parserRegole;
    private final ParserTracciato parserTracciato;
    private final FlussoCnsService flussoCnsService;
    private final ConfigurazioneFlussoCns conf;

    private final MultiValueMap<String, String> headers;

    @Autowired
    public FlussoCnsControllerRest(@Qualifier("parserRegoleCns") final ParserRegole parserRegole,
                                   @Qualifier("parserTracciatoCns") final ParserTracciato parserTracciato,
                                   @Qualifier("flussoCnsService") final FlussoCnsService flussoCnsService,
                                   @Qualifier("configurazioneFlussoCns") ConfigurazioneFlussoCns conf) {
        this.parserRegole = parserRegole;
        this.parserTracciato = parserTracciato;
        this.flussoCnsService = flussoCnsService;
        this.conf = conf;

        headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("X-Frame-Options", "DENY");
        headers.add("X-XSS-Protection", "1; mode=block");
        headers.add("Content-Security-Policy", "default-src 'self'");

    }

    @Override
    @PostMapping(path = "v1/flusso/consumidispositivi")
    public ResponseEntity<RisultatoInizioValidazione> validaTracciato(@RequestBody FlussoRequest flusso, String nomeFlussoController) {

        String filename = FilenameUtils.normalize(flusso.getNomeFile());
        log.debug("{}.validaTracciato - BEGIN", this.getClass().getName());
        if (flusso.getAnnoRiferimento() == null || flusso.getAnnoRiferimento().isEmpty()
                || flusso.getPeriodoRiferimento() == null || flusso.getPeriodoRiferimento().isEmpty()
        ) {
            return new ResponseEntity<>(new RisultatoInizioValidazione(false, "Campi obbligatori Mancanti", "", flusso.getIdClient()), headers, HttpStatus.BAD_REQUEST);
        }
        log.debug("{}.validaTracciato - annoRiferimento[{}] - periodoRiferimento[{}]", this.getClass().getName(), flusso.getPeriodoRiferimento(), flusso.getAnnoRiferimento());

        File tracciato = getFileFromPath(conf.getFlusso().getPercorso() + filename);
        if (!tracciato.exists()) {
            log.debug("File tracciato {} non trovato ", conf.getFlusso().getPercorso() + filename);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File tracciato non trovato");
        }

        File fileRegole = getFileFromPath(conf.getRules().getPercorso());
        if (!fileRegole.exists()) {
            log.debug("File regole {} non trovato ", conf.getRules().getPercorso());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File Regole non trovato");
        }

        RegoleFlusso regoleFlusso = parserRegole.parseRegole(fileRegole);
        GestoreFile gestoreFile = GestoreFileFactory.getGestoreFile("CSV");
        GestoreRunLog gestoreRunLog = createGestoreRunLog(gestoreFile, Progressivo.creaProgressivo(Progressivo.Fonte.FILE));
        String nomeFlusso = conf.getNomeFLusso().getNomeFlusso();
        InfoRun infoRun = gestoreRunLog.creaRunLog(flusso.getIdClient(), flusso.getModalitaOperativa(), 0, nomeFlusso);
        infoRun.setTipoElaborazione(TipoElaborazione.F);
        infoRun.setTimestampCreazione(new Timestamp(System.currentTimeMillis()));
        infoRun.setVersion(getClass().getPackage().getImplementationVersion());
        infoRun.setAnnoRiferimento(flusso.getAnnoRiferimento());
        infoRun.setPeriodoRiferimento(flusso.getPeriodoRiferimento());
        infoRun.setCodiceRegione(flusso.getCodiceRegione());
        infoRun.setFileAssociatiRun(filename);
        gestoreRunLog.updateRun(infoRun);
        infoRun = gestoreRunLog.cambiaStatoRun(infoRun.getIdRun(), StatoRun.IN_ELABORAZIONE);
        int dimensioneBlocco = Integer.parseInt(conf.getDimensioneBlocco().getDimensioneBlocco());

        flussoCnsService.lanciaValidazioniPerFlusso(dimensioneBlocco,flusso,infoRun,gestoreRunLog,regoleFlusso);

        /*List<EsitoCDM> listaEsitiCDM = validaRecordInteroFlusso(flusso, gestoreRunLog, infoRun);

        flussoCnsService.validazioneBlocchi(dimensioneBlocco, flusso.getNomeFile(), regoleFlusso, infoRun.getIdRun(),
                flusso.getIdClient(), flusso.getModalitaOperativa(), flusso.getPeriodoRiferimento(),
                flusso.getAnnoRiferimento(), flusso.getCodiceRegione(), gestoreRunLog, listaEsitiCDM);*/

        log.debug("Fine validaTracciato per idRun {}", infoRun.getIdRun());
        return new ResponseEntity<>(new RisultatoInizioValidazione(true, "", infoRun.getIdRun(), flusso.getIdClient()), HttpStatus.OK);
    }

    /*private List<EsitoCDM> validaRecordInteroFlusso(FlussoRequest flusso, GestoreRunLog gestoreRunLog, InfoRun infoRun) {
        return flussoCnsService.validazioneRegoleInteroFlusso(flusso.getNomeFile(), infoRun.getIdRun(), gestoreRunLog);
    }*/

    @Override
    public ResponseEntity<RisultatoValidazione> validaRecord(RecordRequest<RecordDtoCns> recordRequest, String nomeFlusso) {
        return null;
    }

    public File getFileFromPath(String s) {
        return new File(s);
    }

    public GestoreRunLog createGestoreRunLog(GestoreFile gestoreFile, Progressivo creaProgressivo) {
        return new GestoreRunLog(gestoreFile, creaProgressivo);
    }

    @Override
    @GetMapping("v1/flusso/consumidispositivi/info")
    public ResponseEntity<InfoRun> informazioniRun(@RequestParam(required = false) String idRun, @RequestParam(required = false) String idClient) {
        GestoreFile gestoreFile = GestoreFileFactory.getGestoreFile("CSV");
        GestoreRunLog gestoreRunLog = createGestoreRunLog(gestoreFile, Progressivo.creaProgressivo(Progressivo.Fonte.FILE));
        InfoRun infoRun;
        if (idRun != null) {
            infoRun = gestoreRunLog.getRun(idRun);
        } else if (idClient != null) {
            infoRun = gestoreRunLog.getRunFromClient(idClient);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run non trovata");
        }
        if (infoRun == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run non trovata");
        }

        return new ResponseEntity<>(infoRun, headers, HttpStatus.OK);
    }
}
