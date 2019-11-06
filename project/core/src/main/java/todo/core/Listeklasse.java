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


    //legger til todo i wordList
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

    /*public void wordListAdd(Todo todo) {
        wordList.add(todo);
    }*/

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
