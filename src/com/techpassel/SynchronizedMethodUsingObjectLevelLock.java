package com.techpassel;

public class SynchronizedMethodUsingObjectLevelLock {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Aman");
        MyThread t2 = new MyThread(d, "Saurabh");
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread{
    Display d;
    String name;
    MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }
    public void run() {
        d.wish(name);
    }
}

class Display {
    /*
     * If you remove synchronized modifier then you will see improper message.
     * But it will print message properly only if we call wish() method from multiple threads on the same object of Display class.
     * It will not work if we call wish() method from multiple threads on different objects of Display class.
     * It is because synchronized keyword works on the concept of Object level lock.
     * If you want to allow only one wish() method be be executed at a time irrespective of from which object it was called then for that purpose you will need class level lock.
     * You can get class level lock by using "static" and "synchronized" modifiers simultaneously i.e by using "static synchronized" modifier.
     */
    public synchronized void wish(String name) {
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