
README.MD
===


## Om appen

Denne applikasjonen skal fungere som en påminnelsesapp, hvor man kan legge til punkter for å bli minnet på disse. Når de er fullført så skal punktene fjernes fra listen. Listen skal kunne lagres og fjernes. Appen utvikles inkrementelt, og funksjonaliteten vil forbedres med tiden. 
![](https://i.imgur.com/Gx94AIO.png)



User story
---

```gherkin=
Feature: Lage TODO-liste
    # Første eksempel
  Scenario: Bruker legger til TODO-punkt
    When brukeren skriver inn punkt
    Then punktet blir lagt til i listen

    # Andre eksempel
  Scenario: Brukeren fjerner et punkt
    Given brukeren har allerede lagt inn et punkt
    When brukeren fullfører et punkt
    Then punktet fjernes fra listen
```
> I choose a lazy person to do a hard job. Because a lazy person will find an easy way to do it. [name=Bill Gates]



## Organisering av koden
Dette prosjektet tar for seg bygging av en TODO-liste. Det er en trelagsapplikasjon med domenelag, UI og lagring. Gradle blir brukt som byggesystem.

### Backend:
For core:


* `src/main/java` for koden til kjernelogikken

* `scr/main/resources` for tilhørende ressurser, f.eks. data-filer og FXML-filer, som brukes av applikasjonen.

* `scr/test/java` for testkoden

* `scr/test/resources` for tilhørende ressurser, f.eks. data-filer og FXML-filer, som brukes av testene.

for restapi:
* `src/main/java/restAPI/Controllers` for kontrollklasse

* `src/main/java/restAPI` for applikasjonsklasse 

### Frontend:

for frontend:

* `src/Components` for komponenter som gjennbrukes. Både .js-filer og css-filer. 

* `src/Input` for fil som behandler input i Todo-lista

* `src/` for hovedfiler som App.js

* `src/CSS` for alle css-filer. De har samme navn



Dokumentasjon 
---
I hver hovedmappe vil det ligge en readme.md-fil som beskriver inneholdet i denne mappen. Disse filene vil ikke være like detaljerte som denne, men gi en kort 
beskrivelse. I mappen `diagrams/` ligger alle diagramfiler laget i **PlantUML** sammen med de tilsvarende png-filene.



Domenelaget
---
Vår applikasjon lagrer oppgaver i en liste (TODO-liste). Domenelaget inneholder klasser som håndterer disse oppgavene. 

Brukergrensesnitt i React
---

Brukergrensesnittlaget inneholder alle klassene som tar for seg user-interface, og hvordan de representes gjennom visningen av data i applikasjonen.

Brukergrensesnittet er laget med React Det finner man i `frontend/src` 

Lagring
---

Lagringsaget (persistenslaget) inneholder klasser for lagring av data. Det foregår i modulen restApi

Testing
---
Du kan teste appen ved å kjøre `gradle check`, og få ut testdekningsgrad ved hjelp av `gradle jacocoTestReport`, da vil rapporten ligge i `build/reports/jacoco/src.src.test/html/index.html`.

Artkitektur
---
![Arkitektur](diagrams/diagram.png)


Diagrammer
---
#### Klassedigram for frontend:
![Klassediagram frontend](diagrams/klasseDiagramFront.png)

#### Klassediagram for backend:
![Klassediagram backend](diagrams/klasseDiagramBack.png)

#### Sekvensdiagram:
![Sekvensdiagram](diagrams/sequence.png)

---
###### tags: `Readme` `Documentation` `IT1901`
