# Kildekode for brukergrensesnittet

Brukergrensesnittet er laget med JavaFX og FXML.

Brukergrensesnittet er enkelt og består av en liste og et kart. Lista viser innholdet i et **LatLongs**-objekt, altså en samling **LatLong**-objekter. Når man velger et element, så vises det elementet som et punkt på kartet. En kan flytte punktet, forskyve kartet, zoome inn og ut og opprette nye **LatLong**-objekter. 

Kartet implementeres av ([FxMapControl](https://github.com/ClemensFischer/FX-Map-Control), og siden biblioteket ikke er tilgjengelig i et sentral repository, så har vi bygget og lagt ved jar-filen.

I tillegg kan en lagre og lese inn **LatLongs**-objektet fra **Open...**- og **Save...**-aksjoner i en **File**-meny.

```plantuml
class FxAppController
class LatLongs
class BorderPane
class "ListView<LatLong>" as ListView
class "fxmapcontrol.MapBase" as MapBase

BorderPane *--> ListView: "left"
BorderPane *--> MapBase: "center"

FxAppController --> LatLongs: "latLongs"
FxAppController --> MapBase: "mapView"
FxAppController --> ListView: "locationListView"
```
