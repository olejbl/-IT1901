package todo.core;

import java.util.ArrayList;

public class Listeklasse {

    private ArrayList<String> wordList = new ArrayList<String>();

    public Listeklasse(ArrayList<String> wordList){
        this.wordList = wordList;
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
