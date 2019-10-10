package restAPI.src.main.java.gr1919.project.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //REST API TEST denne linjen
public class ApiController {
    //For rest API//
    @GetMapping("/hei")
    public String welcome() {
        return "welcome";
    }
//Slutt for rest API
}


