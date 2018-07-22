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
    
    TimeCalculator
        .calculate(() -> System.out.println("Answer with Steam code : " + streamCode(intList)));
  }
  
  private Optional<Integer> streamCode(List<Integer> intList)
  {
    return intList.stream()
        .filter(e -> e > 3)
        .filter(e -> e % 2 == 0)
        .map(e -> compute(e))
        .findFirst();
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
}
