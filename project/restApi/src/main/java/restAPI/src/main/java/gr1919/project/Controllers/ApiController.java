package restAPI.src.main.java.gr1919.project.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import todo.core.Listeklasse;
import todo.core.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController //REST API TEST denne linjen
public class ApiController {

    ArrayList<Todo> liste= new ArrayList<>();
    //For rest API//
    @PostMapping(value="/hei/")
    public ResponseEntity<?> createListeklasse(@RequestParam(value="desc") String desc, @RequestParam(value="done") boolean done) throws IOException {
        Listeklasse listeklasse;
        try{
            listeklasse = new Listeklasse(liste);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "invalid desc"
            );
        }

        try{
            new File("build/hei").mkdir(); //Sjekker om hei er en fil;
            File path = new File("build/hei" + ".json");
            new ObjectMapper().writeValue(path, listeklasse);
            return (ResponseEntity<?>) ResponseEntity.created(new URI("hei"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Could not serialize listeklasse."
            );
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Write error."
            );
        }

    }

    @GetMapping(value = "/person/{id}")
    public Listeklasse getPerson(@PathVariable int id) {
        File path = new File("build/person/" + id +  ".json");

        try {
            // This requires some changes to person constructors / jackson-stuff to actually work
            return new ObjectMapper().readValue(path, Listeklasse.class);

        } catch (FileNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Listeklasse does not exist."
            );
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Could not parse JSON."
            );
        }
    }

//Slutt for rest API
}


