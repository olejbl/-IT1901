package todo.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import todo.core.LatLong;

import java.io.IOException;

public class LatLongDeserializer extends JsonDeserializer<LatLong> {

  private static final int ARRAY_JSON_NODE_SIZE = 2;

  @Override
  public LatLong deserialize(final JsonParser jsonParser, final DeserializationContext deserContext)
      throws IOException, JsonProcessingException {
    final JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
    return deserialize(jsonNode);
  }

  public LatLong deserialize(final JsonNode jsonNode) throws JsonProcessingException {
    if (jsonNode instanceof ObjectNode) {
      final ObjectNode objectNode = (ObjectNode) jsonNode;
      final double latitude = objectNode.get(LatLongSerializer.LATITUDE_FIELD_NAME).asDouble();
      final double longitude = objectNode.get(LatLongSerializer.LONGITUDE_FIELD_NAME).asDouble();
      return new LatLong(latitude, longitude);
    } else if (jsonNode instanceof ArrayNode) {
      final ArrayNode locationArray = (ArrayNode) jsonNode;
      if (locationArray.size() == ARRAY_JSON_NODE_SIZE) {
        final double latitude = locationArray.get(0).asDouble();
        final double longitude = locationArray.get(1).asDouble();
        return new LatLong(latitude, longitude);
      }
    }
    return null;
  }
}
