package com.cs.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cs.interfaces.Shape;

@Component
public class AutowiredTriangle implements Shape {
  
  @Autowired
  @Qualifier("autowiredTriangle")
  private Points myPoint;
  
  @Autowired
  private String type;
  
  /*Triangle(String type, Points point) {
  	this.type = type;
  	this.point = point;
  }*/
  
  @Override
  public void draw()
  {
    System.out.println("Drawing Autowired Triangle ---> " + type);
    System.out.println("Points ---> X:" + myPoint.getX() + ", Y:" + myPoint.getY());
  }
}
