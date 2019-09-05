package todo.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import todo.core.LatLong;
import todo.core.LatLongs;

public class LatLongsJsonTest {

  private final ObjectMapper objectMapper = new ObjectMapper();
  {
    objectMapper.registerModule(new LatLongsModule());
  }

  protected void assertEqualsIgnoreWhitespace(final String expected, final String actual)
      throws Exception {
    Assert.assertEquals(expected, actual.replaceAll("\\s+", ""));
  }

  @Test
  public void testLatLongsSerialization() throws Exception {
    final String actualJson = objectMapper.writeValueAsString(new LatLongs(new LatLong(63.1, 12.3), new LatLong(63.0, 12.4)));
    final String expectedJson = "[{\"latitude\":63.1,\"longitude\":12.3},{\"latitude\":63.0,\"longitude\":12.4}]";
    assertEqualsIgnoreWhitespace(expectedJson, actualJson);
  }

  @Test
  public void testLatLongsDeserialization() throws Exception {
    final String json = "[{\"latitude\":63.1,\"longitude\":12.3}, [63.0,12.4]]";
    final LatLongs latLongs = objectMapper.readValue(json, LatLongs.class);
    Assert.assertEquals(2, latLongs.getLatLongCount());
    Assert.assertEquals(new LatLong(63.1, 12.3), latLongs.getLatLong(0));
    Assert.assertEquals(new LatLong(63.0, 12.4), latLongs.getLatLong(1));
  }
}
