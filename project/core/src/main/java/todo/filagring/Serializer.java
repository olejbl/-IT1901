package todo.filagring;

import com.fasterxml.jackson.databind.ObjectMapper;
import todo.core.Listeklasse;
import java.io.File;
import java.io.IOException;

//Serializer på Listeklasse klassen
public class Serializer {

    private Listeklasse listeklasse;

    public Serializer() throws IOException {
        new ObjectMapper().writeValue(new File("src/src.main.resources/json/src.src.test.json"), new Listeklasse(listeklasse.getWordList()));
    }

    public static void main(String[] args) {

    }
}
