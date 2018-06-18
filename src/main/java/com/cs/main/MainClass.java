package com.cs.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.inheritance.InteritanceDemo;

public class MainClass {

	public static void main(String[] args) {
		
		//BeanFactory context = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//Shape shape = (Shape)context.getBean("triangle");
		//shape.draw();
		
		/*Below line causes error since we have made abstract*/
		//InteritanceDemo parentClass = (InteritanceDemo) context.getBean("parentClass");
		
		InteritanceDemo childClass = (InteritanceDemo) context.getBean("childClass");
		childClass.display();
	}

}