package com.techpassel;

public class ThreadJoinInMainThread {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        //To tell main thread to wait until completion of child thread
//        t.join();
        //To tell main thread to wait 10000 ms or until completion of child thread whichever completes first.
        t.join(10000);
        for (int i = 0; i< 10; i++)
            System.out.println("Main Thread");
    }
}

class MyRunnable implements Runnable {
    public void run(){
        for (int i =0; i< 10; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("Child Thread");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
