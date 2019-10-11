package todo.filagring;

import com.fasterxml.jackson.databind.ObjectMapper;
import todo.core.Listeklasse;
import java.io.File;
import java.io.IOException;
import java.util.List;

//Serializer på Listeklasse klassen
public class Serializer {

    private Listeklasse listeklasse;

    public void doSerializing(Listeklasse listeklassetest) throws IOException {
        System.out.println("test");
        new ObjectMapper().writeValue(new File("/../../../resources/json/test.json"), listeklassetest);

    }

    public static void main(String[] args) {

    }
}

























