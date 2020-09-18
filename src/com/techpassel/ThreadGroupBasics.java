package com.techpassel;

public class ThreadGroupBasics {
    public static void main(String[] args) {
        System.out.println("Thread group information of main thread");
        System.out.println("ThreadGroup name : "+Thread.currentThread().getThreadGroup().getName());
        System.out.println("Parent ThreadGroup name : "+Thread.currentThread().getThreadGroup().getParent().getName());
        ThreadGroup tg = new ThreadGroup("First Group");
        Runnable r= () -> {
            System.out.println("Thread group information of child thread");
            System.out.println("ThreadGroup name : "+Thread.currentThread().getThreadGroup().getName());
            System.out.println("Parent ThreadGroup name : "+Thread.currentThread().getThreadGroup().getParent().getName());
        };
        Thread t = new Thread(tg, r);
        t.start();
    }
}

