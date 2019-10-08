package todo.ui;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import todo.core.Listeklasse;
//import todo.filagring.TodoIO;
import todo.filagring.ListeklasseSerializer;
import todo.filagring.TodoInterface;
import todo.filagring.TodoObjectLoader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class FxAppController {
  @FXML private TextField textIn;
  @FXML private Label textOut;
  @FXML private Button btn;
  @FXML private ListView<String> listView;
    private TodoInterface io;
    private Listeklasse liste;
    private ListeklasseSerializer listeklasseSerializerserializer;
    private ArrayList<String> arraylist = new ArrayList<>();

  @FXML
    public void initialize(){
      liste = new Listeklasse(arraylist);
      //io = new TodoIO();
    }

    public void add(){
        liste.wordListAdd(textIn.getText());
        ObservableList<String> items = FXCollections.observableArrayList(liste.getWordList());
        listView.setItems(items);
    }

    public void save() throws Throwable {
         try {
             //io.save(liste);
             listeklasseSerializerserializer.saveToFile(liste);

         }catch (IOException e){
             textOut.setText("Noe gikk galt med lagring");
             e.printStackTrace();
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
      liste = new Listeklasse(arraylist);
      listView.getItems().clear();
    }
}
