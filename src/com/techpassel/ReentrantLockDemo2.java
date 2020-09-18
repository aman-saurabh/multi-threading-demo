package com.techpassel;

import java.util.concurrent.locks.ReentrantLock;
//Program to demonstrate how to use lock in place of synchronized keyword.
public class ReentrantLockDemo2 {
    public static void main(String[] args) {
    Display3 d = new Display3();
    MyThread3 t1= new MyThread3(d, "Aman");
    MyThread3 t2= new MyThread3(d, "Manish");
    MyThread3 t3= new MyThread3(d, "Samir");
    t1.start();
    t2.start();
    t3.start();
    }
}

class MyThread3 extends Thread {
    Display3 d;
    String name;
    MyThread3(Display3 d, String name){
        this.d = d;
        this.name = name;
    }
    public void run() {
        try {
            d.wish(name);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Display3 {
    ReentrantLock l = new ReentrantLock();
    public void wish(String name) throws InterruptedException {
        l.lock();
        Thread.sleep(1000);
        System.out.println("Queue length : "+l.getQueueLength());
        System.out.println("Has Queued Threads : "+l.hasQueuedThreads());
        for (int i =0; i<5; i++){
            System.out.println("Good Morning ");
            Thread.sleep(1000);
            System.out.println(name+".");
        }
        l.unlock();
    }
}
