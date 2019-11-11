
modul for REST-api
===

## REST-api
Inneholder klassene `ApiController.java`, `ProjectApplication.java`, `ReadWriteJSON.java` og `Service.java`. 

Vi bruker springboot til å lage rest-api og server. Det gjør at vi ikke trenger å lage egne klasser for serialisering og deserialisering i persisitenslaget. 
Oppretter lokal server med localhost. Serveren kjører på port _8080_

## Lagring
Vi har flytta lagring, persistenslaget, over til rest-api-modulen. Her skjer serialisering og deserialisering, som lagrer data på serveren så vi ikke trenger å lagre lokalt. 

## Bygging med gradle 
Som de andre modulene bygges også rest-api-et med gradle. 
