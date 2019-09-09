package todo.filagring;

import todo.core.Listeklasse;

import java.io.IOException;

public interface TodoInterface {

    void save(Listeklasse liste) throws IOException;

    TodoObjectLoader load() throws IOException;


}
