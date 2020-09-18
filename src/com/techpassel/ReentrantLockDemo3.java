package com.techpassel;

import java.util.concurrent.locks.ReentrantLock;

//Program to demonstrate how to use tryLock() method of Lock Interface.
public class ReentrantLockDemo3 {
    public static void main(String[] args) {
        MyThread4 t1 = new MyThread4("first");
        MyThread4 t2 = new MyThread4("second");
        t1.start();
        t2.start();
    }
}

class MyThread4 extends Thread{
    //Defining it as static is important.Otherwise every object of MyThread4 will have their own ReentrantLock object and hence lock concept will not work.
    static ReentrantLock l = new ReentrantLock();
    MyThread4(String name){
        super(name);
    }

    public void run() {
        if (l.tryLock()){
            System.out.println(Thread.currentThread().getName() + " got the lock and performing safe operation");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not get the lock and performing alternate operation");
        }
    }
}