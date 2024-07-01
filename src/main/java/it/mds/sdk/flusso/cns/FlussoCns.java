/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"it.mds.sdk.flusso.cns.controller","it.mds.sdk.flusso.cns",
		"it.mds.sdk.rest.persistence.entity","it.mds.sdk.libreriaregole.validator",
		"it.mds.sdk.flusso.cns.service","it.mds.sdk.flusso.cns.tracciato",
		"it.mds.sdk.gestoreesiti", "it.mds.sdk.flusso.cns.parser.regole",
		"it.mds.sdk.flusso.cns.parser.regole.conf",
		"it.mds.sdk.connettoremds"})
@OpenAPIDefinition(info=@Info(title = "SDK Ministero Della Salute - Flusso CNS", version = "0.0.1-SNAPSHOT", description = "Flusso Consumi Dispositivi"))
public class FlussoCns {

	public static void main(String[] args) {
		SpringApplication.run(FlussoCns.class, args);
	}

}
