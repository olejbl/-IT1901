package todo.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import fxmapcontrol.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import todo.core.LatLong;
import todo.core.LatLongs;
import todo.json.LatLongsModule;

import java.io.*;

/*
@startuml
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
@enduml
 */

public class FxAppController {

  private LatLongs latLongs;

  public FxAppController() {
    latLongs = new LatLongs();
  }

  public LatLongs getLatLongs() {
    return latLongs;
  }

  // to make it testable
  public void setLatLongs(final LatLongs latLongs) {
    this.latLongs = latLongs;
    updateLocationViewList(0);
  }

  // @FXML
  // private FileMenuController fileMenuController;

  @FXML
  private ListView<LatLong> locationListView;

  @FXML
  private MapBase mapView;

  private MapItemsControl<MapNode> markersParent;
  private MapMarker marker = null;
  private DraggableNodeController draggableMapController = null;
  private DraggableNodeController draggableMarkerController = null;

  @FXML
  private Slider zoomSlider;

  @FXML
  private void initialize() {
    // map stuff
    // mapView.getChildren().add(MapTileLayer.getOpenStreetMapLayer());
    zoomSlider.valueProperty()
    .addListener((prop, oldValue, newValue) -> mapView.setZoomLevel(zoomSlider.getValue()));
    zoomSlider.setValue(8);
    markersParent = new MapItemsControl<MapNode>();
    mapView.getChildren().add(markersParent);
    draggableMapController = new DraggableNodeController(this::handleMapDragged);
    draggableMapController.setImmediate(true);
    draggableMapController.attach(mapView);
    draggableMarkerController = new DraggableNodeController(this::handleMarkerDragged);
    // the location list
    locationListView.getSelectionModel().selectedIndexProperty()
    .addListener((prop, oldValue, newValue) -> updateMapMarker(true));
  }

  private void handleMapDragged(final Node node, final double dx, final double dy) {
    final MapProjection projection = mapView.getProjection();
    final Point2D point = projection.locationToViewportPoint(mapView.getCenter());
    final Location newCenter = projection.viewportPointToLocation(point.add(-dx, -dy));
    mapView.setCenter(newCenter);
  }

  private void handleMarkerDragged(final Node node, final double dx, final double dy) {
    final MapProjection projection = mapView.getProjection();
    final Point2D point = projection.locationToViewportPoint(marker.getLocation());
    final Location newLocation = projection.viewportPointToLocation(point.add(dx, dy));
    getLatLongs().setLatLong(locationListView.getSelectionModel().getSelectedIndex(),
        location2LatLong(newLocation));
    updateLocationViewListSelection(false);
  }

  private LatLong location2LatLong(final Location newLocation) {
    return new LatLong(newLocation.getLatitude(), newLocation.getLongitude());
  }

  private void updateMapMarker(final boolean centerOnMarker) {
    final int num = locationListView.getSelectionModel().getSelectedIndex();
    if (num < 0 || num >= getLatLongs().getLatLongCount()) {
      markersParent.getItems().clear();
      if (draggableMarkerController != null) {
        draggableMarkerController.detach(marker);
      }
      marker = null;
    } else {
      final LatLong latLong = getLatLongs().getLatLong(num);
      if (marker == null) {
        marker = new MapMarker(latLong);
        markersParent.getItems().add(marker);
        if (draggableMarkerController != null) {
          draggableMarkerController.attach(marker);
        }
      } else {
        marker.setLocation(latLong);
      }
      if (centerOnMarker) {
        mapView.setCenter(marker.getLocation());
      }
    }
  }

  @FXML
  private void handleAddLocation() {
    final Location center = mapView.getCenter();
    final int pos = getLatLongs().addLatLong(location2LatLong(center));
    updateLocationViewList(pos);
  }

  private void updateLocationViewListSelection(final Boolean updateMapMarker) {
    final int selectedIndex = locationListView.getSelectionModel().getSelectedIndex();
    updateLocationViewListItem(selectedIndex);
    if (updateMapMarker != null) {
      updateMapMarker(updateMapMarker);
    }
  }

  private void updateLocationViewListItem(final int index) {
    locationListView.getItems().set(index, getLatLongs().getLatLong(index));
  }

  private void updateLocationViewList(int selectedIndex) {
    final LatLong[] latLongs = new LatLong[getLatLongs().getLatLongCount()];
    for (int i = 0; i < latLongs.length; i++) {
      latLongs[i] = getLatLongs().getLatLong(i);
    }
    final int oldSelectionIndex = locationListView.getSelectionModel().getSelectedIndex();
    locationListView.setItems(FXCollections.observableArrayList(latLongs));
    if (selectedIndex < 0 || selectedIndex >= latLongs.length) {
      selectedIndex = oldSelectionIndex;
    }
    if (selectedIndex >= 0 && selectedIndex < getLatLongs().getLatLongCount()) {
      locationListView.getSelectionModel().select(selectedIndex);
    }
  }

  // File menu items

  private FileChooser fileChooser;

  private FileChooser getFileChooser() {
    if (fileChooser == null) {
      fileChooser = new FileChooser();
    }
    return fileChooser;
  }

  @FXML
  void handleOpenAction(final ActionEvent event) {
    final FileChooser fileChooser = getFileChooser();
    final File selection = fileChooser.showOpenDialog(null);
    if (selection != null) {
      try (InputStream input = new FileInputStream(selection) ){
        setLatLongs(getObjectMapper().readValue(input, LatLongs.class));
      } catch (final IOException e) {
        showExceptionDialog("Oops, problem when opening " + selection, e);
      }
    }
  }

  private ObjectMapper objectMapper;

  public ObjectMapper getObjectMapper() {
    if (objectMapper == null) {
      objectMapper = new ObjectMapper();
      objectMapper.registerModule(new LatLongsModule());
    }
    return objectMapper;
  }

  private void showExceptionDialog(final String message) {
    final Alert alert = new Alert(AlertType.ERROR, message, ButtonType.CLOSE);
    alert.showAndWait();
  }

  private void showExceptionDialog(final String message, final Exception e) {
    showExceptionDialog(message + ": " + e.getLocalizedMessage());
  }

  private void showSaveExceptionDialog(final File location, final Exception e) {
    showExceptionDialog("Oops, problem saving to " + location, e);
  }

  @FXML
  void handleSaveAction() {
    final FileChooser fileChooser = getFileChooser();
    final File selection = fileChooser.showSaveDialog(null);
    if (selection != null ) {
      try (OutputStream outputStream = new FileOutputStream(selection, false)) {
        getObjectMapper().writeValue(outputStream, getLatLongs());
      } catch (final IOException e) {
        showSaveExceptionDialog(selection, e);
      }
    }
  }
}
