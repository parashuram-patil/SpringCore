package com.cs.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class StreamPerformance implements ILamadasDemo {
  
  @Override
  public void execute()
  {
    List<Integer> intList = Arrays.asList(1, 2, 3, 5, 7, 5, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
        15, 16, 17, 18, 19, 20);
    
    /*Problem Stmt : Given a ordered list, find the double of the first even number grater than 3 */
    
    /*Legacy code*/
    int result = 0;
    TimeCalculator.calculate(
        () -> System.out.println("Answer with Legacy code : " + legacyCode(intList, result)));
     
    TimeCalculator.calculate(
        () -> System.out.println("Answer with Optimised Steam code : " + optimisedStreamCode(intList)));
  }
  
  private Optional<Integer> optimisedStreamCode(List<Integer> intList)
  {
    return intList.stream()
        .filter(StreamPerformance::isGtThree)
        .filter(StreamPerformance::isModTwo)
        .map(StreamPerformance::compute)
        .findFirst();
  }
  
  private static boolean isModTwo(int e)
  {
    return e % 2 == 0 ? true : false;
  }
  
  private static boolean isGtThree(int e)
  {
    return e > 3 ? true : false;
  }
  
  private static int compute(int e)
  {
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    
    return e * 2;
  }
  
  private int legacyCode(List<Integer> intList, int result)
  {
    for (int e : intList) {
      if (e > 3 && e % 2 == 0) {
        result = compute(e);
        break;
      }
    }
    return result;
  }
}
