---
title: 'Project documentation'
---

README.MD
===


## Table of Contents

[TOC]

## Organisering av koden
Dette prosjektet tar for seg bygging av en TODO-liste. Det er en trelagsapplikasjon med domenelag, UI og lagring. Gradle blir brukt som byggesystem.

* src/main/java for koden til applikasjonen

* src/main/resources for tilhørende ressurser, f.eks. data-filer og FXML-filer, som brukes av applikasjonen.

* src/test/java for testkoden

* src/test/resources for tilhørende ressurser, f.eks. data-filer og FXML-filer, som brukes av testene.


Domenelaget
---
Vår applikasjon lagrer oppgaver i en liste (TODO-liste). Domenelaget inneholder klasser som håndterer disse oppgavene. 

Brukergrensesnitt
---

Brukergrensesnittlaget inneholder alle klassene som tar for seg user-interface, og hvordan de representes gjennom visningen av data i applikasjonen.

Brukergrensesnittet er laget med JavaFX og FXML. Det finner man i src⁩/⁨main⁩/⁨java⁩/⁨todo/ui⁩

Lagring
---

Lagringsaget (persistenslaget) inneholder klasser for lagring av data. 



###### tags: `Readme` `Documentation` `IT1901`