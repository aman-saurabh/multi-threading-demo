package com.techpassel;

public class InheritedThreadLocalDemo {
    public static void main(String[] args) {
        MyParentThread1 pt = new MyParentThread1();
        pt.start();
    }
}

class MyParentThread1 extends Thread {
    public static InheritableThreadLocal tl = new InheritableThreadLocal(){
        //To set default value for child thread.
        protected Object childValue(Object parentValue) {
            return "CT";
        }
    };
    //If we don't set default value for child thread i.e if we comment above lines and uncomment below line then same value will be returned in parent thread as well as in child thread.
    //public static InheritableThreadLocal tl = new InheritableThreadLocal();
    public void run(){
        tl.set("PT");
        System.out.println("Parent thread ThreadLocal value : "+tl.get());
        MyChildThread1 ct = new MyChildThread1();
        ct.start();
    }
}


class MyChildThread1 extends Thread {
    public void run() {
        System.out.println("Child thread ThreadLocal value : "+MyParentThread1.tl.get());
    }
}

