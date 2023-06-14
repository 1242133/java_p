package ru.stqa.p.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test

    public void testDistance() {
      Point p1 = new Point(0, 0);
      Point p2 = new Point(3, 4);
      Assert.assertEquals(p1.distance(p2), 5.0);
    }
  @Test

    public void testDistance1() {
    Point p1 = new Point(1, 0);
    Point p2 = new Point(1, 2);
    Assert.assertEquals(p1.distance(p2), 2.0);
  }
}
