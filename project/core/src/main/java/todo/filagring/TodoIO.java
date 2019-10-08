package todo.filagring;

import todo.core.Listeklasse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
public class TodoIO implements TodoInterface {

    @Override
    public void save(Listeklasse liste) throws IOException {
        PrintWriter writer = new PrintWriter("src/main/java/todo/filagring/todo.txt");
        String words = "";
        for(String word : liste.getWordList()){
            words += (word +",");
        }
        writer.println(words);
        writer.flush();
        writer.close();

    }
    /*
    @Override
    public TodoObjectLoader load() throws IOException {
        Scanner scanner = new Scanner(new File("src/main/java/todo/filagring/todo.txt"));
        String[] liste = scanner.nextLine().split(",");
        scanner.close();
        Listeklasse listeord = new Listeklasse();
        for (int i=0; i <liste.length; i++) {
            listeord.wordListAdd(liste[i]);
        }

        TodoObjectLoader loader = new TodoObjectLoader();
        loader.liste = listeord;
        return loader;
    }

*/
