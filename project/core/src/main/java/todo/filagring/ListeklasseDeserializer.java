
package todo.filagring;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.Json;
import todo.core.Listeklasse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.node.ArrayNode;

public class ListeklasseDeserializer extends JsonDeserializer<Listeklasse> {

    //Loader fra fil
    public void loadFromFile() throws Throwable {
        String filename = "todo.txt";
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));
            Listeklasse listeklasse = (Listeklasse) o.readObject();
        }/* catch (InvocationTargetException e) {
            throw e.getCause();
        }*/catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done writing");
    }

    @Override
    public Listeklasse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode jsonNode = p.getCodec().readTree(p);
        String stringWord;
        if (jsonNode instanceof ArrayNode) {
            final ArrayNode arrayNode = (ArrayNode) jsonNode;
            final ArrayList<String> listeklasse = new ArrayList<>(arrayNode.size());
            for (final JsonNode word : arrayNode) {
                stringWord = String.valueOf(word);
                listeklasse.add(stringWord);
            }
            return new Listeklasse(listeklasse);
        }
        return null;


    }
}