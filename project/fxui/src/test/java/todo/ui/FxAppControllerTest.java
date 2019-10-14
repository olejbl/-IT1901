package todo.ui;


import org.junit.Assert;
import org.junit.Test;
import src.main.java.todo.ui.FxAppController;

public class FxAppControllerTest {
    private FxAppController controller;

    @Test
    public void initTest() {
        Assert.assertNull(controller);
        controller = new FxAppController();
        Assert.assertNotNull(controller);
        Assert.assertNull(controller.getListeklasse());
        controller.initialize();
        Assert.assertNotNull(controller.getListeklasse());
    }

}
