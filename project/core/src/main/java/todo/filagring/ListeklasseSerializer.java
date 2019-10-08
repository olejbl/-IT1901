package todo.filagring;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import todo.core.Listeklasse;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ListeklasseSerializer extends JsonSerializer<Listeklasse>{

    //saver til fil
    public void saveToFile(Listeklasse listeklasse) throws IOException {
        String filename = "todo.txt";
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));
            o.writeObject(listeklasse);
            o.close();
        }/* catch (InvocationTargetException e) {
            throw e.getCause();
        }*/catch (IOException e) {
            System.out.println(System.getProperty("user.dir"));
            e.printStackTrace();
        }
        System.out.println("done writing");
    }

    //lagrer hvert element fra listeklasse inn i json
    @Override
    public void serialize(Listeklasse value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject(value.getWordList());
        for (String word : value.getWordList()){
            gen.writeObject(word);
        }
        gen.writeEndArray();
    }
}
