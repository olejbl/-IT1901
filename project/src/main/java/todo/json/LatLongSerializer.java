package todo.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import todo.core.LatLong;

import java.io.IOException;

public class LatLongSerializer extends JsonSerializer<LatLong> {

  public static final String LONGITUDE_FIELD_NAME = "longitude";
  public static final String LATITUDE_FIELD_NAME = "latitude";

  @Override
  public void serialize(final LatLong latLon, final JsonGenerator jsonGen,
      final SerializerProvider provider) throws IOException {
    jsonGen.writeStartObject();
    jsonGen.writeFieldName(LATITUDE_FIELD_NAME);
    jsonGen.writeNumber(latLon.getLatitude());
    jsonGen.writeFieldName(LONGITUDE_FIELD_NAME);
    jsonGen.writeNumber(latLon.getLongitude());
    jsonGen.writeEndObject();
  }
}
