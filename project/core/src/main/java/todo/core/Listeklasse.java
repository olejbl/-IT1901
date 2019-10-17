package todo.core;

import java.util.ArrayList;


public class Listeklasse {

    public static ArrayList<Todo> wordList = new ArrayList<>();
    private Todo todo;
    private String name;

    //konstruktør
    public Listeklasse(ArrayList<Todo> wordList){
        this.wordList = wordList;
    }

    public Listeklasse(){

    }

    //legger til todo i wordList
    public void wordListAdd(Todo todo) {
        wordList.add(todo);
    }
    //tar bort todo fra wordList
    public void wordListRemove(Todo todo) {
        wordList.remove(todo);
    }
    //getter
    public ArrayList<Todo> getWordList() {
        return wordList;
    }

}
