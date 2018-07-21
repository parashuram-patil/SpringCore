package com.cs.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class PrePostConstructorDemo {
  
  public PrePostConstructorDemo() {
    System.out.println("No-args constructor called!!!");
  }
  
  @PostConstruct
  public void myInit() {
    System.out.println("userdefined init() executed!!!");
  }
  
  @PreDestroy
  public void myDestroy() {
    System.out.println("userdefined destroy() executed!!!");
  }
  
}
