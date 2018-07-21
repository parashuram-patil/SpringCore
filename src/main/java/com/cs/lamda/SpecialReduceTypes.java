package com.cs.lamda;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SpecialReduceTypes implements ILamadasDemo {
  
  @Override
  public void execute()
  {
    System.out.println("Special Reduce Types");
    
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    Double sum = intList.stream()
        .filter(num -> num % 2 == 0)
        .mapToDouble(num -> num * 3.2)
        .sum();
    
    System.out.println("Sum : " + sum);
  }
  
}
