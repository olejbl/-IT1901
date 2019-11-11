package todo.core;

import org.junit.Assert;
import org.junit.Test;

public class ListeklasseTest {

    private Listeklasse listeklasse;

     @Test
     public void initTest() {
         Assert.assertNull(listeklasse);
         listeklasse = new Listeklasse();
         Assert.assertNotNull(listeklasse);
         Assert.assertEquals(true, listeklasse.getWordList().isEmpty());
         Todo todo = new Todo("test",1);
         listeklasse.getWordList().add(todo);
         Assert.assertEquals(todo, listeklasse.getWordList().get(0));
         listeklasse.wordListRemove(todo);
         Assert.assertEquals(true, listeklasse.getWordList().isEmpty());
     }
}

