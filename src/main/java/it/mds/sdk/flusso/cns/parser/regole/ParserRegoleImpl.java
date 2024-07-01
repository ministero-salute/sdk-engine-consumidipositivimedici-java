/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns.parser.regole;

import it.mds.sdk.libreriaregole.parser.ParserRegole;
import it.mds.sdk.libreriaregole.regole.beans.RegoleFlusso;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

@Slf4j
@Component("parserRegoleCns")
public class ParserRegoleImpl implements ParserRegole {

    @Override
    public RegoleFlusso parseRegole(File regole) {
        log.debug("{}.parseRegole() - BEGIN", this.getClass().getName());
        return parseFileRegole(regole);
    }

    private RegoleFlusso parseFileRegole(File regole) {
        log.debug("{}.parseFileRegole() - BEGIN", this.getClass().getName());
        try {
            JAXBContext jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[]{RegoleFlusso.class}, null);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Unmarshaller jaxbUnmarshalled = jaxbContext.createUnmarshaller();
            return (RegoleFlusso) jaxbUnmarshalled.unmarshal(regole);

        } catch (JAXBException e) {
            log.error("Impossibile parse del file di regole ", e);
        }
        return null;
    }

}