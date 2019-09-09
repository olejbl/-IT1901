package todo.ui;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import todo.core.Listeklasse;
import todo.filagring.TodoIO;
import todo.filagring.TodoInterface;
import todo.filagring.TodoObjectLoader;

import java.io.IOException;


public class FxAppController {
  @FXML private TextField textIn;
  @FXML private TextArea textOut;
  @FXML private Button btn;
  private TodoInterface io;
  private Listeklasse liste;

  @FXML
    public void initialize(){
      liste = new Listeklasse();
      io = new TodoIO();
    }

    public void add(){
      liste.setWord(textIn.getText());
      textOut.setText(liste.getWord());
    }

    public void save(){
      try {
        io.save(liste);
      } catch (IOException e){
      textOut.setText("Noe gikk galt med lagring");
      }
    }

    public void load(){
    try{
      TodoObjectLoader loader = io.load();
      liste =  loader.liste;
      textOut.setText(liste.getWord());

    } catch (Exception e){
      textOut.setText("Det gikk galt med loading");
    }

    }


}
