---
title: 'project documentation'
---

Modul for kjernelogikk og lagring
===


## Domenelaget 
Domenelaget inneholder `Listeklasse` som er logikken som håndteres av applikasjonen. 

Domenelaget finnes i `core/src/main/java/todo/core`
####Test
Domenelaget testes ved klassen `Listeklassetest.java` og ligger i `core/src/test/todo/core`

For å teste bruker vi jUnit, og for å vise testdekningsgrad bruker vi jacoco. Man får ut testdekningsgrad ved hjelp av `gradle jacocoTestReport`, da vil rapporten ligge i `build/reports/jacoco/test/html/index.html`.

## Persistenslaget 
Persistenslaget handler om fillagring. Her leses og skrives av dataene i domenellaget. Vi bruker JSON til dette.

Persistenslaget finnes i `core/src/main/todo/filagring` 

####Test
Persistenslaget testes ved klassen `TestTodoIO.java` og ligger i `core/src/test/todo/filagring`

For å teste bruker vi jUnit, og for å vise testdekningsgrad bruker vi jacoco. Man får ut testdekningsgrad ved hjelp av `gradle jacocoTestReport`, da vil rapporten ligge i `build/reports/jacoco/test/html/index.html`
## Bygging med gradle 
Core-modulen bygges med gradle på samme måte som det ytre prosjektet

---

