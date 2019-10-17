package todo.ui;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

//Test av klassen FxAppController

public class FxAppControllerTest {
    private FxAppController controller;

    // Tester at controller blir initialisert på riktig måte at den er null før og ikke null etter
    @Test
    public void initTest() throws IOException {
        Assert.assertNull(controller);
        controller = new FxAppController();
        Assert.assertNotNull(controller);
        Assert.assertNull(controller.getListeklasse());
        controller.initialize();
        Assert.assertNotNull(controller.getListeklasse());
    }

}
