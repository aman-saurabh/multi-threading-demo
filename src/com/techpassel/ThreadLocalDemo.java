package com.techpassel;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        MyParentThread pt = new MyParentThread();
        pt.start();
    }
}

class MyParentThread extends Thread {
    public static ThreadLocal tl = new ThreadLocal();
    public void run(){
        tl.set("PT");
        System.out.println("Parent thread ThreadLocal value : "+tl.get());
        MyChildThread ct = new MyChildThread();
        ct.start();
    }
}

class MyChildThread extends Thread {
    public void run() {
        System.out.println("Child thread ThreadLocal value : "+MyParentThread.tl.get());
    }
}