package com.cs.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.interfaces.Shape;

public class MainClass {

	public static void main(String[] args) {
		
		//BeanFactory context = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Shape shape = (Shape)context.getBean("triangle");
		shape.draw();
		
		//ApplicationContext 
	}

}