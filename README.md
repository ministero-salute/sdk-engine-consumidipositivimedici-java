# **1 Introduzione**

## ***1.1 Obiettivi del documento***

Il Ministero della Salute (MdS) metterà a disposizione degli Enti, da cui riceve dati,  applicazioni SDK specifiche per flusso logico e tecnologie applicative (Java, PHP e C#) per verifica preventiva (in casa Ente) della qualità del dato prodotto.

![](img/Aspose.Words.15dc6452-d384-4da1-98ac-525688916e4b.002.png)

Nel presente documento sono fornite la struttura e la sintassi dei tracciati previsti dalla soluzione SDK per avviare il proprio processo elaborativo e i controlli di merito sulla qualità, completezza e coerenza dei dati.

Gli obiettivi del documento sono:

- fornire una descrizione funzionale chiara e consistente dei tracciati di input a SDK;
- fornire le regole funzionali per la verifica di qualità, completezza e coerenza dei dati.

In generale, la soluzione SDK è costituita da 2 diversi moduli applicativi (Access Layer e Validation Engine) per abilitare:

- l’interoperabilità con il contesto tecnologico dell’Ente in cui la soluzione sarà installata;
- la validazione del dato ed il suo successivo invio verso il MdS.

La figura che segue descrive la soluzione funzionale ed i relativi benefici attesi.

![](img/Aspose.Words.15dc6452-d384-4da1-98ac-525688916e4b.003.png)

## ***1.2 Acronimi***

Nella tabella riportata di seguito sono elencati tutti gli acronimi e le definizioni adottate nel presente documento.


|**#**|**Acronimo / Riferimento**|**Definizione**|
| - | - | - |
|1|AO|Azienda ospedaliera|
|2|AOU|Azienda Ospedaliera Universitaria|
|3|ASL|Azienda sanitaria locale|
|4|CSM|Centro Salute Mentale|
|5|ESTAV|Enti per i Servizi Tecnico-amministrativi di Area Vasta|
|6|IRCCS|Istituto di ricovero e cura a carattere scientifico|
|7|MRA|Monitoraggio della Rete di Assistenza|
|8|RDM|Repertorio dei Dispositivi Medici|
|9|RSA|Residenza Sanitaria Assistenziale|
|10|SERT|Servizi per le Tossicodipendenze|
|11|SSN|Servizio Sanitario Nazionale|
|12|SDK|Software Development Kit|
|13|XML|eXtensible Markup Language|
|14|XSD|XML Schema Definition|


# **2 Architettura SDK**

## ***2.1 Architettura funzionale***

Di seguito una rappresentazione architetturale del processo di gestione e trasferimento dei flussi dall’ente verso l’area MdS attraverso l’utilizzo dell’applicativo SDK, e il corrispondente diagramma di sequenza.

![DiagramDescription automatically generated](img/Aspose.Words.15dc6452-d384-4da1-98ac-525688916e4b.004.jpeg)

![A picture containing graphical user interfaceDescription automatically generated](img/Aspose.Words.15dc6452-d384-4da1-98ac-525688916e4b.005.png)

1. L’utente dell’ente caricherà in una apposita directory (es. /sdk/input/) il flusso sorgente.  L’utente avvierà l’SDK passando in input una serie di parametri descritti in dettaglio al paragrafo 3.1
1. La componente Access Layer estrae dalla chiamata dell’ente i parametri utilizzati per lanciare l’SDK,  genera un identificativo ID\_RUN, e un file chiamato “{ID\_RUN}.json” in cui memorizza le informazioni dell’esecuzione.
1. I record del flusso verranno sottoposti alle logiche di validazione e controllo definite nel Validation Engine. Nel processare il dato, il Validation Engine acquisirà da MdS eventuali anagrafiche di validazione del dato stesso.
1. Generazione del file degli scarti contenente tutti i record in scarto con evidenza degli errori riscontrati. I file di scarto saranno memorizzati in cartelle ad hoc (es. /sdk/esiti).
1. Tutti i record che passeranno i controlli verranno inseriti in un file xml copiato in apposita cartella (es /sdk/xml\_output), il quale verrà eventualmente trasferito a MdS utilizzando la procedura “invioFlussi” esposta da GAF WS (tramite PDI). A fronte di un’acquisizione, il MdS fornirà a SDK un identificativo (ID\_UPLOAD) che sarà usato da SDK sia per fini di logging che di recupero del File Unico degli Scarti.
1. A conclusione del processo di verifica dei flussi, il Validation Engine eseguirà le seguenti azioni:

 a. Aggiornamento file contentente il riepilogo dell’esito dell’elaborazione del Validation Engine e del ritorno dell’esito da parte di MdS. I file contenente l’esito dell’elaborazione saranno memorizzati in cartelle ad hoc (es. /sdk/run).

 b. Consolidamento del file di log applicativo dell’elaborazione dell’SDK in cui sono disponibili una serie di informazioni tecniche (Es. StackTrace di eventuali errori).

 c. Copia del file generato al punto 5, se correttamente inviato al MdS, in apposita cartella (es. /sdk/sent).

Ad ogni step del precedente elenco e a partire dal punto 2, l’SDK aggiornerà di volta in volta il file contenente l’esito dell’elaborazione.

**Nota: l’SDK elaborerà un solo file di input per esecuzione.**

In generale, le classi di controllo previste su Validation Engine sono:

- Controlli FORMALI (es. correttezza dei formati e struttura record)
- Controlli SINTATTICI (es. check correttezza del Codice Fiscale)
- Controlli di OBBLIGATORIETÀ DEL DATO (es. Codice Prestazione su flusso…)
- Controlli STRUTTURE FILE (es. header/footer ove applicabile)
- Controlli di COERENZA CROSS RECORD
- Controlli di corrispondenza dei dati trasmessi con le anagrafiche di riferimento;
- Controlli di esistenza di chiavi duplicate nel file trasmesso rispetto alle chiavi logiche individuate per ogni tracciato.

Si sottolinea che la soluzione SDK non implementa controlli che prevedono la congruità del dato input con la base date storica (es non viene verificato se per un nuovo inserimento (Tipo = I) la chiave del record non sia già presente sulla struttura dati MdS).

## ***2.2 Architettura di integrazione***

La figura sottostante mostra l’architettura di integrazione della soluzione SDK con il MdS. Si evidenzia in particolare che:

- Tutti i dati scambiati fra SDK e MdS saranno veicolati tramite Porta di Interoperabilità (PDI);
- Il MdS esporrà servizi (API) per il download di dati anagrafici;
- SDK provvederà ad inviare vs MdS l’output (record validati) delle proprie elaborazioni. A fronte di tale invio, il MdS provvederà a generare un identificativo di avvenuta acquisizione del dato (ID\_UPLOAD) che SDK memorizzerà a fini di logging.


![](img/Aspose.Words.15dc6452-d384-4da1-98ac-525688916e4b.006.png)


# **3 Funzionamento della soluzione SDK**

In questa sezione è descritta le specifica di funzionamento del flusso **CNS**  per l’alimentazione dello stesso.

## ***3.1 Input SDK***

In fase di caricamento del file verrano impostati i seguenti parametri che andranno in input al SDK in fase di processamento del file:

|**NOME PARAMETRO**|**DESCRIZIONE**|**LUNGHEZZA**|**DOMINIO VALORI**|
| :- | :- | :- | :- |
|ID CLIENT|Identificativo univoco della trasazione che fa richiesta all'SDK|100|Non definito|
|NOME FILE INPUT|Nome del file per il quale si richiede il processamento lato SDK|256|Non definito|
|ANNO RIFERIMENTO|Stringa numerica rappresentante l’anno di riferimento per cui si intende inviare la fornitura|4|Anno (Es. 2022)|
|PERIODO RIFERIMENTO|Stringa alfanumerica rappresentante il periodo per il quale si intende inviare la fornitura|2|**13** (rappresenta un alias per il quale MDS usa come data di competenza l’anno e il mese di riferimento del record piuttosto che il parametro periodo di riferimento passato in input alla procedura InvioFlussi)|
|TIPO TRASMISSIONE |Indica se la trassmissione dei dati verso MDS avverrà il modalità full (F) o record per record (R). Per questo flusso la valorizzazione del parametro sarà impostata di default a F|1|F/R|
|FINALITA' ELABORAZIONE|Indica se i flussi in output prodotti dal SDK verranno inviati verso MDS (Produzione) oppure se rimarranno all’interno del SDK e il processamento vale solo come test del flusso (Test)|1|Produzione/Test|
|CODICE REGIONE|<p>Individua la Regione a cui afferisce la struttura. Il codice da utilizzare è quello a tre caratteri definito con DM 17 settembre 1986, pubblicato nella Gazzetta Ufficiale n.240 del 15 ottobre 1986, e successive modifiche, utilizzato anche nei modelli per le rilevazioni delle attività gestionali ed economiche delle Aziende unità sanitarie locali.</p><p></p>|3|Es. 010|

## ***3.2 Tracciato input a SDK***

Il flusso di input avrà formato **csv** posizionale e una naming convention libera a discrezione dell’utente che carica il flusso senza alcun vincolo di nomenclatura specifica (es nome\_file.csv). Il separatore per il file csv sarà la combinazione di caratteri tra doppi apici: “~“

All’interno delle specifiche dei tracciati riportati nei paragrafi successivi sono indicati i dettagli dei campi di business del tracciato di input atteso da SDK, il quale differisce per i flussi dell’area CDM. All’interno di tale file è presente la colonna **Posizione nel file** la quale rappresenta l’ordinamento delle colonne del tracciato di input da caricare all’SDK.

Di seguito la tabella in cui è riportata la specifica del tracciato di input per il flusso in oggetto:

|**Nome campo**|**Posizione nel File**|**Key**|**Descrizione**|**Tipo** |**Obbligatorietà**|**Informazioni di Dominio**|**Lunghezza campo**|**XPATH Tracciato Output**|
| :-: | :- | :- | :-: | :-: | :-: | :-: | :-: | :-: |
|Codice Regione|1|KEY|Codice della Regione territorialmente competente|AN|OBB|Valori di riferimento riportati nell’Allegato A|3|/dataroot/REGIONE/@cod_reg|
|Codice Azienda Sanitaria|2|KEY|Codice che identifica l’azienda sanitaria utilizzatrice (Azienda sanitaria locale o equiparata, Azienda Ospedaliera, Istituto di Ricovero e Cura a Carattere scientifico pubblico anche se trasformato in fondazione, Azienda Ospedaliera Universitaria integrata con il SSN)|AN|OBB|Per AO, IRCCS e AOU indicare il codice del modello HSP11, per le altre indicare il codice del modello FLS.11 (ASL, ESTAV)|6|/dataroot/REGIONE/PERIODO/AS/@cod_as|
|Tipo struttura utilizzatrice|3|KEY|Tipologia di struttura utilizzatrice (struttura di ricovero, altra struttura sanitaria, istituto o centro di riabilitazione, farmacia territoriale convenzionata, istituto penitenziario, ASL)|AN|OBB|Valori di riferimento riportati nell’Allegato F. Se il campo non è disponibile, utilizzare "00".|2|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/@tipo_str|
|Codice struttura utilizzatrice|4|KEY|Codice identificativo della struttura utilizzatrice|AN|OBB|Valori di riferimento riportati nell’Allegato G. Se il campo non è disponibile, utilizzare "00000000"|8|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/@cod_str|
|Codice unità operativa|5|KEY|Identificativo del reparto utilizzatore, nel solo caso di strutture di ricovero|AN|OBB|Codici modelli HSP12. Se il campo non è disponibile, utilizzare "0000"|4|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/@cod_un_op|
|Anno di consegna|6|KEY|Anno in cui è avvenuta la distribuzione interna del dispositivo medico|N|OBB|formato AAAA|4|/dataroot/REGIONE/PERIODO/@anno|
|Mese di consegna|7|KEY|Mese in cui è avvenuta la distribuzione interna del dispositivo medico|AN|OBB|formato MM|2|/dataroot/REGIONE/PERIODO/@mese|
|Tipo dispositivo medico|8|KEY|Codice che indica la tipologia di dispositivo medico oggetto di rilevazione (dispositivo di classe o assemblato)|N|OBB|Valori di riferimento riportati nell’Allegato E|1|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/OPERAZIONE/DISPOSITIVO/@tipo_dispositivo|
|Identificativo di iscrizione in Banca Dati/ Repertorio|9|KEY|Identificativo di iscrizione in Banca Dati/Repertorio (BD/RDM) del dispositivo medico.|N|OBB|Campo numerico|13|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/OPERAZIONE/DISPOSITIVO/@num_rep|
|Tipo destinazione di utilizzo|10|KEY|Macro tipologia di destinazione dei dispositivi utilizzati (consumo interno, distribuzione diretta o distribuzione per conto)|A|OBB|Valori di riferimento riportati nell’Allegato H|1|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/OPERAZIONE/DISPOSITIVO/@tipo_desti_utili|
|Destinazione di utilizzo|11|KEY|Destinazione dei dispositivi utilizzati|AN|OBB|Valori di riferimento riportati nell’Allegato I per tipo destinazione di utilizzo I (consumo interno) e nell’Allegato J per tipo destinazione di utilizzo D (distribuzione diretta) e P (distribuzione per conto)|2|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/OPERAZIONE/DISPOSITIVO/@desti_utili|
|Quantità distribuita|12| |Numero di unità di ciascun dispositivo medico consegnate alla struttura, al netto dei resi|N|OBB|Valore numerico compreso fra 0 e 999999999999.99 Sono ammessi valori negativi utilizzando il segno “-“ prima del valore nel caso in cui, nel periodo di riferimento, i resi siano superiori alle consegne|15|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/OPERAZIONE/DISPOSITIVO/@qta|
|Costo d'acquisto|13| |Costo sostenuto per l’acquisto dei dispositivi comprensivo di IVA. Per costo di acquisto si intende, quindi, il costo complessivo sostenuto per acquistare le quantità indicate nel campo “Quantità distribuita”|N|OBB|Valore numerico compreso tra 0 e 99999999.99999. Sono ammessi valori negativi utilizzando il segno “-“ prima del valore nel caso in cui, nel periodo di riferimento, i resi siano superiori alle consegne.|14|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/OPERAZIONE/DISPOSITIVO/@costo|
|Tipo operazione|14| |Campo tecnico utilizzato per distinguere la trasmissione di informazioni nuove, modificate o eventualmente annullate. Va utilizzato il codice “I” per la trasmissione di informazioni nuove o per la ritrasmissione di informazioni precedentemente scartate dal sistema di acquisizione. Va utilizzato il codice “V” per la trasmissione di informazioni per le quali si intende fare effettuare una soprascrittura dal sistema di acquisizione. Va utilizzato il codice “C” per la trasmissione di informazioni per le quali si intende fare effettuare una cancellazione dal sistema di acquisizione.|A|OBB|Valori ammessi: - I: Inserimento - V: Variazione - C: Cancellazione|1|/dataroot/REGIONE/PERIODO/AS/STRUTTURA/UNIT_OP/OPERAZIONE/@tipo_op|

## ***3.3 Controlli di validazione del dato (business rules)***

Di seguito sono indicati i controlli da configurare sulla componente di Validation Engine e rispettivi error code associati riscontrabili sui dati di input per il flusso **CNS**.

Gli errori sono solo di tipo scarti (mancato invio del record).

Al verificarsi anche di un solo errore di scarto, tra quelli descritti, il record oggetto di controllo sarà inserito tra i record scartati.

Business Rule non implementabili lato SDK:

- Storiche (Business Rule che effettuano controlli su dati già acquisiti/consolidati che non facciano parte del dato anagrafico)
- Transazionali (Business Rule che effettuano controlli su record, i quali rappresentano transazioni, su cui andrebbe garantito l’ACID (Atomicità-Consistenza-Isolamento-Durabilità))
- Controllo d’integrità (cross flusso) (Business Rule che effettuano controlli sui record utilizzando informazioni estratte da record di altri flussi)

Di seguito le BR per il flusso in oggetto:

| | | | | | | | | | |
|-|-|-|-|-|-|-|-|-|-|
|**CAMPO**|**CODICE ERRORE**|**DESCRIZIONE ERRORE**|**DESCRIZIONE MDS**|**DESCRIZIONE ALGORITMO**|**TABELLA ANAGRAFICA**|**CAMPI DI COERENZA**|**SCARTI/ANOMALIE**|**TIPOLOGIA BR**|**TIPOLOGIA CONTROLLO BR**|
|cod_as|XSD_1|Coerenza dominio valori|Espressione regolare: [0-9]{6}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|cod_un_op|XSD_2|Coerenza dominio valori|Espressione regolare: [0-9]{4}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|tipo_str|XSD_3|Coerenza dominio valori|Valori ammessi: 00, 01, 02, 03, 04, 05, 06| | | | | | |
|cod_str|XSD_4|Coerenza dominio valori|Stringa composta da minimo 1 carattere a massimo 8|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|anno|XSD_5|Coerenza dominio valori|Espressione regolare: [2][0][0-9]{2}|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|mese|XSD_6|Coerenza dominio valori|Espressione regolare: 0[1-9]"|1[012]|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|tipo_dispositivo|XSD_7|Coerenza dominio valori|Valori ammessi: 1 o 2|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|num_rep|XSD_8|Coerenza dominio valori|Valori ammessi: Interi da 1 a 9999999999999|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|desti_utili|XSD_9|Coerenza dominio valori|Valori ammessi: 00, 01, 02, 03, 04, 05, 0, 1, 2, 3, 4, 5|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|qta|XSD_10|Coerenza dominio valori|Espressione regolare: -{0,1}[0-9]{1,12}(\.[0-9]{1,2})?|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|costo|XSD_11|Coerenza dominio valori|Espressione regolare: -{0,1}[0-9]{1,8}(\.[0-9]{1,5})?|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|tipo_op|XSD_12|Coerenza dominio valori|Valori ammessi: I, V, C|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|tipo_desti_utili|XSD_13|Coerenza dominio valori|Valori ammessi: I, D, P|Non Definito|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Codice Regione|B01|Errore codice regione|Il parametro Codice Regione passato in input all'SDK non coincide con il campo del tracciato|Il parametro Codice Regione passato in input all'SDK deve coincidere con il campo cod_reg del tracciato di input. Inoltre il codice deve essere presente in anagrafica.|Il parametro Codice Regione passato in input all'SDK deve coincidere con il campo cod_reg del tracciato di input. Inoltre il valore del campo cod_reg del tracciato di input deve essere presente all'interno della query Anagrafica Regioni.   Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query.  |Regioni|Scarti|Anagrafica|SINTATTICI|
|Anno di consegna; Mese di consegna|B03|Errore periodo di riferimento|La data di invio del file deve essere successiva al periodo di riferimento. Questo errore viene restituito quando il periodo a cui si riferiscono i dati all’interno del file è successivo alla data di invio del file.|La data di esecuzione dell'SDK deve essere maggiore rispetto all'ultimo giorno del periodo (anno-mese) di riferimento nel tracciato di input |Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Codice Azienda Sanitaria|B80|Errore formato dati comunicati|Per la stessa azienda sanitaria non possono essere comunicati contemporaneamente dati aggregati e dati di dettaglio. Questo errore viene restituito quando all’interno dello stesso file sono presenti per la stessa azienda sanitaria record con diverso livello di aggregazione, ad esempio sono presenti record aggregati per azienda sanitaria e record dettagliati fino alla struttura utilizzatrice/unità operativa per la stessa ASL.|Data una ASL (cod_as), raggruppare tutti i record associati alla particolare ASL.  Tali record devono avere lo stesso livello di dettaglio tra loro, ovvero  devono avere valorizzati tutti i campi con valori diversi da tutti '0', oppure i record devono avere gli stessi campi tra loro valorizzati con tutti '0' (zero).  I campi su cui effettuare il controllo sono Tipo Struttura Utilizzatrice (può assumere 00), Codice Struttura Utilizzatrice (può assumere 00000000) e Codice Unità Operativa (può assumere 0000).  Nota: livello di dettaglio maggiore singifica che meno campi sono valorizzati con '0' (zero). Il livello di dettaglio massimo si ha quando tutti i campi sono valorizzati con valori diversi da '0' (zero)|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Codice unità operativa|B84|Errore unità operativa|E’ stata valorizzata l’unità operativa ma la struttura indicata non è una struttura di ricovero. Questo errore viene restituito quando viene valorizzato il campo Codice unità operativa con un valore diverso da quello fittizio ‘0000’ ma il campo Tipo struttura utilizzatrice è diverso da ‘01’ ovvero non è una struttura di ricovero.|Se cod_un_op è diverso da "0000", allora il campo tipo_str deve essere uguale a "01"|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Tipo destinazione utilizzo|B89|Errore tipo destinazione utilizzo|La destinazione di utilizzo indicata non corrisponde al tipo di destinazione di utilizzo (Consumo Interno).  Questo errore viene restituito quando su un record è presente il campo Tipo destinazione di utilizzo =’I’ ma il valore riportato sul campo Destinazione di utilizzo non è relativo al Consumo Interno|Se tipo_desti_utili è uguale a "I" allora il campo desti_utili deve essere ugugale ad uno dei seguenti valori: 0,1,2,3,4,5|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Tipo destinazione utilizzo|B90|Errore tipo destinazione utilizzo|La destinazione di utilizzo indicata non corrisponde al tipo di destinazione di utilizzo (Distribuzione Diretta).  Questo errore viene restituito quando su un record è presente il campo Tipo destinazione di utilizzo =’D’ ma il valore riportato sul campo Destinazione di utilizzo non è relativo al Consumo Interno|Se tipo_desti_utili è uguale a "D" allora il campo desti_utili deve essere ugugale ad uno dei seguenti valori: 01, 02, 04, 04, 05|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Tipo destinazione utilizzo|B91|Errore tipo destinazione utilizzo|La destinazione di utilizzo indicata non corrisponde al tipo di destinazione di utilizzo (Distribuzione per Conto).  Questo errore viene restituito quando su un record è presente il campo Tipo destinazione di utilizzo =’P’ ma il valore riportato sul campo Destinazione di utilizzo non è relativo al Consumo Interno|Se tipo_desti_utili è uguale a "D" allora il campo desti_utili deve essere ugugale ad uno dei seguenti valori: 01, 02, 04, 04, 05|Non Definito|Non Definito|Scarti|Basic|SINTATTICI|
|Tipo struttura utilizzatrice; Codice struttura utilizzatrice|B92|Errore struttura|Il campo tipo struttura deve essere valorizzato (con valore diverso dal fittizio) se è valorizzato (con valore diverso dal fittizio) il codice struttura e viceversa Questo errore viene restituito quando i campi Tipo struttura utilizzatrice e Codice struttura utilizzatrice sono tra essi incompatibili ovvero quando l’uno è valorizzato con il valore fittizio e l’altro no e viceversa. Il valore fittizio è ‘00’ per Tipo struttura utilizzatrice e ‘00000000’ per Codice struttura utilizzatrice, dunque o sono entrambi fittizi o sono entrambi valorizzati.|Se e solo se tipo_str è uguale a "00" allora cod_str deve essere uguale a "00000000". Ovvero, il record non è valido se tipo_str è "00" e cod_str non è "00000000", o viceversa.|Non Definito|Tipo struttura utilizzatrice; Codice struttura utilizzatrice|Scarti|Basic|SINTATTICI|
|Codice Azienda Sanitaria|D01|Errore di dominio codice AS|Il codice azienda non esiste per la regione inviata. Questo errore viene restituito quando, il codice AS inviato non è presente in anagrafica.|la coppia  (cod_reg, cod_asl) del tracciato di input deve essere presente all'interno dell'anagrafica ASL.  Le anagrafiche devono essere filtrate sulla condizione:   il periodo (campi "anno" e "mese") di riferimento del tracciato di input deve essere compreso tra le date di validità riportate nelle colonne DAT_INI_VLD, DAT_END_VLD_EFT della query. |ASL|Non Definito|Scarti|Anagrafica|SINTATTICI|
|Codice struttura utilizzatrice|D80|Errore struttura utilizzatrice|Il codice inviato si riferisce ad una Struttura non valida. Questo errore viene restituito quando, il codice struttura inviato si riferisce ad un codice corretto ma che non è valido nel periodo di riferimento del file.|Se tipo_str non è uguale a "00", allora cod_str deve essere presente in anagrafica.  NB: il periodo di riferimento (anno-mese) deve essere compresto tra le date di validità del record anagrafico|Strutture utilizzatrici|Tipo struttura utilizzatrice|Scarti|Anagrafica|SINTATTICI|
|Identificativo di iscrizione in Banca Dati/ Repertorio|D81|Errore numero repertorio Dispositivo di Classe|Il numero di repertorio inviato non corrisponde a nessun Dispositivo Medico di Classe presente nella Banca Dati dei Dispositivi Medici. Questo errore viene restituito quando, il numero di repertorio del dispositivo medico di classe inviato non è presente in anagrafica.|Se tipo_dispositivo='1' allora il campo num_rep deve essere presente in anagrafica.|Dispositivi|Tipo Dispositivo|Scarti|Anagrafica|SINTATTICI|
|Identificativo di iscrizione in Banca Dati/ Repertorio|D83|Errore numero repertorio Assemblato|Il numero di repertorio inviato non corrisponde a nessun Assemblato presente nella Banca Dati dei Dispositivi Medici. Questo errore viene restituito quando, il numero di repertorio dell’assemblato inviato non è presente in anagrafica.|Se tipo_dispositivo='2' allora il campo num_rep deve essere presente in anagrafica.|Assemblati|Tipo Dispositivo|Scarti|Anagrafica|SINTATTICI|
|Codice unità operativa|D85|Errore di dominio codice Unità Operativa|Il codice dell’Unità Operativa inviato non esiste. Questo errore viene restituito quando, il codice dell’unità operativa inviato non è presente in anagrafica.|Il cod_un_op può essere uguale a "0000" OR  [i primi due caratteri di cod_un_op devono essere presenti in anagrafica Codici Unità Operative AND gli ultimi due caratteri di cod_un_op trasformati in intero devono valere tra 0 e 99] |Codici Unità Operative|Non Definito|Scarti|Anagrafica|SINTATTICI|

## ***3.4 Accesso alle anagrafiche***

I controlli applicativi saranno implementati a partire dall’acquisizione dei seguenti dati anagrafici disponibili in ambito MdS e recuperati con servizi ad hoc (Service Layer mediante PDI):

- Regioni 
- ASL
- Strutture utilizzatrici
- Codici Unità Operative
- Dispositivi
- Assemblati
- Allegato 1 – Elenco CND per merceologie DPCM 24 dicembre 2015

All’interno del file **censimento\_anagrafiche** sono presenti per ogni anagrafica il dettaglio implementativo (Query SQL) e la tabella fisica da cui alimentare l’anagrafica.

Il dato anagrafico sarà presente sottoforma di tabella composta da tre colonne:

- Valore (in cui è riportato il dato, nel caso di più valori, sarà usato il carattere # come separatore)

- Data inizio validità (rappresenta la data di inizio validità del campo Valore)
 - Formato: AAAA-MM-DD
 - Notazione inizio validità permanente: **1900-01-01**


- Data Fine Validità (rappresenta la data di fine validità del campo Valore)
  - Formato: AAAA-MM-DD
  - Notazione fine validità permanente: **9999-12-31**

Affinchè le Business Rule che usano il dato anagrafico per effettuare controlli siano correttamente funzionanti, occorre controllare che la data di competenza del record su cui si effettua il controllo (la quale varia in base alla componente) sia compresa tra le data di validità (ove presenti).

Di seguito viene mostrato un caso limite di anagrafica in cui sono presenti delle sovrapposizioni temporali e contraddizioni di validità permanente/specifico range.


|ID|VALUE|VALID\_FROM|VALID\_TO|
| - | - | - | - |
|1|VALORE 1|1900-01-01|9999-12-31|
|2|VALORE 1|2015-01-01|2015-12-31|
|3|VALORE 1|2018-01-01|2023-12-31|
|4|VALORE 1|2022-01-01|2024-12-31|


Diremo che :  il dato presente sul tracciato di input è valido se e solo se:

∃ VALUE\_R = VALUE\_A “tale che” VALID\_FROM<= **DATA\_COMPETENZA** <= VALID\_TO

(Esiste almeno un valore compreso tra le date di validità)

Dove:

- ` `VALUE\_R rappresenta i campi del tracciato di input coinvolti nei controlli della specifica BR

- VALUE\_A rappresenta i campi dell’anagrafica coinvolti nei controlli della specifica BR

- VALID\_FROM/VALID\_TO rappresentano le colonne dell’anagrafica

- DATA\_COMPETENZA rappresenta un campo sul tracciato di input con cui controllare il dato anagrafico (composto da anno e mese di riferimento).


## ***3.5 Alimentazione MdS***

### **3.5.1 Invio Flussi**

A valle delle verifiche effettuate dal Validation Engine, qualora il caricamento sia stato effettuato con il parametro Tipo Elaborazione impostato a P, verranno inviati verso MdS tutti i record corretti secondo le regole di validazione impostate.

Verrà richiamata la procedura invioFlussi di GAF WS (tramite PDI) alla quale verranno passati in input i parametri così come riportati nella seguente tabella:

|**NOME PARAMETRO**|**VALORIZZAZIONE**|
| :- | :- |
|ANNO RIFERIMENTO|Parametro ANNO RIFERIMENTO in input a SDK|
|PERIODO RIFERIMENTO|Parametro PERIODO RIFERIMENTO in input a SDK |
|CATEGORIA FLUSSI|CDM|
|NOME FLUSSO|CNS|
|NOME FILE|Parametro popolato dall’SDK in fase di invio flusso con il nome file generato dal Validation Engine in fase di produzione file.|


### **3.5.2 Flussi di Output per alimentazione MdS**

Il flussi generati dall’SDK saranno presenti sotto la cartella /sdk/xml\_output e dovranno essere salvati e inviati verso MdS rispettando la seguente nomenclatura:

**SDK\_CDM\_CNS\_{Periodo di riferimento}\_{ID\_RUN}.xml**

Dove :

- ID\_RUN rappresenta l’identificativo univoco
- Periodo di riferimento rappresenta il periodo specificato in input al SDK


### **3.5.3 Gestione Risposta Mds**

A valle della presa in carico del dato da parte di MdS, SDK riceverà una response contenente le seguenti informazioni:

1. **codiceFornitura**: stringa numerica indicante l’identificativo univoco della fornitura inviata al GAF
1. **errorCode**: stringa alfanumerica di 256 caratteri rappresentante il codice identificativo dell’errore eventualmente riscontrato
1. **errorText**: stringa alfanumerica di 256 caratteri rappresentante il descrittivo dell’errore eventualmente riscontrato
1. Insieme delle seguenti triple, una per ogni file inviato:
1. **idUpload**: stringa numerica indicante l’identificativo univoco del singolo file ricevuto ed accettato dal MdS, e corrispondente al file inviato con la denominazione riportata nell’elemento “nomeFile” che segue
1. **esito**: stringa alfanumerica di 4 caratteri rappresentante l’esito dell’operazione (Vedi tabella sotto)
1. **nomeFile**: stringa alfanumerica di 256 caratteri rappresentante il nome dei file inviati.

Di seguito la tabella di riepilogo dei codici degli esiti possibili dell’invio del file


|**ESITO**|**DESCRIZIONE**|
| :- | :- |
|AE00|Errore di autenticazione al servizio|
|IF00|Operazione completata con successo|
|IF01|Incongruenza tra CF utente firmatario e cf utente inviante|
|IF02|Firma digitale non valida|
|IF03|Firma digitale scaduta|
|IF04|Estensione non ammessa|
|IF05|Utente non abilitato all’invio per la Categoria Flusso indicata|
|IF06|Utente non abilitato all’invio per il Flusso indicata|
|IF07|Periodo non congurente con la Categoria Flusso indicata|
|IF08|Il file inviato è vuoto|
|IF09|Errore interno al servizio nella ricezione del file|
|IF10|Il numero di allegati segnalati nel body non corrisponde al numero di allegati riscontrati nella request|
|IF11|Il nome dell’allegato riportato nel body non è presente tra gli allegati della request (content-id)|
|IF12|Presenza di nomi file duplicati|
|IF13|Errore interno al servizio nella ricezione del file|
|IF14|Errore interno al servizio nella ricezione del file|
|IF15|Errore interno al servizio nella ricezione del file|
|IF99|Errore generico dell’operation|

Copia dei file inviati verso MdS il cui esito è positivo (ovvero risposta della procedura Invio Flussi con IF00) saranno trasferiti e memorizzati in una cartella ad hoc di SDK (es. /sdk/sent) rispettando la stessa naming descritta per i flussi di output.


## ***3.6 Scarti di processamento***

In una cartella dedicata (es. /sdk/esiti) verrà creato un file json contenente il dettaglio degli scarti riscontrati ad ogni esecuzione del processo SDK.

Il naming del file sarà:  ESITO\_{ID\_RUN}.json

Dove:

- ID\_RUN rappresenta l’identificativo univoco dell’elaborazione

Di seguito il tracciato del record da produrre.


|**CAMPO**|**DESCRIZIONE**|
| :- | :- |
|NUMERO RECORD|Numero del record del flusso input|
|RECORD PROCESSATO|Campi esterni rispetto al tracciato, che sono necessari per la validazione dello stesso.|
||Record su cui si è verificato uno scarto, riportato in maniera strutturata (nome\_campo-valore).|
|LISTA ESITI|<p>Lista di oggetti contenente l’esito di validazione per ciascun campo:</p><p>- Campo: nome campo su cui si è verificato uno scarto</p><p>- Valore Scarto: valore del campo su cui si è verificato uno scarto</p><p>- Valore Esito: esito di validazione del particolare campo</p><p>- Errori Validazione: contiene i campi Codice (della Business Rule) e Descrizione (della Business Rule)</p>|

## ***3.7 Informazioni dell’esecuzione***

In una cartella dedicata (es. /sdk/run) verrà creato un file contenente il dettaglio degli esiti riscontrati ad ogni esecuzione del processo SDK. Verrà prodotto un file di log per ogni giorno di elaborazione.

Il naming del file sarà:  

{ID\_RUN}.json

Dove:

- ID\_RUN rappresenta l’identificativo univoco dell’elaborazione

Di seguito il tracciato del record da produrre.

|**CAMPO**|**DESCRIZIONE**|
| :- | :- |
|ID RUN (chiave)|Identificativo univoco di ogni esecuzione del SDK|
|ID\_CLIENT|Identificativo Univoco della trasazione sorgente che richiede processamento lato SDK|
|ID UPLOAD (chiave)|Identificativo di caricamento fornito da MdS|
|TIPO ELABORAZIONE|F (full)/R (per singolo record) - Impostato di default a F|
|MODALITA’ OPERATIVA|P (=produzione) /T (=test)|
|DATA INIZIO ESECUZIONE|Timestamp dell’ inizio del processamento|
|DATA FINE ESECUZIONE|Timestamp di completamento del processamento|
|STATO ESECUZIONE |<p>Esito dell’esecuzione dell’ SDK. </p><p>Possibili valori: </p><p>- IN ELABORAZIONE: Sdk in esecuzione;</p><p>- ELABORATA: Esecuzione completata con successo;</p><p>- KO: Esecuzione fallita: </p><p>- KO SPECIFICO: Esecuzione fallita per una fase/componente più rilevante della soluzione (es. ko\_gestione\_file, ko\_gestione\_validazione, ko\_invio\_ministero, etc.); </p><p>- KO GENERICO: un errore generico non controllato.</p>|
|FILE ASSOCIATI RUN|Nome del file di input elaborato dall’SDK|
|NOME FLUSSO|Valore fisso che identifica lo specifico SDK in termini di categoria e nome flusso|
|NUMERO RECORD |Numero di record del flusso input|
|NUMERO RECORD ACCETTATI|Numero validi|
|NUMERO RECORD SCARTATI|Numero scarti|
|VERSION|Versione del SDK (Access Layer e Validation Engine)|
|TIMESTAMP CREAZIONE|Timestamp creazione della info run|
|API (\*DPM)|Rappresenta L’API utilizzata per il flusso DPM (non valorizzata per gli altri flussi)|
|IDENTIFICATIVO SOGGETTO ALIMENTANTE (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|TIPO ATTO (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|NUMERO ATTO (\*DPM)|Chiave flusso DPM (non valorizzata per gli altri flussi)|
|TIPO ESITO MDS (\*DPM)|Esito della response dell’API 2 (non valorizzata per gli altri flussi) |
|DATA RICEVUTA MDS (\*DPM)|Data della response dell’API 3 (non valorizzata per gli altri flussi)|
|CODICE REGIONE|Codice Regione del Mittente|
|ANNO RIFERIMENTO|Anno cui si riferiscono i dati del flusso|
|PERIODO DI RIFERIMENTO|Rappresenta il periodo di riferimento passato in input all’SDK|
|DESCRIZIONE STATO ESECUZIONE |Specifica il messaggio breve dell’errore, maggiori informazioni saranno presenti all’interno del log applicativo|
|NOME FILE OUTPUT MDS|Nome dei file di output inviati verso MdS|
|ESITO ACQUISIZIONE FLUSSO|Codice dell’esito del processo di acquisizione del flusso su MdS. Tale campo riflette la proprietà invioFlussiReturn/listaEsitiUpload/item/esito della response della procedura **invioFlussi**. (Es IF00)|
|CODICE ERRORE INVIO FLUSSI|Codice d’errore della procedura di invio. Tale campo riflette la proprietà InvioFlussiReturn/errorCode della response della procedura **invioFlussi**|
|TESTO ERRORE INVIO FLUSSI|Descrizione codice d’errore della procedura.Tale campo riflette la proprietà InvioFlussiReturn/ errorText della response della procedura **invioFlussi**|

Inoltre, a supporto dell’entità che rappresenta lo stato dell’esecuzione, sotto la cartella /sdk/log, saranno presenti anche i file di log applicativi (aggregati giornalmente) non strutturati, nei quali saranno presenti informazioni aggiuntive, ad esempio lo StackTrace (in caso di errori).

Il naming del file, se non modificata la politica di rolling (impostazioni) è il seguente:

**SDK \_CDM-CNS.log**

## mantainer:
 Accenture SpA until January 2026
