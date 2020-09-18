package com.techpassel;

public class DaemonThreadDemo {
    public static void main(String[] args) {
      System.out.println("Is main thread a daemon thread : "+ Thread.currentThread().isDaemon());
      DaemonRunnable r = new DaemonRunnable();
      Thread t = new Thread(r);
      //We must set any thread as Daemon thread before calling its start method otherwise we will get runtime exception : IllegalThreadStateException.
      t.setDaemon(true);
      t.start();
      for (int i=0; i< 100; i++) {
          System.out.println("Main thread");
      }
      System.out.println("Main thread execution ends.");
    }
}

class DaemonRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Is child thread a daemon thread : "+ Thread.currentThread().isDaemon());
        //However we are running the loop for 100 times but if you run the program, you will find hardly any time it completes 100 iteration.
        //It is because it is being executed by Daemon thread.And Daemon thread terminates as soon as all non-daemon thread terminates.
        for (int i =0; i<100; i++){
            System.out.println("Child Thread count : "+(i+1));
        }
        //If we create a new thread from here then that thread will also be a Daemon thread as Daemon nature is inherited from Parent to child.
        System.out.println("Child thread execution ends.");
    }
}
