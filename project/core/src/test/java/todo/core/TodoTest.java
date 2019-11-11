package todo.core;

import org.junit.Assert;
import org.junit.Test;

public class TodoTest {

    private Todo todo;

    @Test
    public void initTest() {
        todo = new Todo("Hei!",1);
        Assert.assertEquals(todo.getContent(), "Hei!");
        Assert.assertEquals(todo.getId(), 1,0);
        todo.setContent("Poop");
        Assert.assertEquals(todo.getContent(), "Poop");
        todo.setId(2);
        Assert.assertEquals(todo.getId(), 2,0);
    }
}
