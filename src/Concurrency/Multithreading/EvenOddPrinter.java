package Concurrency.Multithreading;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddPrinter {
    static int turn=0;
    static AtomicReference<Thread> evenT=new AtomicReference<>();
    static AtomicReference<Thread> oddT=new AtomicReference<>();
    public static void main(String[] args) {


        ReentrantLock lock=new ReentrantLock();
        Condition even1=lock.newCondition();
        Condition odd1=lock.newCondition();
        Thread odd=new Thread(()->{
                oddT.set(Thread.currentThread());
            try {
                print();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread even=new Thread(()->{

            evenT.set(Thread.currentThread());
            try {
                print();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        odd.start();
        even.start();


    }
    public static void print() throws InterruptedException {

        synchronized (EvenOddPrinter.class) {
            Thread.sleep(5000);
            System.out.println("Even "+evenT.get().getState());
            System.out.println("Odd "+oddT.get().getState());
            System.out.println("Harsh");
        }
    }
}
