package ru.stqa.pft.sandbox.pointHomework;

public class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getDistance(Point p) {
    return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
  }

  public String toString() {
    return "(" + this.x + ", " + this.y + ")";
  }
}