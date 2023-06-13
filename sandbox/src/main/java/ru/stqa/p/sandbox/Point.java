package ru.stqa.p.sandbox;

public class Point {
  public double x;
  public double y;
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

  public double distance(Point p) {
    double dx = this.x - p.getX();
    double dy = this.y - p.getY();
    return Math.sqrt(dx*dx + dy*dy);
  }

}
