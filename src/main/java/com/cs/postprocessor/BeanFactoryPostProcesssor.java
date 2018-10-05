package com.cs.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//@Component
public class BeanFactoryPostProcesssor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException
  {
    //BeanDefinitionBuilder beanDefination = BeanDefinitionBuilder.rootBeanDefinition(XYZ.class);
    //((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("testBean", beanDefination.getBeanDefinition());
    
    System.out.println(beanFactory.getBeanDefinitionCount());
  }
  
}
