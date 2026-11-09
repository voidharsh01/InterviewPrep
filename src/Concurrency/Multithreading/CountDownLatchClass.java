package Concurrency.Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchClass {

    public static void main(String[] args) {


        CountDownLatch countDownLatch=new CountDownLatch(3);

        Thread t1=new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        });


        Thread t2=new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        });


        Thread t3=new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        });
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Prinitng from main thread");
        try{
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
