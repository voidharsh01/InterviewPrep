package Concurrency.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockClass {

    public static void main(String[] args) {

        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();

        Thread t1=new Thread(()->{


            lock1.lock();


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(lock2.tryLock()==false){
                lock1.unlock();
            }
            System.out.println("Thread 1 completed");
        });


        Thread t2=new Thread(()->{


            lock2.lock();


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(lock1.tryLock()==false){
                lock2.unlock();
            }
            System.out.println("Thread 2 completed");
        });

        t1.start();
        t2.start();


    }
}
