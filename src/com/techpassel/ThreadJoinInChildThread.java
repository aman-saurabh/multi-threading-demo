package com.techpassel;

public class ThreadJoinInChildThread {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1.mainThread = Thread.currentThread();
        MyRunnable1 r = new MyRunnable1();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            System.out.println("Main Thread");
        }
    }
}

class MyRunnable1 implements Runnable {
    //We will set its value from the ThreadJoinInChildThread class.
    static Thread mainThread;
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i = 0; i< 10; i++) {
            System.out.println("Child Thread");
        }
    }
}
