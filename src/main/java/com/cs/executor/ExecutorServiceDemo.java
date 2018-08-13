package com.cs.executor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {
  
  public static void main(String args[])
  {
    String dir = System.getProperty("user.dir");
    File f = new File(dir);
    final BlockingQueue<File> queue = new ArrayBlockingQueue<File>(1000);
    for (File kid : f.listFiles()) {
      queue.add(kid);
    }
    
    ExecutorService pool = Executors.newFixedThreadPool(5);
    List<Future<?>> threads = new ArrayList<>();
    
    for (int i = 1; i <= 5; i++) {
      Runnable r = new Runnable()
      {
        public void run()
        {
          File workFile = null;
          while((workFile = queue.poll()) != null){
            String msg = Thread.currentThread().getName() + "::" + workFile.getName();
            System.out.println(msg);
            try {
              Thread.sleep(1000);
            }
            catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      };
      threads.add(pool.submit(r));
    }
    waitForThreadsExecution(threads, pool);
    System.out.println("----------------------------  " + Thread.currentThread().getName() + " End  ---------------------------");
  }
  
  public static void waitForThreadsExecution(List<Future<?>> threads, ExecutorService pool)
  {
    while(true)
    {
      List<Future<?>> listToRemove = new ArrayList<>();
      for (Future<?> future : threads) {
        if(future.isDone())
        {
          listToRemove.add(future);
        }
      }
      threads.removeAll(listToRemove);
      if (threads.size() == 0) {
        pool.shutdown();
        break;
      }
    }
  }
}
