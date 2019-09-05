package todo.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import todo.core.LatLong;
import todo.core.LatLongs;

import java.io.IOException;

public class LatLongsSerializer extends JsonSerializer<LatLongs> {

  @Override
  public void serialize(final LatLongs latLongs, final JsonGenerator jsonGen,
                        final SerializerProvider provider) throws IOException {
    jsonGen.writeStartArray(latLongs.getLatLongCount());
    for (final LatLong latLong : latLongs) {
      jsonGen.writeObject(latLong);
    }
    jsonGen.writeEndArray();
  }
}
