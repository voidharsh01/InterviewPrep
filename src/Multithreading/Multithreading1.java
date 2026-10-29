package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multithreading1 {

    public static void main(String[] args) throws InterruptedException {

        Runnable callable=()->{

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello");


        };
        Thread t=new Thread((Runnable) callable);

        Runnable run2=()->{
            System.out.println("Runnable 2");
        };
        Thread t2=new Thread(run2);

        ExecutorService executorService= Executors.newFixedThreadPool(5);

        Future<?> future=executorService.submit(()->{
            System.out.println("Hello");
        });
        t.start();
        t.join();
        t2.start();



    }
}
