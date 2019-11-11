package server.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import todo.core.Listeklasse;
import java.io.File;
import java.io.IOException;

public class ReadWriteJSON {

    //Denne klassen skriver til og leser fra server

    private ObjectMapper objectMapper;
    private static File path = new File("save.json");

    public ReadWriteJSON() {
        objectMapper = new ObjectMapper();
    }

    public void writeTodos(Listeklasse listeklasse) throws IOException {
        System.out.println("In read write");
        objectMapper.writeValue(path, "");
        objectMapper.writeValue(path, listeklasse);
    }

    public Listeklasse readListeklasse() throws IOException {
        return objectMapper.readValue(path, Listeklasse.class);
    }
}