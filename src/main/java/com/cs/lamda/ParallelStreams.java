package com.cs.lamda;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ParallelStreams implements ILamadasDemo {
  
  @Override
  public void execute()
  {
    System.out.println("Parallel streams");
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    /*if we use stream it takes 5 secs where as parallelStream takes 2 sec*/ 
    
    TimeCalculator.calculate(() -> System.out.println("Sum : " +
    //intList.stream()
    intList.parallelStream()   
        .filter(num -> num % 2 == 0)
        .mapToInt(ParallelStreams::compute)
        .sum()));
  }
  
  public static int compute(int num)
  {
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    return num * 2;
  }
  
}
