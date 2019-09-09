package todo.filagring;

import todo.core.Listeklasse;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TodoIO implements TodoInterface {
    @Override
    public void save(Listeklasse liste) throws IOException {
        PrintWriter writer = new PrintWriter("src/main/java/todo/filagring/todo.txt");
        String s = (liste.getWord());
        System.out.println(s);
        writer.println(s);
        //writer.flush();
        writer.close();

    }

    @Override
    public TodoObjectLoader load() throws IOException {
        Scanner scanner = new Scanner(new File("src/main/java/todo/filagring/todo.txt"));
        String word = scanner.nextLine();
        scanner.close();
        Listeklasse listeord = new Listeklasse();
        listeord.setWord(word);

        TodoObjectLoader loader = new TodoObjectLoader();
        loader.liste =listeord;
        return loader;


    }
}
