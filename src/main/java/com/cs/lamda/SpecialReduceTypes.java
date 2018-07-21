package com.cs.lamda;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public class SpecialReduceTypes implements ILamadasDemo {
  
  @Override
  public void execute()
  {
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    Double sum = intList.stream()
        .filter(num -> num % 2 == 0)
        .mapToDouble(num -> num * 3.2)
        .sum();
    System.out.println("Special Reduce Types ---> Sum : " + sum);
    
    /*This is not a good practice since list doubleOfEven is shared among different threads so the problem of shared mutability*/
    /*List<Integer> doubleOfEven = new ArrayList<>();
    intList.stream()
    .filter(num -> num%2 == 0)
    .forEach(num -> doubleOfEven.add(num));
    System.out.println("Special Reduce Types ---> Collect : " + doubleOfEven);*/
    
    List<Integer> doubleOfEvenList = intList.stream()
        .filter(num -> num % 2 == 0)
        .map(num -> num * 2)
        .collect(toList());
    
    System.out.println("Special Reduce Types ---> Collect toList() : " + doubleOfEvenList);
    
    Set<Integer> doubleOfEvenSet = intList.stream()
        .filter(num -> num % 2 == 0)
        .map(num -> num * 2)
        .collect(toSet());
    
    System.out.println("Special Reduce Types ---> Collect toSet() : " + doubleOfEvenSet);
  }
  
}
