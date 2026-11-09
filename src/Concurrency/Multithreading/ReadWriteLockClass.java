package Concurrency.Multithreading;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockClass {
    public static void sharedMethod(Lock lock){

        lock.lock();
        System.out.println(Thread.currentThread().getName()+" is reading");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock.unlock();


    }
    public static void main(String[] args) {

        ReadWriteLock lock=new ReentrantReadWriteLock();
        AtomicReference atm=new AtomicReference();
        Lock read= lock.readLock();
        Lock write=lock.writeLock();

        Thread t1=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedMethod(read);
        });

        Thread t2=new Thread(()->{
            sharedMethod(write);
        });

        t1.start();
        t2.start();




    }
}
