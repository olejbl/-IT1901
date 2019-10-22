package todo.ui;


import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import todo.core.Listeklasse;
import todo.core.Todo;
import java.io.IOException;
import java.util.ArrayList;

public class FxAppController {

  @FXML private TextField textIn;
  @FXML private Label textOut;
  @FXML private Button btn;
  @FXML private ListView<String> listView;
    private Listeklasse listeklasse;
    private ArrayList<Todo> arraylist = new ArrayList<>();
    private RestClient client;
    private ObjectMapper objectMapper;


  @FXML //Initialiserer appen
    public void initialize() throws IOException {
      listeklasse = new Listeklasse(arraylist);
      objectMapper = new ObjectMapper();
      client = new RestClient();
    }

    //Adder et Todoo object til listen og listview
    public void add() throws IOException {
      Todo todo = new Todo(textIn.getText(),true);
      listView.getItems().add(String.valueOf(todo));
      listeklasse.wordListAdd(todo);
    }

    @FXML //kjører update list
    public void save() throws Throwable {
      updateTodoListView();
    }

    //Oppdaterer listen ettersom man legger til nye elementer i den nåverende listen (får inn doble verdier)
    private void updateTodoListView() throws IOException {
      String response = client.post("/save", listeklasse);
      System.out.println(response);
    }

    //funskjon som skal laste inn det som ligger på serveren (skrives bare ut atm.)
    @FXML
    public void load() {
      System.out.println(client.get("/all"));
    }

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

