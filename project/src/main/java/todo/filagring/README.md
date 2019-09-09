# Kildekode for persistenslaget

Persistenslaget bruker [Jackson-biblioteket](https://github.com/FasterXML/jackson) for å serialisere objekter til [JSON](https://www.json.org).

For hver [domeneklasse](../core/README.md) finnes tilsvarende klasser for serialisering (konvertering av domeneobjekter til tekststrøm) og deserialisering (parsing av tekststrøm og opprettelse av tilsvarende domeneobjekter). I tillegg finnes det en klasse, **JacksonConfigurator**, som inneholder diverse metoder for å lage og konfigurere **ObjectMapper**- og **SimpleModule**-objektene som trengs for å serialisere og deserialisere objekter.
