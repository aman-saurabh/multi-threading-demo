package com.techpassel;

public class ThreadFutureInterruptionDemo {
    public static void main(String[] args) {
        MyRunnable3 r = new MyRunnable3();
        r.mainThread = Thread.currentThread();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i< 10000; i++){
            System.out.println("I am loop in main thread");
        }
        try {
            Thread.sleep(1000);
            System.out.println("I am main thread and completed sleep state and never got interrupted as when interrupt method was called I was not sleeping");
        } catch (InterruptedException e){
            System.out.println("I am main thread and I got interrupted");
        }

    }

}

class MyRunnable3 implements Runnable{
    public Thread mainThread;
    public void run() {
        mainThread.interrupt();
        System.out.println("I am child thread and printing this message after calling interrupt method for main thread");
    }
}