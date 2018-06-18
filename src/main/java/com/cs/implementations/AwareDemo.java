package com.cs.implementations;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AwareDemo implements ApplicationContextAware, BeanNameAware {
  
  private String             beanName;
  private ApplicationContext applicationContext;
  
  @PostConstruct
  public void display()
  {
    System.out.println("*********** Aware Examples *****************");
    System.out.println("ApplicationContext Startup Date: " + applicationContext.getStartupDate());
    System.out.println("Bean Name : " + beanName);
  }
  
  @Override
  public void setBeanName(String beanName)
  {
    this.beanName = beanName;
  }
  
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
  {
    this.applicationContext = applicationContext;
  }
  
}
