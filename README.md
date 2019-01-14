# oldfashionpound
### Task
Si realizzi un package OldFashionPound che implementa le 4 operazioni fondamentali (somma,
sottrazione, moltiplicazione e divisione) di prezzi secondo il sistema monetario inglese
antecedente al 1970 (1 sterlina=20 scellini, 1 scellino=12 pennies).

Un prezzo nel sistema monetario inglese antecedente al 1970 è definito nel seguente modo:
* p=sterline
* s=scellini
* d=pence

Ad esempio un prezzo di 12p 6s 10d indica 12 sterline, 6 scellini e 10 pence

La somma e la sottrazione devono essere in grado di sommare e sottrarre due prezzi
* Esempio somma: 5p 17s 8d + 3p 4s 10d= 9p 2s 6d
* Esempio sottrazione: 5p 17s 8d - 3p 4s 10d= 2p 12s 10d

La moltiplicazione e divisione ricevono in input un prezzo e un intero (la divisione per valori
decimali non è prevista)
* Esempio moltiplicazione: 5p 17s 8d * 2 = 11p 15 s 4d
* Esempio divisione 5p 17s 8d / 3 = 1p 19s 2d - 2a (avanzano 2penny - nell’output divisione
indicare il resto con 2a separato dal risultato col segno -)

### Utilizzo
`java -jar oldfashionpound-1.0.jar "5p 17s 8d + 3p 4s 10d"`

produce l'output

`5p 17s 8d + 3p 4s 10d = 9p 2s 6d`

### Possibili miglioramenti
* Le eccezioni causate dalla validazione potrebbero avere dei messaggi più user friendly
* Inserimento di log
