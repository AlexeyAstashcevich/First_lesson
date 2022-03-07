package ru.stqa.pft.sandbox.pointHomework;

import static javax.swing.UIManager.get;

public class DistanceApp {
  public static void main(String[] args) {
    Point p1 = new Point(4,6);
    Point p2 = new Point(5,2);
    System.out.println("Растояние между двумя точками с координатами первой " + p1.getX()+ " и " + p1.getY() + " второй " + p2.getX() +
            " и " + p2.getY() + " = "   +distance(p1,p2));


  }
  public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p1.getX()- p2.getX()),2) + Math.pow((p1.getY() - p2.getY()),2));
  }
}






