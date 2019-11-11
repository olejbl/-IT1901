package server.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mock;

    @MockBean
    private Service service;

    /*We use @MockBean to create and inject a mock for the Service class,
    and we set its expectations using Mockito.*/
    @Test
    public void getAllGivesResponseFromServer() throws Exception {
        when(service.getAll()).thenReturn(service.getAll());
        this.mock.perform(get("/all")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(service.getAll().toString())));
    }
}
