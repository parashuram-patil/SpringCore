package com.cs.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.interfaces.Shape;

public class MainClass {

	public static void main(String[] args) {
		
		//BeanFactory context = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring.xml"));
    //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		Shape shape = (Shape)context.getBean("triangle");
		shape.draw();
		
		/*Below line causes error since we have made abstract*/
		//InteritanceDemo parentClass = (InteritanceDemo) context.getBean("parentClass");
		
		//InteritanceDemo childClass = (InteritanceDemo) context.getBean("childClass");
		//childClass.display();
		
	}

}