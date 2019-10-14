package todo.ui;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import todo.core.Listeklasse;
import todo.core.Todo;
import todo.filagring.TodoInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FxAppController {

  @FXML private TextField textIn;
  @FXML private Label textOut;
  @FXML private Button btn;
  @FXML private ListView<String> listView;
    private TodoInterface io;
    private Listeklasse listeklasse;
    private ArrayList<Todo> arraylist = new ArrayList<>();
    private ArrayList<String> todoList = new ArrayList<>();
    private Todo todo;
    private Serializer serializer;




    private RestClient client;
    private ObjectMapper objectMapper;
    private ObservableList<String> observableList = FXCollections.observableArrayList();


  @FXML //Initialiserer appen
    public void initialize() throws IOException {
      listeklasse = new Listeklasse(arraylist);
    }

<<<<<<< HEAD
    public void add() throws IOException {
      ObservableList<String> items = FXCollections.observableArrayList(listeklasse.getWordList().toString());
      listView.getItems().add(String.valueOf(new Todo(textIn.getText(),true)));
      //updateTodoListView(); (metoden funker ikke)
    }
=======
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
>>>>>>> e07e8b5dab8327786a0982846f45e3e31cbc6ffa

    @FXML //Lager lokalt, men er ikke meningen (har den pga. testing lokalt)
    public void save() throws Throwable {}

    //Oppdaterer listen ettersom man legger til nye elementer i den nåverende listen (funker ikke)
    private void updateTodoListView() throws IOException {
        String jsonString = client.get("/save");
        List<Todo> toDoItems = objectMapper.readValue(jsonString, new TypeReference<List<Todo>>(){});
        observableList.setAll(String.valueOf(toDoItems));
    }

    //Loader Elementer fra server (Funker ikke)
    @FXML
    public void load() {
        Listeklasse listeklasse = new RestTemplate().getForEntity("http://localhost:8080/save/" + 0,
                Listeklasse.class).getBody();
        System.out.println(listeklasse.getWordList());

    }

    //Sletter alle elementene lagd til
    public void clear() {
      listeklasse = new Listeklasse(arraylist);
      listView.getItems().clear();
    }










}
