package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationsTest {
  @Test
  public void Test0 (){
    Equations equations = new Equations(1,1,1);
    Assert.assertEquals(equations.rootNumber(),0);
  }

  @Test
  public void Test1 (){
    Equations equations = new Equations(1,2,1);
    Assert.assertEquals(equations.rootNumber(),1);
  }

  @Test
  public void Test2 (){
    Equations equations = new Equations(1,5,6);
    Assert.assertEquals(equations.rootNumber(),2);
  }
}
