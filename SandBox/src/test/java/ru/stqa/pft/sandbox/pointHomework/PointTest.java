package ru.stqa.pft.sandbox.pointHomework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  Point p1 = new Point(4, 3);
  Point p2 = new Point(4, 6);

  @Test
  public void pointTest() {
    Assert.assertEquals(p1.getDistance(p2), 3.0);
  }

  @Test
  public void pointTest3() {
    Assert.assertEquals(p1.getDistance(p2), -4);
  }

  @Test
  public void pointTest4() {
    Assert.assertEquals(p2 = p1, p2 != p1);
  }

}
