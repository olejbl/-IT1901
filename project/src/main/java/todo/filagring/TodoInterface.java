package todo.filagring;

import todo.core.Listeklasse;

import java.io.IOException;

public interface TodoInterface {

    void save(String filname, Listeklasse liste) throws IOException;

    TodoObjectLoader load(String filename) throws IOException;


}
