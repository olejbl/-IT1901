package todo.ui;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FxAppControllerTest {
    private FxAppController controller;

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
