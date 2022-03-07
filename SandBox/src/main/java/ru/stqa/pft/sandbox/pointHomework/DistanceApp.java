package ru.stqa.pft.sandbox.pointHomework;

import static javax.swing.UIManager.get;

public class DistanceApp {
  public static void main(String[] args) {
    Point p1 = new Point(4,3);
    Point p2 = new Point(4,6);
      System.out.println("Растояние между двумя точками с координатами первой " +
              p1 + " второй " + p2 + " = "   + p1.getDistance(p2));

  }
}






