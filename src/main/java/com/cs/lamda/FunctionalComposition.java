package com.cs.lamda;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FunctionalComposition implements ILamadasDemo {
  
  @Override
  public void execute()
  {
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    
    System.out.println("Method Composition");
    System.out.println("Sum : " + 
        intList.stream()
               .filter(num -> num % 2 == 0)
               //.map(num -> num * 2)
               .mapToInt(num -> num * 2)
               //.reduce(0, Integer::sum)
               .sum()
               );
  }
}
