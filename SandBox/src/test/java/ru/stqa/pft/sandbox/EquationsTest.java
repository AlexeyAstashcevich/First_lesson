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

  @Test
  public void TestLinear (){
    Equations equations = new Equations(0,1,1);
    Assert.assertEquals(equations.rootNumber(),1);
  }

  @Test
  public void TestConstant (){
    Equations equations = new Equations(0,0,1);
    Assert.assertEquals(equations.rootNumber(),0);
  }

  @Test
  public void TestZero (){
    Equations equations = new Equations(0,0,0);
    Assert.assertEquals(equations.rootNumber(),-1);
  }
}
