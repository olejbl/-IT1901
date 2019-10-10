package todo.ui;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import todo.core.Listeklasse;
//import todo.filagring.TodoIO;
import todo.core.Todo;
//import todo.filagring.ListeklasseSerializer;
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
    private Listeklasse listeklasse;
    //private ListeklasseSerializer listeklasseSerializerserializer;
    private ArrayList<Todo> arraylist = new ArrayList<>();
    private ArrayList<String> todoList = new ArrayList<>();
    private Todo todo;

  @FXML
    public void initialize(){
      listeklasse = new Listeklasse(arraylist);
      //io = new TodoIO();
    }

    public void add(){
        //listeklasse.wordListAdd(listeklasse.);
        ObservableList<String> items = FXCollections.observableArrayList(listeklasse.getWordList().toString());
        //listView.setItems(items);

        listView.getItems().add(String.valueOf(new Todo(textIn.getText(),true)));
    }

    public void save() throws Throwable {
         try {
             io.save(listeklasse);
             //listeklasseSerializerserializer.saveToFile(liste);

         }catch (IOException e){
             textOut.setText("Noe gikk galt med lagring");
             e.printStackTrace();
         }


    }

    public void load() {
        try {
            TodoObjectLoader loader = io.load();
            listeklasse = loader.liste;
            for(Todo word : listeklasse.getWordList()) {
                //listView.getItems().add(word);
            }
            //listView.getItems().add(liste.getWordList().toString());

        } catch (Exception e) {
            textOut.setText("Det gikk galt med loading");
        }
    }

    public void clear() {
      listeklasse = new Listeklasse(arraylist);
      listView.getItems().clear();
    }
}
