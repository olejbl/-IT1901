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


