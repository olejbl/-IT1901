package server.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import todo.core.Listeklasse;
import java.io.IOException;

@RestController //REST API TEST denne linjen
public class ApiController {
    private Service service;

    public ApiController () {
        service = new Service();
        
    }
    //Metoder for rest API//

    //Get metode for å hente fra server
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/all")
    public Listeklasse getWordList() throws IOException {
        System.out.println("Returning list..");
        System.out.println(service.getAll());
        return service.getAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value="/save")
    public String retrieveList(@RequestBody String listeklasseJSON) throws IOException {
        System.out.println("Request received: ");
        System.out.println(listeklasseJSON);
        System.out.println("Trying to save value " + listeklasseJSON);
        ObjectMapper objectMapper = new ObjectMapper();
        Listeklasse listeklasse = objectMapper.readValue(listeklasseJSON, Listeklasse.class);
        System.out.println("Converted listeklasse");
        System.out.println("Dette er  listeklasse" + listeklasse.getWordList());
        service.saveListeklasse(listeklasse);
        return "saved";
    }

//Slutt for rest API
}


