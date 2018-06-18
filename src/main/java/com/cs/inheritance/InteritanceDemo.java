package com.cs.inheritance;

import com.cs.implementations.Points;

public class InteritanceDemo {
  
  private Points point1;
  private Points point2;
  
  public void setPoint1(Points point1)
  {
    this.point1 = point1;
  }
  
  public void setPoint2(Points point2)
  {
    this.point2 = point2;
  }
  
  public void display() {
    System.out.println("(" + point1.getX() + ", "+ point1.getY() + "),(" + point2.getX() + ", "+ point2.getY() + ")");
  }
  
}
