package todo.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

public class LatLongsTest {

  private LatLongs latLongs;

  @Before
  public void setUp() {
    latLongs = new LatLongs();
  }

  @Test
  public void testEmptyConstructor() {
    Assert.assertEquals(0, latLongs.getLatLongCount());
  }

  private static void checkLatLongs(final LatLongs latLongs1, final LatLong... latLongs2) {
    Assert.assertEquals(latLongs2.length, latLongs1.getLatLongCount());
    final Iterator<LatLong> it = latLongs1.iterator();
    for (int i = 0; i < latLongs2.length; i++) {
      Assert.assertTrue(it.hasNext());
      Assert.assertEquals(latLongs2[i], latLongs1.getLatLong(i));
      Assert.assertEquals(latLongs2[i], it.next());
    }
    Assert.assertFalse(it.hasNext());
  }

  @Test
  public void testConstructor() {
    checkLatLongs(new LatLongs(63.0, 10.3, 63.1, 10.2), new LatLong(63.0, 10.3),
        new LatLong(63.1, 10.2));
    checkLatLongs(new LatLongs(new LatLong(63.0, 10.3), new LatLong(63.1, 10.2)),
        new LatLong(63.0, 10.3), new LatLong(63.1, 10.2));
    checkLatLongs(new LatLongs(Arrays.asList(new LatLong(63.1, 10.2), new LatLong(63.1, 10.1))),
        new LatLong(63.1, 10.2), new LatLong(63.1, 10.1));
  }

  @Test
  public void testAddLatLong() {
    latLongs.addLatLong(new LatLong(63.0, 10.3));
    Assert.assertEquals(1, latLongs.getLatLongCount());
    latLongs.addLatLong(new LatLong(63.1, 10.2));
    Assert.assertEquals(2, latLongs.getLatLongCount());
  }

  @Test
  public void testAddLatLongs() {
    final LatLongs lls1 = new LatLongs();
    lls1.addLatLongs(63.0, 10.3, 63.1, 10.2);
    checkLatLongs(lls1, new LatLong(63.0, 10.3), new LatLong(63.1, 10.2));

    final LatLongs lls2 = new LatLongs();
    lls2.addLatLongs(new LatLong(63.0, 10.3), new LatLong(63.1, 10.2));
    checkLatLongs(lls2, new LatLong(63.0, 10.3), new LatLong(63.1, 10.2));

    final LatLongs lls3 = new LatLongs();
    lls3.addLatLongs(Arrays.asList(new LatLong(63.1, 10.2), new LatLong(63.1, 10.1)));
    checkLatLongs(lls3, new LatLong(63.1, 10.2), new LatLong(63.1, 10.1));
  }
}
