package todo.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LatLongTest {

  @Test
  public void testToString() {
    final LatLong latLong = new LatLong(63.0, 10.0);
    Assert.assertEquals(Double.toString(63) + "," + Double.toString(10), latLong.toString());
  }

  @Test
  public void testValueOf() {
    testLatLong(LatLong.valueOf("63.0, 10.0"), 63.0, 10.0);
    testLatLong(LatLong.valueOf("63.0, 10.0", ","), 63.0, 10.0);
    testLatLong(LatLong.valueOf("63.0; 10.0", ";"), 63.0, 10.0);
    try {
      testLatLong(LatLong.valueOf("63.0; 10.0", ","), 63.0, 10.0);
      Assert.fail("Should throw IllegalArgumentException");
    } catch (final IllegalArgumentException e) {
      // ok
    } catch (final Exception e) {
      Assert.fail("Should throw IllegalArgumentException");
    }
  }

  private void testLatLong(final LatLong latLong, final double lat, final double lon) {
    Assert.assertEquals(lat, latLong.getLatitude(), 0.0);
    Assert.assertEquals(lon, latLong.getLongitude(), 0.0);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(new LatLong(63.0, 10.0).equals(new LatLong(63.0, 10.0)));
    Assert.assertFalse(new LatLong(10.0, 63.0).equals(new LatLong(63.0, 10.0)));
    Assert.assertFalse(new LatLong(10.0, 63.0).equals(null));
  }

  @Test
  public void testHashCode() {
    final Map<LatLong, String> map = new HashMap<>();
    map.put(new LatLong(63.0, 10.0), "first");
    map.put(new LatLong(63.0, 10.0), "second");
    Assert.assertEquals(1, map.size());
    Assert.assertEquals("second", map.get(new LatLong(63.0, 10.0)));
  }

  @Test
  public void testDistance() {
    final LatLong trd = new LatLong(63.4217137055, 10.4221522734);
    final LatLong str = new LatLong(63.0339713594, 10.2946225585);

    checkDistance(trd.distance(trd), 0.0, 10.0);
    checkDistance(str.distance(str), 0.0, 10.0);
    checkDistance(trd.distance(str), 43000.0, 45000.0);
    checkDistance(str.distance(trd), 43000.0, 45000.0);

    checkDistance(LatLong.distance(trd, trd), 0.0, 10.0);
    checkDistance(LatLong.distance(str, str), 0.0, 10.0);
    checkDistance(LatLong.distance(trd, str), 43000.0, 45000.0);
    checkDistance(LatLong.distance(str, trd), 43000.0, 45000.0);
  }

  private void checkDistance(final double d, final double lower, final double upper) {
    Assert.assertTrue(d + " isn't between " + lower + " and " + upper, d <= upper && d >= lower);
  }
}
