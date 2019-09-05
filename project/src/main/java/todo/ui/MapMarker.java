package todo.ui;

import fxmapcontrol.Location;
import fxmapcontrol.MapItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import todo.core.LatLong;

public class MapMarker extends MapItem<LatLong> {

  public MapMarker(final LatLong latLong) {
    setLocation(latLong);
    final Circle circle = new Circle();
    circle.setRadius(5);
    circle.setFill(Color.BLUE);
    getChildren().add(circle);
  }

  public final void setLocation(final LatLong latLong) {
    setLocation(new Location(latLong.getLatitude(), latLong.getLongitude()));
  }
}
