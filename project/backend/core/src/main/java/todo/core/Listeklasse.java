package todo.core;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Listeklasse {

    public static ArrayList<Todo> wordList = new ArrayList<>();
    @JsonProperty("todo")
    private Todo todo;
    @JsonProperty("name")
    private String name;

    //konstruktør
    public Listeklasse() {
        // Default Konstruktør for deserializing (IKKE SLETT)
    }

    public Listeklasse(ArrayList<Todo> wordList){
        this.wordList = wordList;
    }

    public void wordListRemove(Todo todo) {
        wordList.remove(todo);
    }

    public ArrayList<Todo> getWordList() {
        return wordList;
    }
}
