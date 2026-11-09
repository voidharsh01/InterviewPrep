package Concurrency.Multithreading;

import java.util.List;
import java.util.concurrent.CompletableFuture;

class Counter{

    public int count=0;

}


public class MultithreadedCounter {

    public static String getUserName() throws InterruptedException {

        Thread.sleep(10000);
        return "voidharsh";
    }
    public static void getName() throws InterruptedException {

        Thread.sleep(10000);
        throw new RuntimeException("eew");
    }

    public static List<Integer> getUserId() throws InterruptedException {

        Thread.sleep(10000);

        return List.of(1,2,3);
    }
    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<String> cmp1=CompletableFuture.supplyAsync(()-> {
            try {
                return getUserName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> cmp2=CompletableFuture.runAsync(()-> {
            try {
                getName();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


         cmp2.exceptionally(ex-> {

             System.out.println("exception");
                return null;
         });








        Counter counter=new Counter();

        Thread t1=new Thread(()->{
            for(int i=1;i<=10000;i++){

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter.count++;
            }
        });

        Thread t2=new Thread(()->{
            for(int i=1;i<=10000;i++){
                counter.count++;
            }
        });
    t1.start();
    t2.start();

    t1.join();

    t2.join();

        System.out.println(counter.count);

    }
}
