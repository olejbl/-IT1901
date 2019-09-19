package todo.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FxApp extends Application {

  @Override
  public void start(final Stage stage) throws Exception {
    final FXMLLoader fxmlLoader = new FXMLLoader(FxApp.class.getResource("/fxui/src/main/resources/FxApp.fxml"));
    final Parent root = (Parent) fxmlLoader.load();
    final FxAppController controller = fxmlLoader.getController();
    controller.initialize();
    final Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  public static void main(final String[] args) {
    FxApp.launch(args);
  }
}
