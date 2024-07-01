/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns.parser.regole.conf;

import it.mds.sdk.connettore.anagrafiche.conf.Configurazione;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Slf4j
@Data
@Component("configurazioneFlussoCns")
public class ConfigurazioneFlussoCns {
    private static final String FILE_CONF = "config-flusso-cns.properties";
    Rules rules;
    XmlOutput xmlOutput;
    Flusso flusso;
    SogliaInvio sogliaInvio;
    private Sent sent;
    private NomeFlusso nomeFLusso;
    private DimensioneBlocco dimensioneBlocco;
    private Separatore separatore;
    private CategoriaFlusso categoriaFlusso;

    public ConfigurazioneFlussoCns() {
        this(leggiConfigurazioneEsterna());
    }

    public ConfigurazioneFlussoCns(final Properties conf) {

        this.rules = ConfigurazioneFlussoCns.Rules.builder()
                .withPercorso(conf.getProperty("regole.percorso", ""))
                .build();
        this.xmlOutput = ConfigurazioneFlussoCns.XmlOutput.builder()
                .withPercorso(conf.getProperty("xmloutput.percorso", ""))
                .build();
        this.flusso = ConfigurazioneFlussoCns.Flusso.builder()
                .withPercorso(conf.getProperty("flusso.percorso", ""))
                .build();
        this.sogliaInvio = ConfigurazioneFlussoCns.SogliaInvio.builder()
                .withSoglia(conf.getProperty("soglia.invio.mds", ""))
                .build();
        this.sent = ConfigurazioneFlussoCns.Sent.builder()
                .withPercorsoSent(conf.getProperty("sent.percorso", ""))
                .build();
        this.categoriaFlusso = ConfigurazioneFlussoCns.CategoriaFlusso.builder()
                .withCategoriaFlusso(conf.getProperty("categoria.flusso", ""))
                .build();
        this.nomeFLusso = ConfigurazioneFlussoCns.NomeFlusso.builder()
                .withNomeFlusso(conf.getProperty("nome.flusso", ""))
                .build();
        this.dimensioneBlocco = ConfigurazioneFlussoCns.DimensioneBlocco.builder()
                .withDimensioneBlocco(conf.getProperty("dimensione.blocco", "1000"))
                .build();
        this.separatore = ConfigurazioneFlussoCns.Separatore.builder()
                .withSeparatore(conf.getProperty("separatore", "~"))
                .build();
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class Rules {
        String percorso;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class XmlOutput {
        String percorso;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class Flusso {
        String percorso;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class SogliaInvio {
        String soglia;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class Sent {
        String percorsoSent;
    }
    @Value
    @Builder(setterPrefix = "with")
    public static class NomeFlusso {
        String nomeFlusso;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class DimensioneBlocco {
        String dimensioneBlocco;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class Separatore {
        String separatore;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class CategoriaFlusso {
        String categoriaFlusso;
    }

    private static Properties leggiConfigurazione(final String nomeFile) {
        final Properties prop = new Properties();
        if(ConfigurazioneFlussoCns.class.getClassLoader() == null){
            log.trace("{}.getClassLoader() is null", ConfigurazioneFlussoCns.class);
            throw new NullPointerException();
        }

        try (final InputStream is = ConfigurazioneFlussoCns.class.getClassLoader().getResourceAsStream(nomeFile)) {
            prop.load(is);
        } catch (IOException e) {
            log.debug(e.getMessage(), e);
        }
        return prop;
    }
    private static Properties leggiConfigurazioneEsterna() {
        log.debug("{}.leggiConfigurazioneEsterna - BEGIN", Configurazione.class.getName());
        Properties properties = new Properties();
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(Paths.get("/sdk/properties", FILE_CONF).toFile()),
                StandardCharsets.UTF_8))  {
            properties.load(in);
        } catch (IOException e) {
            log.error("{}.leggiConfigurazioneEsterna", Configurazione.class.getName(), e);
            return leggiConfigurazione(FILE_CONF);
        }
        return properties;
    }
}
