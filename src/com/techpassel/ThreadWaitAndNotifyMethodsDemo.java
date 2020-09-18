package com.techpassel;

public class ThreadWaitAndNotifyMethodsDemo {
    public static void main(String[] args) throws InterruptedException {
        ChildThread ct = new ChildThread();
        ct.start();
        synchronized (ct){
            //To call wait() method on ChildThread class object we need lock of that object.That's why we have passed ct(i.e ChildThread class object on which we want to call wait method) as argument.
            System.out.println("Main thread execution starts and now calling wait method on ChildThread object.");
            /*
             * It might be possible that child thread gets chance first to perform its execution.
             * So in that case child thread will call notify() method before main thread calls wait() method.Therefore when main thread will actually call wait() method after that it will never be notified and main thread will stuck into deadlock situation.
             * To ignore such situations these two suggestions are recommended.
             * 1. The item on which you want updation first check whether it is updated or not.If it is not updated then only call wait() method.
             * 2. To be on safer side always pass time(in ms) as argument in wait method.So that if it never gets notified then after the specified time period it can continue its execution again.
             */
            if(ct.count ==0)
                ct.wait(10000);
            System.out.println("Main thread get's notified");
            System.out.println("The count value is : "+ct.count);
            //This kind of execution will ensure that you always get correct value(like in this case count value).
        }
    }
}

class ChildThread extends Thread {
    int count = 0;
    public void run() {
        synchronized (this) {
            System.out.println("Child Thread execution starts");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            System.out.println("Child thread is calling notify method on its current object.");
            this.notify();
            System.out.println("Child thread's execution ends");
        }
    }
}