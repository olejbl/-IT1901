package todo.core;

import org.junit.Assert;
import org.junit.Test;

public class TodoTest {

    private Todo todo;

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
