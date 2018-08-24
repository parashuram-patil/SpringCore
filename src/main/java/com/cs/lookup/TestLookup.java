package com.cs.lookup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class TestLookup {
  
 @Autowired
 LookupProperty lookupProperty;
  
  public void execute() throws InterruptedException
  {
    Integer numOfThreads = 10;
    ExecutorService pool = Executors.newFixedThreadPool(numOfThreads);
    for (int i = 1; i <= numOfThreads; i++) {
      Runnable r = new Runnable()
      {
        
        @Override
        public void run()
        {
          System.out.println(Thread.currentThread().getName() + " --------> " + getLookupProperty());
        }
      };
      pool.submit(r);
      Thread.sleep(1000);
    }
    pool.shutdown();
  }
  
  @Lookup
  public LookupProperty getLookupProperty()
  {
    
    return lookupProperty;
  }
}
