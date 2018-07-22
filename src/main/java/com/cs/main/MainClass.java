package com.cs.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.lamda.ILamadasDemo;
import com.cs.lamda.StreamCharacterstics;
import com.cs.lamda.StreamPerformance;

public class MainClass {

	@SuppressWarnings("resource")
  public static void main(String[] args) {
		
		//BeanFactory context = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring.xml"));
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		/*Shape shape = (Shape)context.getBean("triangle");
		shape.draw();*/
		
		//AutowiredTriangle shape = (AutowiredTriangle)context.getBean("autowiredTriangle");
        //shape.draw();
		
		
		/*Below line causes error since we have made abstract*/
		//InteritanceDemo parentClass = (InteritanceDemo) context.getBean("parentClass");
		
		//InteritanceDemo childClass = (InteritanceDemo) context.getBean("childClass");
		//childClass.display();

		 /*Long currentTimeMillis = System.currentTimeMillis();
		 String messageEN = context.getMessage("greeting", new String[] {currentTimeMillis.toString(), "Good Morning"}, "default Greeting", Locale.ENGLISH);
		 String messageFR = context.getMessage("greeting", null, "default Greeting", Locale.FRENCH);
	     System.out.println(messageEN);
	     System.out.println(messageFR);*/
		
		//MessageSourceDemo messageSourceDemo = (MessageSourceDemo) context.getBean("messageSourceDemo");
		//messageSourceDemo.printMessages();
		
		//MyPublisher myPublisher = (MyPublisher) context.getBean("myPublisher");
		//myPublisher.publishEvent();
		
		/*Lamdas*/
		
		//ILamadasDemo demo = (IteratorTypes) context.getBean("iteratorTypes");
		
		//ILamadasDemo demo = (MethodReference) context.getBean("methodReference");
		
		//ILamadasDemo demo = (FunctionalComposition) context.getBean("functionalComposition");
		
		//ILamadasDemo demo = (ParallelStreams) context.getBean("parallelStreams");
		
		//ILamadasDemo demo = (SpecialReduceTypes) context.getBean("specialReduceTypes");
		
		//ILamadasDemo demo = (StreamPerformance) context.getBean("streamPerformance");
		
		ILamadasDemo demo = (StreamCharacterstics) context.getBean("streamCharacterstics");
		
		demo.execute();
		
	}
}