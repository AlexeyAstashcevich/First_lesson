package ru.stqa.pft.sandbox.pointHomework;

import static javax.swing.UIManager.get;

public class Point {
  public static void main(String[] args) {
    Point1 p1 = new Point1(4,6);
    Point2 p2 = new Point2(5,2);
    System.out.println("Растояние между двумя точками с координатами первой " + p1.ax+ " и " + p1.ay + " второй " + p2.bx +
            " и " + p2.by + " = "   +distance(p1,p2));


  }
  public static double distance(Point1 p1, Point2 p2){
    return Math.sqrt((p1.ax- p2.bx)*2 + (p1.ay - p2.by));
  }
}






