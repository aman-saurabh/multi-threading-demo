package com.techpassel;

public class ThreadInterruptionDemo {
    public static void main(String[] args) {
        MyRunnable2 r = new MyRunnable2();
        Thread t = new Thread(r);
        t.start();
        t.interrupt();
        System.out.println("Main Thread");
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("Child Thread");
        } catch (InterruptedException e){
            System.out.println("Thread got interrupted");
        }
    }
}
