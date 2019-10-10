package todo.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Listeklasse {

    private ArrayList<String> wordList = new ArrayList<String>();
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
    }


    public Listeklasse(ArrayList<String> wordList) throws IOException {
        this.wordList = wordList;
        new ObjectMapper().writeValue(new File("/build/"), new Listeklasse(wordList));
        Listeklasse lest_liste = new ObjectMapper().readValue(new File("/build/todo1.json"), Listeklasse.class);
    }

    public void wordListAdd(String word) {
        wordList.add(word);
    }

    public void wordListRemove(String word) {
        wordList.remove(word);
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

}
