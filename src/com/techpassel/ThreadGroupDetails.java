package com.techpassel;

public class ThreadGroupDetails {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg = new ThreadGroup("ParentTG");
        ThreadGroup ctg1 = new ThreadGroup(tg, "FirstChildTG");
        ThreadGroup ctg2 = new ThreadGroup(tg, "SecondChildTG");
        TGChildThread1 r1 = new TGChildThread1();
        TGChildThread2 r2 = new TGChildThread2();
        TGChildThread3 r3 = new TGChildThread3();
        TGChildThread4 r4 = new TGChildThread4();
        TGChildThread5 r5 = new TGChildThread5();
        Thread t1 = new Thread(tg,r1);
        Thread t2 = new Thread(ctg1,r2);
        Thread t3 = new Thread(ctg1,r3);
        Thread t4 = new Thread(ctg2,r4);
        Thread t5 = new Thread(ctg2,r5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        //Will print details of Given ThreadGroup and its child subgroup
        tg.list();
        System.out.println("ParentTG active count : "+tg.activeCount());
        System.out.println("ParentTG active group count : "+tg.activeGroupCount());
        System.out.println("FirstChildTG active count : "+ctg1.activeCount());
        Thread[] ta = new Thread[10];
        //To copy all the active threads of given thread group into an array of threads(passed as argument).
        tg.enumerate(ta);
        for (Thread a: ta){
            if(a != null)
            System.out.println("A : "+a);
        }

        ThreadGroup[] tga = new ThreadGroup[10];
        //To copy all the active subthreadgroups of given thread group into an array of threadgroup(passed as argument).
        tg.enumerate(tga);
        for (ThreadGroup b: tga){
            if(b != null)
            System.out.println("B : "+b);
        }
        Thread.sleep(2000);
        System.out.println("ParentTG active count : "+tg.activeCount());
        System.out.println("ParentTG active group count : "+tg.activeGroupCount());
        tg.destroy();
        System.out.println("ParentTG active count : "+tg.activeCount());
        System.out.println("ParentTG active group count : "+tg.activeGroupCount());
    }
}

class TGChildThread1 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("TGChildThread1");
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}

class TGChildThread2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("TGChildThread2");
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}

class TGChildThread3 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("TGChildThread3");
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}

class TGChildThread4 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("TGChildThread4");
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}

class TGChildThread5 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("TGChildThread5");
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}