package com.techpassel;

public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        Display2 d1 = new Display2();
        Display2 d2 = new Display2();
        MyThread2 t1 = new MyThread2(d1, "Aman");
        MyThread2 t2 = new MyThread2(d2, "Saurabh");
        t1.start();
        t2.start();
    }
}

class MyThread2 extends Thread {
    Display2 d;
    MyThread2(Display2 d, String name){
        this.d = d;
        this.setName(name);
    }
    public void run() {
        d.wish(Thread.currentThread().getName());
    }
}

class Display2 {
    public void wish(String threadName){
        //To represent that area which should not be synchronized.
        //You will see code from both thread got mixed and not printing message one by one.
        for (int i =0; i < 100; i++){
            System.out.println("I am non-synchronized.Called using thread : "+threadName);
        }
        System.out.println("Non synchronized area code execution completes for thread :" +threadName);

        //To represent that area which should be synchronized.
        //You will see once printing of one thread ends then only printing of second thread starts.
        //This is class level lock for blocks.For object level lock for blocks just pass "this" as argument inplace of "Display2.class".
        synchronized (Display2.class) {
            for (int i = 0; i <10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("I am synchronized.Called using thread : "+threadName+".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}