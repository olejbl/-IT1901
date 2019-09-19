package todo.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ListeklasseTest {

    private Listeklasse listeklasse = new Listeklasse();

     @Test
     public void wordTest() {
         Assert.assertEquals(true, listeklasse.getWordList().isEmpty());
         listeklasse.wordListAdd("git");
         Assert.assertEquals("git", listeklasse.getWordList().get(0));
     }
}
