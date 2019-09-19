# Kildekode for domenelaget

Domenelaget utgjøres av en samling av geo-lokasjoner representert vha. to klasse:

- LatLong - en geo-lokasjon, representert vha. lengde og breddegrad
- LatLongs - en samling LatLong-objekter

```plantuml
class LatLong {
	double latitude
	double longitude
}
class LatLongs
LatLongs *--> "*" LatLong: "latLongs"
```
