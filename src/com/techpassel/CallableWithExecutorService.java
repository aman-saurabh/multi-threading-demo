package com.techpassel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //MyCallable class is defined in CallableDemo.java file.Reused that in this file also.
        MyCallable[] jobs = new MyCallable[6];
        for(int i = 0; i<6; i++){
            jobs[i] = new MyCallable();
        }
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (MyCallable job : jobs){
            Future f = service.submit(job);
            System.out.println(f.get());
        }
    }
}

