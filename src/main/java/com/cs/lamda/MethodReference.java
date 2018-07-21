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
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6 ,7, 8, 9, 0);
    
    /*non static method reference*/
    intList.forEach(MethodReference.methodReference::print);
    //intList.forEach(System.out::print);
    
    System.out.println();
    
    /*static method reference*/
    intList.stream()
           .map(num -> String.valueOf(num))
           .forEach(MethodReference::print);
  }
  
}
