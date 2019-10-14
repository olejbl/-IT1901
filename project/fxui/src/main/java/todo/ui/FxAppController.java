package src.main.java.todo.ui;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.web.client.RestTemplate;
import todo.core.Listeklasse;
import todo.core.Todo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FxAppController {

  @FXML private TextField textIn;
  @FXML private Label textOut;
  @FXML private Button btn;
  @FXML private ListView<String> listView;
    private Listeklasse listeklasse;
    private ArrayList<Todo> arraylist = new ArrayList<>();
    private ArrayList<String> todoList = new ArrayList<>();
    private Todo todo;




    private RestClient client;
    private ObjectMapper objectMapper;
    private ObservableList<String> observableList = FXCollections.observableArrayList();



  @FXML //Initialiserer appen
    public void initialize() throws IOException {
      listeklasse = new Listeklasse(arraylist);
    }

<<<<<<< HEAD
=======

>>>>>>> df50ddb948bebdc4303ac5b557239b3b9836bfce
    public void add() throws IOException {
      ObservableList<String> items = FXCollections.observableArrayList(listeklasse.getWordList().toString());
      listView.getItems().add(String.valueOf(new Todo(textIn.getText(),true)));
      //updateTodoListView(); (metoden funker ikke)
    }


    @FXML //Lager lokalt, men er ikke meningen (har den pga. testing lokalt)
    public void save() throws Throwable {}

    //Oppdaterer listen ettersom man legger til nye elementer i den nåverende listen (funker ikke)
    private void updateTodoListView() throws IOException {
        String jsonString = client.get("/save");
        List<Todo> toDoItems = objectMapper.readValue(jsonString, new TypeReference<List<Todo>>(){});
        observableList.setAll(String.valueOf(toDoItems));
    }


    //Loader Elementer fra server (Funker ikke)

    //funskjon som skal laste inn det som ble lagret ved save()-lfunskjonen

    @FXML
    public void load() {
        Listeklasse listeklasse = new RestTemplate().getForEntity("http://localhost:8080/save/" + 0,
                Listeklasse.class).getBody();
        System.out.println(listeklasse.getWordList());


    }

    //Sletter alle elementene lagd til

    // tømmer hele lista

    public void clear() {
      listeklasse = new Listeklasse(arraylist);
      listView.getItems().clear();
    }



    //getter
    public Listeklasse getListeklasse(){
      return listeklasse;
    }

}
