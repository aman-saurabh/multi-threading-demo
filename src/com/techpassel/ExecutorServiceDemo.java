package com.techpassel;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        PrintJob[] jobs = {
                new PrintJob("Cooking"),
                new PrintJob("Sleeping"),
                new PrintJob("Playing"),
                new PrintJob("Eating"),
                new PrintJob("Reading"),
                new PrintJob("Walking")
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (PrintJob p: jobs) {
            //It will create new thread and call it's start() method automatically.
            service.submit(p);
        }
        service.shutdown();
    }
}

class PrintJob implements Runnable{
    String name;
    PrintJob(String name){
        this.name = name;
    }
    public void run() {
        System.out.println(name+" - Job started by thread : "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name+" - Job completed by thread : "+ Thread.currentThread().getName());
    }
}
