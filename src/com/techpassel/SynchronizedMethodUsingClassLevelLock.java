package com.techpassel;

public class SynchronizedMethodUsingClassLevelLock {
    public static void main(String[] args) {
        Display1 d1 = new Display1();
        Display1 d2 = new Display1();
        MyThread1 t1 = new MyThread1(d1,"Aman");
        MyThread1 t2 = new MyThread1(d2, "Saurabh");
        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread{
    Display1 d;
    String name;
    MyThread1(Display1 d, String name){
        this.d = d;
        this.name = name;
    }
    public void run() {
        d.wish(name);
    }
}

class Display1 {
    //If you remove synchronized or static modifier then you will see improper message.
    public static synchronized void wish(String name) {
        for (int i =0; i<10; i++){
            System.out.println("Good Morning ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+".");
        }
    }
}