package todo.filagring;

import com.fasterxml.jackson.databind.ObjectMapper;
import todo.core.Listeklasse;
import java.io.File;
import java.io.IOException;

//Desrializer på Listeklasse klassen
public class Deserializer {

    public Deserializer() throws IOException {
        System.out.println("test");
        Listeklasse listeklasse = new ObjectMapper().readValue(new File("/build/todo1.json"), Listeklasse.class);
    }
}
