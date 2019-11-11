package server.Controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Autowired
    private ApiController controller;

    /*The @SpringBootTest annotation tells Spring Boot to go and look for
    a main configuration class (ProjectApplication),
    and use that to start a Spring application context. */
    @Test
    public void contextLoads() throws Exception {
        Assert.assertNotNull(controller);
    }

}
