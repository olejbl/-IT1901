
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

