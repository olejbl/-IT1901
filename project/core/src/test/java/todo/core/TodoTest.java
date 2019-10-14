package todo.core;

import org.junit.Assert;
import org.junit.Test;
 //test av klassen Todo
public class TodoTest {

    private Todo todo;


    //oppretter todo-objekt, setter description til "hei", og done til false. Så sjekker om det er riktig med assertEquals. Setter setDone til true og sjekker om
    // dette stemmer nå.
    @Test
    public void initTest() {
        todo = new Todo("Hei!",false);
        Assert.assertEquals(todo.getDescription(), "Hei!");
        Assert.assertEquals(todo.getDone(), false);
        todo.setDone(true);
        Assert.assertEquals(todo.getDone(),true);
        todo.setDescription("Poop");
        Assert.assertEquals(todo.getDescription(), "Poop");
    }
}
