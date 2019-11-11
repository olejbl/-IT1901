package server.Controllers;

import todo.core.Listeklasse;

import java.io.IOException;

@org.springframework.stereotype.Service
public class Service {

    private ReadWriteJSON readWriteJSON;

    //Service klassen provides en måte å lese til og fra fil, for apicontroller
    public Service() {
        readWriteJSON = new ReadWriteJSON();
    }

    public Listeklasse getAll() throws IOException {
        return readWriteJSON.readListeklasse();
    }

    public void saveListeklasse(Listeklasse listeklasse) throws IOException {
        System.out.println("In Service");
        readWriteJSON.writeTodos(listeklasse);
    }
}
