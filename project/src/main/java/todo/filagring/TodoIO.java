package todo.filagring;

import todo.core.Listeklasse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TodoIO implements TodoInterface {
    @Override
    public void save(Listeklasse liste) throws IOException {
        PrintWriter writer = new PrintWriter("../filagring/todo.txt");
        String s = (liste.getWord() + ",");
        writer.print(s);
        writer.flush();
        writer.close();

    }

    @Override
    public TodoObjectLoader load() throws IOException {
        Scanner scanner = new Scanner(new File("../filagring/todo.txt"));
        String[] liste = scanner.nextLine().split(",");
        scanner.close();
        Listeklasse listeord = new Listeklasse();

        TodoObjectLoader loader = new TodoObjectLoader();
        loader.liste =listeord;
        return loader;


    }
}
