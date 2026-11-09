package Concurrency.Multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCLASS {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                            5,
                6,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1)
        );

        Runnable runnable=()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i=1;i<=10;i++)
                    System.out.println(i);
        };
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);





    }
}
