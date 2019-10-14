package restAPI.src.main.java.gr1919.project.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import todo.core.Todo;

import java.util.ArrayList;

@RestController //REST API TEST denne linjen
public class ApiController {
    //For rest API//
    @GetMapping("/hei")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/src/src.test")
    public ArrayList<Todo> getWordList() {
        return todo.core.Listeklasse.wordList;
    }
//Slutt for rest API
}


