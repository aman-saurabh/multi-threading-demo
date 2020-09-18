package com.techpassel;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo4 {
    public static void main(String[] args) {
        MyThread5 t1 = new MyThread5("first");
        MyThread5 t2 = new MyThread5("second");
        t1.start();
        t2.start();
    }
}

class MyThread5 extends Thread{
    static ReentrantLock l = new ReentrantLock();
    MyThread5(String name){
        super(name+"-thread");
    }
    public void run() {
        do {
            try {
                //if any thread cannot get lock then it will wait here for 5000 ms and then only will enter into else block.
                if(l.tryLock(5000, TimeUnit.MILLISECONDS)){
                    System.out.println(Thread.currentThread().getName()+" got lock and now going to sleeping state");
                    Thread.sleep(30000);
                    System.out.println(Thread.currentThread().getName()+" releasing lock");
                    l.unlock();
                    //To exit from the do-while loop.
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName()+ " cannot get lock and will try again");
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        } while (true);
    }
}