package com.cs.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanDemo implements InitializingBean, DisposableBean {
  
  
  public InitializingBeanDemo()
  {
    System.out.println("No-args constructor called!!!");
  }
  
  @Override
  public void afterPropertiesSet() throws Exception
  {
    System.out.println("afterPropertiesSet() executed!!!");
  }
  
  public void display() {
    System.out.println("display() executed!!!!");
  }

  @Override
  public void destroy() throws Exception
  {
    System.out.println("destroy() executed!!!");    
  }
  
}