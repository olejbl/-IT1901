package todo.filagring;

import com.fasterxml.jackson.databind.ObjectMapper;
//import restAPI.src.main.java.gr1919.project.Controllers.ApiController;
import todo.core.Listeklasse;
import java.io.File;
import java.io.IOException;
import java.util.List;

//Serializer på Listeklasse klassen
public class Serializer {


    //public restAPI.src.main.java.gr1919.project.Controllers.ApiController apiController;
    private Listeklasse listeklasse;

    public Serializer() throws IOException {
      //  new ObjectMapper().writeValue(new File("resources/json/json.text"), new Listeklasse(listeklasse.getWordList()));
    }

}

//RequestEntety + url   FxuiController
//build/et eller annet.json  ApiController
//filepath = url