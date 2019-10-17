package restAPI.src.main.java.gr1919.project.Controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.core.Listeklasse;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController //REST API TEST denne linjen
public class ApiController {

    private Listeklasse listeklasse;
    //Metoder for rest API//

    //Get metode for å hente fra server
    @GetMapping(value = "/all")
    public Listeklasse getWordList() throws IOException {
        Listeklasse listeklasse = new ObjectMapper().readValue(new File("build/save.json"), Listeklasse.class);
        return listeklasse;
    }

    //Dette er en POST metode, men post kan ikke returnere noe, derfor er det GetMapping, som kan gjøre begge deler, skriver til server.
    @GetMapping(value="/save")
    public ResponseEntity<Listeklasse> retriveList(@RequestParam("desc") String desc, @RequestParam("done") boolean done) throws IOException, URISyntaxException {
        File path = new File("build/save.json");
        new ObjectMapper().writeValue(path, listeklasse);
        return ResponseEntity.created(new URI("/save")).body(listeklasse);
    }




    //----------------Alt under er mer avansert kode som sjekker for ulike feilmeldinger, men vi fokuserer på det enkle først---------
    /*
    @PostMapping(value="/save/")
    public ResponseEntity<?> createListeklasse(@RequestParam(value="desc") String desc, @RequestParam(value="done") boolean done) throws IOException {
        Listeklasse listeklasse;
        try{
            listeklasse = new Listeklasse(liste);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "invalid desc"
            );
        }//hvilken linje som gjør at vi kjører springboot

        try{
            new File("build/save").mkdir(); //Sjekker om hei er en fil;
            File path = new File("build/save" + ".json");
            new ObjectMapper().writeValue(path, listeklasse);
            return (ResponseEntity<?>) ResponseEntity.created(new URI("save"));
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
    /*
    @GetMapping(value = "/all")
    public Listeklasse getWordList() {
        File path = new File("build/save/" + id +  ".json");

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
    */

//Slutt for rest API
}


