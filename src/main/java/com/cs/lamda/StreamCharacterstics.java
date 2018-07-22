package com.cs.lamda;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StreamCharacterstics implements ILamadasDemo {
  
  @Override
  public void execute()
  {
    List<Integer> intList = Arrays.asList(5, 4, 3, 2, 1, 1, 2, 3, 4, 5);
    
    intList.stream()
        .distinct()
        .sorted()
        .forEach(System.out::println);
  }
}
