package com.cs.lamda;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MethodReference {
  
  static MethodReference methodReference = new MethodReference();
  
  private void print(Integer input)
  {
    System.out.print(input + "\t");
  }
  
  private static void print(String input)
  {
    System.out.print(input + "\t");
  }
  
  public void execute()
  {
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    
    /*instance method reference*/
    System.out.println("Parameter as an argument");
    intList.forEach(MethodReference.methodReference::print);
    // intList.forEach(System.out::print);
    
    /*static method reference*/
    System.out.println("\nParameter as an argument to static method");
    intList.stream()
        // .map(num -> String.valueOf(num))
        .map(String::valueOf)
        .forEach(MethodReference::print);
    
    /*parameter as target*/
    System.out.println("\nParameter as target");
    intList.stream()
        // here num isd used as target to invoke toString()
        .map(num -> num.toString())
        // .map(String::toString)
        .forEach(MethodReference::print);
  }
  
}
