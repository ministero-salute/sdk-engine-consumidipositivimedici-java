//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.0 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2022.12.15 alle 10:25:04 AM CET 
//


/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.cns.tracciato.output;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="REGIONE"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PERIODO"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="AS" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;complexContent&gt;
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                   &lt;sequence&gt;
 *                                                                     &lt;element name="DISPOSITIVO" maxOccurs="unbounded"&gt;
 *                                                                       &lt;complexType&gt;
 *                                                                         &lt;complexContent&gt;
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                             &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
 *                                                                             &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
 *                                                                             &lt;attribute name="desti_utili" use="required"&gt;
 *                                                                               &lt;simpleType&gt;
 *                                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                                   &lt;enumeration value="00"/&gt;
 *                                                                                   &lt;enumeration value="01"/&gt;
 *                                                                                   &lt;enumeration value="02"/&gt;
 *                                                                                   &lt;enumeration value="03"/&gt;
 *                                                                                   &lt;enumeration value="04"/&gt;
 *                                                                                   &lt;enumeration value="05"/&gt;
 *                                                                                   &lt;enumeration value="0"/&gt;
 *                                                                                   &lt;enumeration value="1"/&gt;
 *                                                                                   &lt;enumeration value="2"/&gt;
 *                                                                                   &lt;enumeration value="3"/&gt;
 *                                                                                   &lt;enumeration value="4"/&gt;
 *                                                                                   &lt;enumeration value="5"/&gt;
 *                                                                                 &lt;/restriction&gt;
 *                                                                               &lt;/simpleType&gt;
 *                                                                             &lt;/attribute&gt;
 *                                                                             &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
 *                                                                             &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
 *                                                                             &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/complexContent&gt;
 *                                                                       &lt;/complexType&gt;
 *                                                                     &lt;/element&gt;
 *                                                                   &lt;/sequence&gt;
 *                                                                   &lt;attribute name="tipo_op" use="required" type="{http://eng.com/rdm/xml/model}TypeOperazione" /&gt;
 *                                                                 &lt;/restriction&gt;
 *                                                               &lt;/complexContent&gt;
 *                                                             &lt;/complexType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                         &lt;attribute name="cod_un_op" use="required"&gt;
 *                                                           &lt;simpleType&gt;
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                               &lt;pattern value="[0-9]{4}"/&gt;
 *                                                             &lt;/restriction&gt;
 *                                                           &lt;/simpleType&gt;
 *                                                         &lt;/attribute&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                               &lt;attribute name="tipo_str" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoF" /&gt;
 *                                               &lt;attribute name="cod_str" use="required" type="{http://eng.com/rdm/xml/model}TypeStr8" /&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="cod_as" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;pattern value="[0-9]{6}"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="mese" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;pattern value="0[1-9]|1[012]"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                           &lt;attribute name="anno" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;pattern value="[2][0][0-9]{2}"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="cod_reg" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoA" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CANCELLAZIONE_MASSIVA_DATI"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="REGIONE"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PERIODO"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;attribute name="cod_as" use="required"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;pattern value="[0-9]{6}"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="mese" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;pattern value="0[1-9]|1[012]"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                     &lt;attribute name="anno" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;pattern value="[2][0][0-9]{2}"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="cod_reg" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoA" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "regione",
    "cancellazionemassivadati"
})
@XmlRootElement(name = "dataroot", namespace = "http://eng.com/rdm/xml/model")
public class Dataroot {

    @XmlElement(name = "REGIONE", namespace = "http://eng.com/rdm/xml/model")
    protected REGIONE regione;
    @XmlElement(name = "CANCELLAZIONE_MASSIVA_DATI", namespace = "http://eng.com/rdm/xml/model")
    protected CANCELLAZIONEMASSIVADATI cancellazionemassivadati;

    /**
     * Recupera il valore della proprietà regione.
     * 
     * @return
     *     possible object is
     *     {@link REGIONE }
     *     
     */
    public REGIONE getREGIONE() {
        return regione;
    }

    /**
     * Imposta il valore della proprietà regione.
     * 
     * @param value
     *     allowed object is
     *     {@link REGIONE }
     *     
     */
    public void setREGIONE(REGIONE value) {
        this.regione = value;
    }

    /**
     * Recupera il valore della proprietà cancellazionemassivadati.
     * 
     * @return
     *     possible object is
     *     {@link CANCELLAZIONEMASSIVADATI }
     *     
     */
    public CANCELLAZIONEMASSIVADATI getCANCELLAZIONEMASSIVADATI() {
        return cancellazionemassivadati;
    }

    /**
     * Imposta il valore della proprietà cancellazionemassivadati.
     * 
     * @param value
     *     allowed object is
     *     {@link CANCELLAZIONEMASSIVADATI }
     *     
     */
    public void setCANCELLAZIONEMASSIVADATI(CANCELLAZIONEMASSIVADATI value) {
        this.cancellazionemassivadati = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="REGIONE"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PERIODO"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;attribute name="cod_as" use="required"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;pattern value="[0-9]{6}"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="mese" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;pattern value="0[1-9]|1[012]"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                           &lt;attribute name="anno" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;pattern value="[2][0][0-9]{2}"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="cod_reg" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoA" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "regione"
    })
    public static class CANCELLAZIONEMASSIVADATI {

        @XmlElement(name = "REGIONE", namespace = "http://eng.com/rdm/xml/model", required = true)
        protected REGIONE regione;

        /**
         * Recupera il valore della proprietà regione.
         * 
         * @return
         *     possible object is
         *     {@link REGIONE }
         *     
         */
        public REGIONE getREGIONE() {
            return regione;
        }

        /**
         * Imposta il valore della proprietà regione.
         * 
         * @param value
         *     allowed object is
         *     {@link REGIONE }
         *     
         */
        public void setREGIONE(REGIONE value) {
            this.regione = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="PERIODO"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;attribute name="cod_as" use="required"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;pattern value="[0-9]{6}"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="mese" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;pattern value="0[1-9]|1[012]"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *                 &lt;attribute name="anno" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;pattern value="[2][0][0-9]{2}"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="cod_reg" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoA" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "periodo"
        })
        public static class REGIONE {

            @XmlElement(name = "PERIODO", required = true)
            protected PERIODO periodo;
            @XmlAttribute(name = "cod_reg", required = true)
            protected String codReg;

            /**
             * Recupera il valore della proprietà periodo.
             * 
             * @return
             *     possible object is
             *     {@link PERIODO }
             *     
             */
            public PERIODO getPERIODO() {
                return periodo;
            }

            /**
             * Imposta il valore della proprietà periodo.
             * 
             * @param value
             *     allowed object is
             *     {@link PERIODO }
             *     
             */
            public void setPERIODO(PERIODO value) {
                this.periodo = value;
            }

            /**
             * Recupera il valore della proprietà codReg.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodReg() {
                return codReg;
            }

            /**
             * Imposta il valore della proprietà codReg.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodReg(String value) {
                this.codReg = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="AS" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;attribute name="cod_as" use="required"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;pattern value="[0-9]{6}"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="mese" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;pattern value="0[1-9]|1[012]"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *       &lt;attribute name="anno" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;pattern value="[2][0][0-9]{2}"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "as"
            })
            public static class PERIODO {

                @XmlElement(name = "AS")
                protected List<AS> as;
                @XmlAttribute(name = "mese", required = true)
                protected String mese;
                @XmlAttribute(name = "anno", required = true)
                protected String anno;

                /**
                 * Gets the value of the as property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the as property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAS().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link AS }
                 * 
                 * 
                 */
                public List<AS> getAS() {
                    if (as == null) {
                        as = new ArrayList<AS>();
                    }
                    return this.as;
                }

                /**
                 * Recupera il valore della proprietà mese.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMese() {
                    return mese;
                }

                /**
                 * Imposta il valore della proprietà mese.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMese(String value) {
                    this.mese = value;
                }

                /**
                 * Recupera il valore della proprietà anno.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAnno() {
                    return anno;
                }

                /**
                 * Imposta il valore della proprietà anno.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAnno(String value) {
                    this.anno = value;
                }


                /**
                 * <p>Classe Java per anonymous complex type.
                 * 
                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;attribute name="cod_as" use="required"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;pattern value="[0-9]{6}"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class AS {

                    @XmlAttribute(name = "cod_as", required = true)
                    protected String codAs;

                    /**
                     * Recupera il valore della proprietà codAs.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodAs() {
                        return codAs;
                    }

                    /**
                     * Imposta il valore della proprietà codAs.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodAs(String value) {
                        this.codAs = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PERIODO"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="AS" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;complexContent&gt;
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                         &lt;sequence&gt;
     *                                                           &lt;element name="DISPOSITIVO" maxOccurs="unbounded"&gt;
     *                                                             &lt;complexType&gt;
     *                                                               &lt;complexContent&gt;
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                   &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
     *                                                                   &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
     *                                                                   &lt;attribute name="desti_utili" use="required"&gt;
     *                                                                     &lt;simpleType&gt;
     *                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                                         &lt;enumeration value="00"/&gt;
     *                                                                         &lt;enumeration value="01"/&gt;
     *                                                                         &lt;enumeration value="02"/&gt;
     *                                                                         &lt;enumeration value="03"/&gt;
     *                                                                         &lt;enumeration value="04"/&gt;
     *                                                                         &lt;enumeration value="05"/&gt;
     *                                                                         &lt;enumeration value="0"/&gt;
     *                                                                         &lt;enumeration value="1"/&gt;
     *                                                                         &lt;enumeration value="2"/&gt;
     *                                                                         &lt;enumeration value="3"/&gt;
     *                                                                         &lt;enumeration value="4"/&gt;
     *                                                                         &lt;enumeration value="5"/&gt;
     *                                                                       &lt;/restriction&gt;
     *                                                                     &lt;/simpleType&gt;
     *                                                                   &lt;/attribute&gt;
     *                                                                   &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
     *                                                                   &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
     *                                                                   &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/complexContent&gt;
     *                                                             &lt;/complexType&gt;
     *                                                           &lt;/element&gt;
     *                                                         &lt;/sequence&gt;
     *                                                         &lt;attribute name="tipo_op" use="required" type="{http://eng.com/rdm/xml/model}TypeOperazione" /&gt;
     *                                                       &lt;/restriction&gt;
     *                                                     &lt;/complexContent&gt;
     *                                                   &lt;/complexType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                               &lt;attribute name="cod_un_op" use="required"&gt;
     *                                                 &lt;simpleType&gt;
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                     &lt;pattern value="[0-9]{4}"/&gt;
     *                                                   &lt;/restriction&gt;
     *                                                 &lt;/simpleType&gt;
     *                                               &lt;/attribute&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                     &lt;attribute name="tipo_str" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoF" /&gt;
     *                                     &lt;attribute name="cod_str" use="required" type="{http://eng.com/rdm/xml/model}TypeStr8" /&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="cod_as" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;pattern value="[0-9]{6}"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="mese" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;pattern value="0[1-9]|1[012]"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *                 &lt;attribute name="anno" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;pattern value="[2][0][0-9]{2}"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="cod_reg" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoA" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "periodo"
    })
    public static class REGIONE {

        @XmlElement(name = "PERIODO", namespace = "http://eng.com/rdm/xml/model", required = true)
        protected PERIODO periodo;
        @XmlAttribute(name = "cod_reg", required = true)
        protected String codReg;

        /**
         * Recupera il valore della proprietà periodo.
         * 
         * @return
         *     possible object is
         *     {@link PERIODO }
         *     
         */
        public PERIODO getPERIODO() {
            return periodo;
        }

        /**
         * Imposta il valore della proprietà periodo.
         * 
         * @param value
         *     allowed object is
         *     {@link PERIODO }
         *     
         */
        public void setPERIODO(PERIODO value) {
            this.periodo = value;
        }

        /**
         * Recupera il valore della proprietà codReg.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodReg() {
            return codReg;
        }

        /**
         * Imposta il valore della proprietà codReg.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodReg(String value) {
            this.codReg = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="AS" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="DISPOSITIVO" maxOccurs="unbounded"&gt;
         *                                                   &lt;complexType&gt;
         *                                                     &lt;complexContent&gt;
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                         &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
         *                                                         &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
         *                                                         &lt;attribute name="desti_utili" use="required"&gt;
         *                                                           &lt;simpleType&gt;
         *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                                               &lt;enumeration value="00"/&gt;
         *                                                               &lt;enumeration value="01"/&gt;
         *                                                               &lt;enumeration value="02"/&gt;
         *                                                               &lt;enumeration value="03"/&gt;
         *                                                               &lt;enumeration value="04"/&gt;
         *                                                               &lt;enumeration value="05"/&gt;
         *                                                               &lt;enumeration value="0"/&gt;
         *                                                               &lt;enumeration value="1"/&gt;
         *                                                               &lt;enumeration value="2"/&gt;
         *                                                               &lt;enumeration value="3"/&gt;
         *                                                               &lt;enumeration value="4"/&gt;
         *                                                               &lt;enumeration value="5"/&gt;
         *                                                             &lt;/restriction&gt;
         *                                                           &lt;/simpleType&gt;
         *                                                         &lt;/attribute&gt;
         *                                                         &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
         *                                                         &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
         *                                                         &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
         *                                                       &lt;/restriction&gt;
         *                                                     &lt;/complexContent&gt;
         *                                                   &lt;/complexType&gt;
         *                                                 &lt;/element&gt;
         *                                               &lt;/sequence&gt;
         *                                               &lt;attribute name="tipo_op" use="required" type="{http://eng.com/rdm/xml/model}TypeOperazione" /&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                     &lt;/sequence&gt;
         *                                     &lt;attribute name="cod_un_op" use="required"&gt;
         *                                       &lt;simpleType&gt;
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                           &lt;pattern value="[0-9]{4}"/&gt;
         *                                         &lt;/restriction&gt;
         *                                       &lt;/simpleType&gt;
         *                                     &lt;/attribute&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                           &lt;attribute name="tipo_str" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoF" /&gt;
         *                           &lt;attribute name="cod_str" use="required" type="{http://eng.com/rdm/xml/model}TypeStr8" /&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="cod_as" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;pattern value="[0-9]{6}"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="mese" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;pattern value="0[1-9]|1[012]"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *       &lt;attribute name="anno" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;pattern value="[2][0][0-9]{2}"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "as"
        })
        public static class PERIODO {

            @XmlElement(name = "AS", namespace = "http://eng.com/rdm/xml/model", required = true)
            protected List<AS> as;
            @XmlAttribute(name = "mese", required = true)
            protected String mese;
            @XmlAttribute(name = "anno", required = true)
            protected String anno;

            /**
             * Gets the value of the as property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the as property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAS().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AS }
             * 
             * 
             */
            public List<AS> getAS() {
                if (as == null) {
                    as = new ArrayList<AS>();
                }
                return this.as;
            }

            /**
             * Recupera il valore della proprietà mese.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMese() {
                return mese;
            }

            /**
             * Imposta il valore della proprietà mese.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMese(String value) {
                this.mese = value;
            }

            /**
             * Recupera il valore della proprietà anno.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAnno() {
                return anno;
            }

            /**
             * Imposta il valore della proprietà anno.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAnno(String value) {
                this.anno = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="STRUTTURA" maxOccurs="unbounded"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="DISPOSITIVO" maxOccurs="unbounded"&gt;
             *                                         &lt;complexType&gt;
             *                                           &lt;complexContent&gt;
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                               &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
             *                                               &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
             *                                               &lt;attribute name="desti_utili" use="required"&gt;
             *                                                 &lt;simpleType&gt;
             *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                                     &lt;enumeration value="00"/&gt;
             *                                                     &lt;enumeration value="01"/&gt;
             *                                                     &lt;enumeration value="02"/&gt;
             *                                                     &lt;enumeration value="03"/&gt;
             *                                                     &lt;enumeration value="04"/&gt;
             *                                                     &lt;enumeration value="05"/&gt;
             *                                                     &lt;enumeration value="0"/&gt;
             *                                                     &lt;enumeration value="1"/&gt;
             *                                                     &lt;enumeration value="2"/&gt;
             *                                                     &lt;enumeration value="3"/&gt;
             *                                                     &lt;enumeration value="4"/&gt;
             *                                                     &lt;enumeration value="5"/&gt;
             *                                                   &lt;/restriction&gt;
             *                                                 &lt;/simpleType&gt;
             *                                               &lt;/attribute&gt;
             *                                               &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
             *                                               &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
             *                                               &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
             *                                             &lt;/restriction&gt;
             *                                           &lt;/complexContent&gt;
             *                                         &lt;/complexType&gt;
             *                                       &lt;/element&gt;
             *                                     &lt;/sequence&gt;
             *                                     &lt;attribute name="tipo_op" use="required" type="{http://eng.com/rdm/xml/model}TypeOperazione" /&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/complexContent&gt;
             *                               &lt;/complexType&gt;
             *                             &lt;/element&gt;
             *                           &lt;/sequence&gt;
             *                           &lt;attribute name="cod_un_op" use="required"&gt;
             *                             &lt;simpleType&gt;
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                                 &lt;pattern value="[0-9]{4}"/&gt;
             *                               &lt;/restriction&gt;
             *                             &lt;/simpleType&gt;
             *                           &lt;/attribute&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *                 &lt;attribute name="tipo_str" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoF" /&gt;
             *                 &lt;attribute name="cod_str" use="required" type="{http://eng.com/rdm/xml/model}TypeStr8" /&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="cod_as" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;pattern value="[0-9]{6}"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "struttura"
            })
            public static class AS {

                @XmlElement(name = "STRUTTURA", namespace = "http://eng.com/rdm/xml/model", required = true)
                protected List<STRUTTURA> struttura;
                @XmlAttribute(name = "cod_as", required = true)
                protected String codAs;

                /**
                 * Gets the value of the struttura property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the struttura property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getSTRUTTURA().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link STRUTTURA }
                 * 
                 * 
                 */
                public List<STRUTTURA> getSTRUTTURA() {
                    if (struttura == null) {
                        struttura = new ArrayList<STRUTTURA>();
                    }
                    return this.struttura;
                }

                /**
                 * Recupera il valore della proprietà codAs.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodAs() {
                    return codAs;
                }

                /**
                 * Imposta il valore della proprietà codAs.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodAs(String value) {
                    this.codAs = value;
                }


                /**
                 * <p>Classe Java per anonymous complex type.
                 * 
                 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="UNIT_OP" maxOccurs="unbounded"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="DISPOSITIVO" maxOccurs="unbounded"&gt;
                 *                               &lt;complexType&gt;
                 *                                 &lt;complexContent&gt;
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                     &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
                 *                                     &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
                 *                                     &lt;attribute name="desti_utili" use="required"&gt;
                 *                                       &lt;simpleType&gt;
                 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                                           &lt;enumeration value="00"/&gt;
                 *                                           &lt;enumeration value="01"/&gt;
                 *                                           &lt;enumeration value="02"/&gt;
                 *                                           &lt;enumeration value="03"/&gt;
                 *                                           &lt;enumeration value="04"/&gt;
                 *                                           &lt;enumeration value="05"/&gt;
                 *                                           &lt;enumeration value="0"/&gt;
                 *                                           &lt;enumeration value="1"/&gt;
                 *                                           &lt;enumeration value="2"/&gt;
                 *                                           &lt;enumeration value="3"/&gt;
                 *                                           &lt;enumeration value="4"/&gt;
                 *                                           &lt;enumeration value="5"/&gt;
                 *                                         &lt;/restriction&gt;
                 *                                       &lt;/simpleType&gt;
                 *                                     &lt;/attribute&gt;
                 *                                     &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
                 *                                     &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
                 *                                     &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
                 *                                   &lt;/restriction&gt;
                 *                                 &lt;/complexContent&gt;
                 *                               &lt;/complexType&gt;
                 *                             &lt;/element&gt;
                 *                           &lt;/sequence&gt;
                 *                           &lt;attribute name="tipo_op" use="required" type="{http://eng.com/rdm/xml/model}TypeOperazione" /&gt;
                 *                         &lt;/restriction&gt;
                 *                       &lt;/complexContent&gt;
                 *                     &lt;/complexType&gt;
                 *                   &lt;/element&gt;
                 *                 &lt;/sequence&gt;
                 *                 &lt;attribute name="cod_un_op" use="required"&gt;
                 *                   &lt;simpleType&gt;
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *                       &lt;pattern value="[0-9]{4}"/&gt;
                 *                     &lt;/restriction&gt;
                 *                   &lt;/simpleType&gt;
                 *                 &lt;/attribute&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *       &lt;attribute name="tipo_str" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoF" /&gt;
                 *       &lt;attribute name="cod_str" use="required" type="{http://eng.com/rdm/xml/model}TypeStr8" /&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "unitop"
                })
                public static class STRUTTURA {

                    @XmlElement(name = "UNIT_OP", namespace = "http://eng.com/rdm/xml/model", required = true)
                    protected List<UNITOP> unitop;
                    @XmlAttribute(name = "tipo_str", required = true)
                    protected String tipoStr;
                    @XmlAttribute(name = "cod_str", required = true)
                    protected String codStr;

                    /**
                     * Gets the value of the unitop property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the Jakarta XML Binding object.
                     * This is why there is not a <CODE>set</CODE> method for the unitop property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getUNITOP().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link UNITOP }
                     * 
                     * 
                     */
                    public List<UNITOP> getUNITOP() {
                        if (unitop == null) {
                            unitop = new ArrayList<UNITOP>();
                        }
                        return this.unitop;
                    }

                    /**
                     * Recupera il valore della proprietà tipoStr.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTipoStr() {
                        return tipoStr;
                    }

                    /**
                     * Imposta il valore della proprietà tipoStr.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTipoStr(String value) {
                        this.tipoStr = value;
                    }

                    /**
                     * Recupera il valore della proprietà codStr.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodStr() {
                        return codStr;
                    }

                    /**
                     * Imposta il valore della proprietà codStr.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodStr(String value) {
                        this.codStr = value;
                    }


                    /**
                     * <p>Classe Java per anonymous complex type.
                     * 
                     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="OPERAZIONE" maxOccurs="unbounded"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="DISPOSITIVO" maxOccurs="unbounded"&gt;
                     *                     &lt;complexType&gt;
                     *                       &lt;complexContent&gt;
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                           &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
                     *                           &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
                     *                           &lt;attribute name="desti_utili" use="required"&gt;
                     *                             &lt;simpleType&gt;
                     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *                                 &lt;enumeration value="00"/&gt;
                     *                                 &lt;enumeration value="01"/&gt;
                     *                                 &lt;enumeration value="02"/&gt;
                     *                                 &lt;enumeration value="03"/&gt;
                     *                                 &lt;enumeration value="04"/&gt;
                     *                                 &lt;enumeration value="05"/&gt;
                     *                                 &lt;enumeration value="0"/&gt;
                     *                                 &lt;enumeration value="1"/&gt;
                     *                                 &lt;enumeration value="2"/&gt;
                     *                                 &lt;enumeration value="3"/&gt;
                     *                                 &lt;enumeration value="4"/&gt;
                     *                                 &lt;enumeration value="5"/&gt;
                     *                               &lt;/restriction&gt;
                     *                             &lt;/simpleType&gt;
                     *                           &lt;/attribute&gt;
                     *                           &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
                     *                           &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
                     *                           &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
                     *                         &lt;/restriction&gt;
                     *                       &lt;/complexContent&gt;
                     *                     &lt;/complexType&gt;
                     *                   &lt;/element&gt;
                     *                 &lt;/sequence&gt;
                     *                 &lt;attribute name="tipo_op" use="required" type="{http://eng.com/rdm/xml/model}TypeOperazione" /&gt;
                     *               &lt;/restriction&gt;
                     *             &lt;/complexContent&gt;
                     *           &lt;/complexType&gt;
                     *         &lt;/element&gt;
                     *       &lt;/sequence&gt;
                     *       &lt;attribute name="cod_un_op" use="required"&gt;
                     *         &lt;simpleType&gt;
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                     *             &lt;pattern value="[0-9]{4}"/&gt;
                     *           &lt;/restriction&gt;
                     *         &lt;/simpleType&gt;
                     *       &lt;/attribute&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "operazione"
                    })
                    public static class UNITOP {

                        @XmlElement(name = "OPERAZIONE", namespace = "http://eng.com/rdm/xml/model", required = true)
                        protected List<OPERAZIONE> operazione;
                        @XmlAttribute(name = "cod_un_op", required = true)
                        protected String codUnOp;

                        /**
                         * Gets the value of the operazione property.
                         * 
                         * <p>
                         * This accessor method returns a reference to the live list,
                         * not a snapshot. Therefore any modification you make to the
                         * returned list will be present inside the Jakarta XML Binding object.
                         * This is why there is not a <CODE>set</CODE> method for the operazione property.
                         * 
                         * <p>
                         * For example, to add a new item, do as follows:
                         * <pre>
                         *    getOPERAZIONE().add(newItem);
                         * </pre>
                         * 
                         * 
                         * <p>
                         * Objects of the following type(s) are allowed in the list
                         * {@link OPERAZIONE }
                         * 
                         * 
                         */
                        public List<OPERAZIONE> getOPERAZIONE() {
                            if (operazione == null) {
                                operazione = new ArrayList<OPERAZIONE>();
                            }
                            return this.operazione;
                        }

                        /**
                         * Recupera il valore della proprietà codUnOp.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCodUnOp() {
                            return codUnOp;
                        }

                        /**
                         * Imposta il valore della proprietà codUnOp.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCodUnOp(String value) {
                            this.codUnOp = value;
                        }


                        /**
                         * <p>Classe Java per anonymous complex type.
                         * 
                         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                         * 
                         * <pre>
                         * &lt;complexType&gt;
                         *   &lt;complexContent&gt;
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *       &lt;sequence&gt;
                         *         &lt;element name="DISPOSITIVO" maxOccurs="unbounded"&gt;
                         *           &lt;complexType&gt;
                         *             &lt;complexContent&gt;
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                 &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
                         *                 &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
                         *                 &lt;attribute name="desti_utili" use="required"&gt;
                         *                   &lt;simpleType&gt;
                         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                         *                       &lt;enumeration value="00"/&gt;
                         *                       &lt;enumeration value="01"/&gt;
                         *                       &lt;enumeration value="02"/&gt;
                         *                       &lt;enumeration value="03"/&gt;
                         *                       &lt;enumeration value="04"/&gt;
                         *                       &lt;enumeration value="05"/&gt;
                         *                       &lt;enumeration value="0"/&gt;
                         *                       &lt;enumeration value="1"/&gt;
                         *                       &lt;enumeration value="2"/&gt;
                         *                       &lt;enumeration value="3"/&gt;
                         *                       &lt;enumeration value="4"/&gt;
                         *                       &lt;enumeration value="5"/&gt;
                         *                     &lt;/restriction&gt;
                         *                   &lt;/simpleType&gt;
                         *                 &lt;/attribute&gt;
                         *                 &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
                         *                 &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
                         *                 &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
                         *               &lt;/restriction&gt;
                         *             &lt;/complexContent&gt;
                         *           &lt;/complexType&gt;
                         *         &lt;/element&gt;
                         *       &lt;/sequence&gt;
                         *       &lt;attribute name="tipo_op" use="required" type="{http://eng.com/rdm/xml/model}TypeOperazione" /&gt;
                         *     &lt;/restriction&gt;
                         *   &lt;/complexContent&gt;
                         * &lt;/complexType&gt;
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "dispositivo"
                        })
                        public static class OPERAZIONE {

                            @XmlElement(name = "DISPOSITIVO", namespace = "http://eng.com/rdm/xml/model", required = true)
                            protected List<DISPOSITIVO> dispositivo;
                            @XmlAttribute(name = "tipo_op", required = true)
                            protected String tipoOp;

                            /**
                             * Gets the value of the dispositivo property.
                             * 
                             * <p>
                             * This accessor method returns a reference to the live list,
                             * not a snapshot. Therefore any modification you make to the
                             * returned list will be present inside the Jakarta XML Binding object.
                             * This is why there is not a <CODE>set</CODE> method for the dispositivo property.
                             * 
                             * <p>
                             * For example, to add a new item, do as follows:
                             * <pre>
                             *    getDISPOSITIVO().add(newItem);
                             * </pre>
                             * 
                             * 
                             * <p>
                             * Objects of the following type(s) are allowed in the list
                             * {@link DISPOSITIVO }
                             * 
                             * 
                             */
                            public List<DISPOSITIVO> getDISPOSITIVO() {
                                if (dispositivo == null) {
                                    dispositivo = new ArrayList<DISPOSITIVO>();
                                }
                                return this.dispositivo;
                            }

                            /**
                             * Recupera il valore della proprietà tipoOp.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getTipoOp() {
                                return tipoOp;
                            }

                            /**
                             * Imposta il valore della proprietà tipoOp.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setTipoOp(String value) {
                                this.tipoOp = value;
                            }


                            /**
                             * <p>Classe Java per anonymous complex type.
                             * 
                             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
                             * 
                             * <pre>
                             * &lt;complexType&gt;
                             *   &lt;complexContent&gt;
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *       &lt;attribute name="tipo_dispositivo" use="required" type="{http://eng.com/rdm/xml/model}TypeDispositivo" /&gt;
                             *       &lt;attribute name="tipo_desti_utili" use="required" type="{http://eng.com/rdm/xml/model}TypeAllegatoH" /&gt;
                             *       &lt;attribute name="desti_utili" use="required"&gt;
                             *         &lt;simpleType&gt;
                             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                             *             &lt;enumeration value="00"/&gt;
                             *             &lt;enumeration value="01"/&gt;
                             *             &lt;enumeration value="02"/&gt;
                             *             &lt;enumeration value="03"/&gt;
                             *             &lt;enumeration value="04"/&gt;
                             *             &lt;enumeration value="05"/&gt;
                             *             &lt;enumeration value="0"/&gt;
                             *             &lt;enumeration value="1"/&gt;
                             *             &lt;enumeration value="2"/&gt;
                             *             &lt;enumeration value="3"/&gt;
                             *             &lt;enumeration value="4"/&gt;
                             *             &lt;enumeration value="5"/&gt;
                             *           &lt;/restriction&gt;
                             *         &lt;/simpleType&gt;
                             *       &lt;/attribute&gt;
                             *       &lt;attribute name="num_rep" use="required" type="{http://eng.com/rdm/xml/model}TypeNumRepertorio" /&gt;
                             *       &lt;attribute name="costo" use="required" type="{http://eng.com/rdm/xml/model}TypeImporto" /&gt;
                             *       &lt;attribute name="qta" use="required" type="{http://eng.com/rdm/xml/model}TypeQuantita" /&gt;
                             *     &lt;/restriction&gt;
                             *   &lt;/complexContent&gt;
                             * &lt;/complexType&gt;
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "content"
                            })
                            public static class DISPOSITIVO {

                                @XmlValue
                                protected String content;
                                @XmlAttribute(name = "tipo_dispositivo", required = true)
                                protected String tipoDispositivo;
                                @XmlAttribute(name = "tipo_desti_utili", required = true)
                                protected String tipoDestiUtili;
                                @XmlAttribute(name = "desti_utili", required = true)
                                protected String destiUtili;
                                @XmlAttribute(name = "num_rep", required = true)
                                protected long numRep;
                                @XmlAttribute(name = "costo", required = true)
                                protected String costo;
                                @XmlAttribute(name = "qta", required = true)
                                protected String qta;

                                /**
                                 * Recupera il valore della proprietà content.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getContent() {
                                    return content;
                                }

                                /**
                                 * Imposta il valore della proprietà content.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setContent(String value) {
                                    this.content = value;
                                }

                                /**
                                 * Recupera il valore della proprietà tipoDispositivo.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTipoDispositivo() {
                                    return tipoDispositivo;
                                }

                                /**
                                 * Imposta il valore della proprietà tipoDispositivo.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTipoDispositivo(String value) {
                                    this.tipoDispositivo = value;
                                }

                                /**
                                 * Recupera il valore della proprietà tipoDestiUtili.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getTipoDestiUtili() {
                                    return tipoDestiUtili;
                                }

                                /**
                                 * Imposta il valore della proprietà tipoDestiUtili.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setTipoDestiUtili(String value) {
                                    this.tipoDestiUtili = value;
                                }

                                /**
                                 * Recupera il valore della proprietà destiUtili.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getDestiUtili() {
                                    return destiUtili;
                                }

                                /**
                                 * Imposta il valore della proprietà destiUtili.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setDestiUtili(String value) {
                                    this.destiUtili = value;
                                }

                                /**
                                 * Recupera il valore della proprietà numRep.
                                 * 
                                 */
                                public long getNumRep() {
                                    return numRep;
                                }

                                /**
                                 * Imposta il valore della proprietà numRep.
                                 * 
                                 */
                                public void setNumRep(long value) {
                                    this.numRep = value;
                                }

                                /**
                                 * Recupera il valore della proprietà costo.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getCosto() {
                                    return costo;
                                }

                                /**
                                 * Imposta il valore della proprietà costo.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setCosto(String value) {
                                    this.costo = value;
                                }

                                /**
                                 * Recupera il valore della proprietà qta.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getQta() {
                                    return qta;
                                }

                                /**
                                 * Imposta il valore della proprietà qta.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setQta(String value) {
                                    this.qta = value;
                                }

                            }

                        }

                    }

                }

            }

        }

    }

}
