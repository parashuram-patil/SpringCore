package com.cs.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;

@Component
public class IteratorTypes {
  
  public void demoIteratorTypes() {
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6 ,7, 8, 9, 0);
    
    /*External Iterator*/
    System.out.println("<--------------- External Iterator --------------->");
    System.out.println("External Iterator using for()");
    for(int i=0; i < intList.size(); i++) {
      printNumber(intList.get(i));
    }
    
    System.out.println();
    System.out.println("External Iterator using auto iterated for()");
    for(int num : intList) {
      printNumber(num);
    }
    
    /*Internal Iterator*/
    /*here forEach is a polymorphism
     Java 8 uses type inference only for lamda */
    System.out.println();
    System.out.println("<--------------- Internal Iterator --------------->");
    System.out.println("Internal Iterator using Anonymour inner class Consumer()");
    /*but uses anonymous classes*/
    intList.forEach(new Consumer<Integer>()
    {
      @Override
      public void accept(Integer num)
      {
        printNumber(num);        
      }
    });
    
    System.out.println();
    System.out.println("Internal Iterator using lamda");
    
    //intList.forEach((Integer num) -> printNumber(num));
   
    /*if there is only one function parameter we dont need paranthesis
    if zero or more than 1 parameter we need paranthesis*/
    intList.forEach(num -> printNumber(num));
  }

  private static void printNumber(Integer integer)
  {
    System.out.print(integer + "\t");
  }
}
