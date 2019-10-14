package todo.restserver;

import todo.core.Listeklasse;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class TodoConfig {

    public TodoConfig() {
        this(new Listeklasse);
    }

    private static Listeklasse readValue (final String json){
        try {
            final Listeklasse listeklasse = new ListeklasseObjectMapperProvider().getContext(ObjectMapper.class).readValue(json, Listeklasse.class);
            System.out.println("Read" + json + "as" + listeklasse);
            return listeklasse;
        }
        catch (final Exception e){
            System.out.println("Exception when reading " + json + ":" + e);

        }
        return null;
    }
    public TodoConfig(final String json) throws IOException{
        this(readValue(json));
    }

    public TodoConfig(final Listeklasse listeklasse){
        System.out.println("Serving" + listeklasse.toList());
        register(ListeklasseService.class);
        register(ListeklasseObjectMapperProvider.class);
        register(JacksonFeature.class);
        register(new AbstractBinder(){
            @Override
             protected void configure(){
                bind(listeklasse);
            }

        });

    }

}
