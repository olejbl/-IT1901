package src.main.java.todo.ui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import todo.core.Listeklasse;
import todo.core.Todo;
import todo.filagring.TodoInterface;

import java.io.IOException;
import java.util.ArrayList;

//import todo.filagring.TodoIO;
//import todo.filagring.ListeklasseSerializer;




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
    private Serializer serializer;




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

    @FXML
    public void save() throws Throwable {
         try {
             //io.save(listeklasse);
             //listeklasseSerializerserializer.saveToFile(liste);
             System.out.println("heihei");
             serializer1.doSerializing(listeklasse);

         }catch (IOException e){
             textOut.setText("Noe gikk galt med lagring");
             e.printStackTrace();
         }


    }

    @FXML
    public void load() {
        ResponseEntity<Listeklasse> listeklasse1 = new RestTemplate().getForEntity("http://localhost:8080/hei/",// + 0,
                Listeklasse.class);//.getBody();
        //System.out.println(listeklasse1.getName());

        /*try {
            TodoObjectLoader loader = io.load();
            listeklasse = loader.liste;
            for(Todo word : listeklasse.getWordList()) {
                //listView.getItems().add(word);
            }
            //listView.getItems().add(liste.getWordList().toString());

        } catch (Exception e) {
            textOut.setText("Det gikk galt med loading");
        }*/
    }


    public void clear() {
      listeklasse = new Listeklasse(arraylist);
      listView.getItems().clear();
    }

    public Listeklasse getListeklasse(){
      return listeklasse;
    }
}
