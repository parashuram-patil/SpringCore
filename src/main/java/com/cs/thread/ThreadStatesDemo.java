package com.cs.thread;

public class ThreadStatesDemo {
  
  public static void main(String args[])
  {
    Thread threadInstance = new Thread(new BasicThread());
    System.out.println("Thread state after creation: " + threadInstance.getState());
    threadInstance.start();
    System.out.println("Thread state after start: " + threadInstance.getState());
    try {
      boolean keepRunning = true;
      int count = 1;
      while (keepRunning) {
        Thread.sleep(2000);
        System.out.println(count * 2 + " Seconds elapsed - Thread State: " + threadInstance.getState());
        count++;
        if (count == 4) {
          synchronized (threadInstance) {
            System.out.println("Thread state before notify: " + threadInstance.getState());
            threadInstance.notify();
            System.out.println("Thread state after notify: " + threadInstance.getState());
          }
        }
        if (Thread.State.TERMINATED == threadInstance.getState()) {
          keepRunning = false;
        }
      }
    }
    catch (InterruptedException iException) {
      iException.printStackTrace();
    }
    
  }
}

class BasicThread implements Runnable {
  
  @Override
  public void run()
  {
    Thread thread = Thread.currentThread();
    try {
      System.out.println("Thread is about to sleep");
      thread.sleep(5000);
      synchronized (thread) {
        // System.out.println("Before wait");
        thread.wait();
        // System.out.println("After wait");
      }
    }
    catch (InterruptedException iException) {
      iException.printStackTrace();
    }
  }
}
