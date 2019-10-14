package todo.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//testfx
//mocking

public class Listeklasse {

    private ArrayList<Todo> wordList = new ArrayList<>();
    private Todo todo;
    private String name;

    /*
    private boolean done;
    private String desc;
    @JsonCreator
    public Listeklasse(@JsonProperty("description") String desc, @JsonProperty("done") boolean done) {
        this.setDescription(desc);
        this.setDone(done);
    }
    private void setDone(boolean done) {
        this.done = done;
    }

    private void setDescription(String desc) {
        this.desc = desc;
    }*/
    public Listeklasse(ArrayList<Todo> wordList){
        this.wordList = wordList;
    }
    /*@JsonCreator
    public Listeklasse(@JsonProperty()ArrayList<Todo> wordList1){
        this.wordList = wordList;
    }
/*  //-------Kan slettes hvis Serializer og Deserializer klassene fungerer
    public Listeklasse(ArrayList<Todo> wordList) throws IOException {
        this.wordList = wordList;
        new ObjectMapper().writeValue(new File("/build/"), new Listeklasse(wordList));
        Listeklasse lestListe = new ObjectMapper().readValue(new File("/build/todo1.json"), Listeklasse.class);
    }
*/
    public void wordListAdd(Todo todo) {
        wordList.add(todo);
    }

    public void wordListRemove(Todo todo) {
        wordList.remove(todo);
    }

    public ArrayList<Todo> getWordList() {
        return wordList;
    }

    public String getName() {
        return name;
    }
}
