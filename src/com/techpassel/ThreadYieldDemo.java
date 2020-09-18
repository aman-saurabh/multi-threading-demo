package com.techpassel;

public class ThreadYieldDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for (int i =0; i< 10; i++)
                System.out.println("Child Thread");
        };
        Thread t = new Thread(r);
        t.start();
        Thread.yield();
        //But yield() method is not supported by many JVM.So there is no guarantee that it will work.
        //You can achieve the same i.e pause the current executing thread to give chance to other threads by the following way also which is more reliable.
        //Thread.sleep(10);
        for (int i =0; i < 10; i++)
            System.out.println("Main Thread");
    }
}
