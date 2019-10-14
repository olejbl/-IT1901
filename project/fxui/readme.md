---
title: 'project documentation'
---

modul for brukergrensesnitt
===


## Brukergrensesnittlaget
I dette lager ligger alt som har med det vi kan se, altså frontend. 
Vi bruker JavaFX og Scenebuilder til å lage utseende på applikasjonen vår. 

Meningen er å koble `RestClient.java`opp mot `FxAppController.java`slik at man kan bruke metoder som GET og POST i kontrollerklassen for å kommunsiere med server. 

Oppsettet er som følger:

* `src/main/java/todoui/FxApp` er 
* `src/main/java/todoui/FxAppController` er kontrollerklassen
* `src/main/resources/todoui/FxAppfxml` er fxml-filen som gjenspeiler hvordan vi vi lagde appen i scenebuilder  

#### Test 
Brukergrensesnittet testes ved `FxAppControllerTest.java`  som ligger under `src/test/java/todo/ui`. 
For å teste bruker vi **jUnit**. 

## Bygging med gradle
Som i de andre modulene bruker vi gradle til å bygge prosjektet

___


