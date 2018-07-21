package com.cs.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorDemo implements BeanPostProcessor {
  
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
  {
    System.out.println("************ postProcessBeforeInitialization()  " + bean.getClass().getName() + " executed!!!");
    return bean;
  }
  
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
  {
    System.out.println("************ postProcessAfterInitialization()  " + bean.getClass().getName() + " executed!!!");
    return bean;
  }
  
}
