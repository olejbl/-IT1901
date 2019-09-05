package todo.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import todo.core.LatLong;
import todo.core.LatLongs;

public class LatLongsModule extends Module {

  @Override
  public String getModuleName() {
    return "LatLongsModule";
  }

  @Override
  public Version version() {
    return Version.unknownVersion();
  }

  private final SimpleSerializers serializers = new SimpleSerializers();
  private final SimpleDeserializers deserializers = new SimpleDeserializers();

  public LatLongsModule() {
    serializers.addSerializer(LatLong.class, new LatLongSerializer());
    serializers.addSerializer(LatLongs.class, new LatLongsSerializer());
    deserializers.addDeserializer(LatLong.class, new LatLongDeserializer());
    deserializers.addDeserializer(LatLongs.class, new LatLongsDeserializer());
  }

  @Override
  public void setupModule(final SetupContext context) {
    context.addSerializers(serializers);
    context.addDeserializers(deserializers);
  }
}
