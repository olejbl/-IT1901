package todo.filagring;

import todo.core.Listeklasse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TodoIO implements TodoInterface {
    @Override
    public void save(String filename, Listeklasse liste) throws IOException {
        PrintWriter writer = new PrintWriter(filename);
        String s = (liste.getWord());
        writer.print(s);
        writer.flush();
        writer.close();

    }

    @Override
    public TodoObjectLoader load(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        String liste = scanner.nextLine();
        scanner.close();
        Listeklasse listeord = new Listeklasse();

        TodoObjectLoader loader = new TodoObjectLoader();
        loader.liste =listeord;
        return loader;


    }
}
