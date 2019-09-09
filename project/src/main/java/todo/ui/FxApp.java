package todo.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FxApp extends Application {

  @Override
  public void start(final Stage primaryStage) throws Exception {
    primaryStage.setTitle("My Application");
    primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("FxApp.fxml"))));
    primaryStage.show();

  }

  public static void main(final String[] args) {
    FxApp.launch(args);
  }
}
