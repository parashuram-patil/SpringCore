package com.cs.lamda;


public class TimeCalculator {
  
  public static void calculate(Runnable code) {
    long start = System.nanoTime();
    try {
      code.run();
    }
    finally {
      long end = System.nanoTime();
      System.out.println("Total Time taken : " + (end - start) / 1.0e9);
    }
  }
  
}
