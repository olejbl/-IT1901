package todo.ui;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import todo.core.Listeklasse;


public class FxAppController {
  @FXML private TextField textIn;
  @FXML private TextArea textOut;
  @FXML private Button btn;
  private Listeklasse liste;

  @FXML
    public void initialize(){
      liste = new Listeklasse();
    }

    public void add(){
      liste.setWord(textIn.getText());
      textOut.setText(liste.getWord());
    }


}
