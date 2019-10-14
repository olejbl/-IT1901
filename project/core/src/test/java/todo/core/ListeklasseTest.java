package todo.core;

import org.junit.Assert;
import org.junit.Test;

//test av klassen Listeklasse

public class ListeklasseTest {

    private Listeklasse listeklasse;


    //sjekker om Listeklassen er null ved opprettelse og om lista er tom , noe den skal være før vi har lagt inn noe
    // oppretter et todo-objekt, legger til ord, sjekker så om ordet er riktig, tar det bort og sjekker om lista nå er tom
    // opp
     @Test
     public void initTest() {
         Assert.assertNull(listeklasse);
         listeklasse = new Listeklasse();
         Assert.assertNotNull(listeklasse);
         Assert.assertEquals(true, listeklasse.getWordList().isEmpty());
         Todo todo = new Todo("test",true);
         listeklasse.wordListAdd(todo);
         Assert.assertEquals(todo, listeklasse.getWordList().get(0));
         listeklasse.wordListRemove(todo);
         Assert.assertEquals(true, listeklasse.getWordList().isEmpty());
     }
}
