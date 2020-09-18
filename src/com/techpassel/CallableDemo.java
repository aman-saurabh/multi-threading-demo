package com.techpassel;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable r1= new MyCallable();
        MyCallable r2= new MyCallable();
        MyCallable r3= new MyCallable();
        FutureTask[] fts= {
                new FutureTask(r1),
                new FutureTask(r2),
                new FutureTask(r3)
        };
        for (FutureTask ft: fts) {
            Thread t = new Thread(ft);
            t.start();
            System.out.println(ft.get());
        }
    }
}

class MyCallable implements Callable{
    int sum = 0;
    @Override
    public Object call() throws Exception {
        for (int i =0; i<3; i++){
            // Create random number generator
            Random generator = new Random();
            //It will generate a random number between 1 and given number as argument(in this case 99)
            Integer randomNumber = generator.nextInt(99);
            sum += randomNumber;
        }
        return sum;
    }
}
