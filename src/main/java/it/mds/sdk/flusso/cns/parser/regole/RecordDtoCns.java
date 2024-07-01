/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns.parser.regole;

import com.opencsv.bean.CsvBindByPosition;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import lombok.Data;

@Data
public class RecordDtoCns extends RecordDtoGenerico {

    @CsvBindByPosition(position = 0)
    private String codiceRegione;

    @CsvBindByPosition(position = 1)
    private String codiceAziendaSanitaria;

    @CsvBindByPosition(position = 2)
    private String tipoStrutturaUtilizzatrice;

    @CsvBindByPosition(position = 3)
    private String codiceStrutturaUtilizzatrice;

    @CsvBindByPosition(position = 4)
    private String codiceUnitaOperativa;

    @CsvBindByPosition(position = 5)
    private String annoDiConsegna;

    @CsvBindByPosition(position = 6)
    private String meseDiConsegna;

    @CsvBindByPosition(position = 7)
    private String tipoDispositivoMedico;

    @CsvBindByPosition(position = 8)
    private String identificativoDiIscrizioneInBancaDatiRepertorio;

    @CsvBindByPosition(position = 9)
    private String tipoDestinazioneDiUtilizzo;

    @CsvBindByPosition(position = 10)
    private String destinazioneDiUtilizzo;

    @CsvBindByPosition(position = 11)
    private String quantitaDistribuita;

    @CsvBindByPosition(position = 12)
    private String costoDacquisto;

    @CsvBindByPosition(position = 13)
    private String tipoOperazione;
}
