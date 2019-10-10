package todo.ui;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import todo.core.Listeklasse;
import todo.filagring.TodoIO;
import todo.filagring.TodoInterface;
import todo.filagring.TodoObjectLoader;

import java.io.IOException;




public class FxAppController {

  @FXML private TextField textIn;
  @FXML private Label textOut;
  @FXML private Button btn;
  @FXML private ListView<String> listView;
    private TodoInterface io;
    private Listeklasse liste;

  @FXML
    public void initialize(){
      liste = new Listeklasse();
      io = new TodoIO();
    }

    public void add(){
        liste.wordListAdd(textIn.getText());
        ObservableList<String> items = FXCollections.observableArrayList(liste.getWordList());
        listView.setItems(items);
    }

    public void save(){
        try {
            io.save(liste);
        } catch (IOException e){
            textOut.setText("Noe gikk galt med lagring");
        }
    }

    public void load() {
        try {
            TodoObjectLoader loader = io.load();
            liste = loader.liste;
            for(String word : liste.getWordList()) {
                listView.getItems().add(word);
            }
            //listView.getItems().add(liste.getWordList().toString());

        } catch (Exception e) {
            textOut.setText("Det gikk galt med loading");
        }
    }

    public void clear() {
      liste = new Listeklasse();
      listView.getItems().clear();
    }
}
