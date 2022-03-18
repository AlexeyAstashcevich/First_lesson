package ru.stqa.pft.sandbox.pointHomework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistanceCalculate() {
    Point p1 = new Point(4, 3);
    Point p2 = new Point(4, 6);
    Assert.assertEquals(p1.getDistance(p2), 3.0);
    p2 = new Point(5, 7);
    Assert.assertEquals(p1.getDistance(p2), 4.123105625617661);
    p2 = new Point(5, 3);
    Assert.assertEquals(p1.getDistance(p2), 1.0);
  }

  @Test
  public void testDistanceGreaterThanZero() {
    Point p1 = new Point(2, 6);
    Point p2 = new Point(5, 6);
    Assert.assertTrue(p1.getDistance(p2) > 0);
    p2 = new Point(4, -1);
    Assert.assertTrue(p1.getDistance(p2) > 0);
    p2 = new Point(-2, 6);
    Assert.assertTrue(p1.getDistance(p2) > 0);
  }

  @Test
  public void testArgumentIsNull() {
    Point p1 = new Point(4, 3);
    Assert.assertThrows(IllegalArgumentException.class, () -> p1.getDistance(null));
  }

  @Test
  public void testDistanceEqualsZero() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.getDistance(p2), 0);
  }

  @Test
  public void testMaxAloudCoordinate() {
    Point p1 = new Point(Double.MAX_VALUE, Double.MIN_VALUE);
    Point p2 = new Point(Double.MIN_VALUE, Double.MAX_VALUE);
    Assert.assertEquals(p1.getDistance(p2), Double.POSITIVE_INFINITY);
  }

}


