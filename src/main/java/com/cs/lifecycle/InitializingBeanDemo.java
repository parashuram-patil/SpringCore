package com.cs.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanDemo implements InitializingBean {
  
  
  public InitializingBeanDemo()
  {
    System.out.println("No-args constructor called!!!");
  }
  
  @Override
  public void afterPropertiesSet() throws Exception
  {
    System.out.println("afterPropertiesSet() executed!!!");
  }
  
}
