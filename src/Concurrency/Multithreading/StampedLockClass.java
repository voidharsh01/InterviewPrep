package Concurrency.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

import static Concurrency.Multithreading.SharedRes.lock;

class SharedRes{
    static StampedLock lock=new StampedLock();
    public static Integer x=0;


}
public class StampedLockClass {

    public static void main(String[] args) throws InterruptedException {



        Thread t1=new Thread(()->{
            Long stamp= lock.tryOptimisticRead();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!lock.validate(stamp)){
                long stamp2= lock.readLock();
                System.out.println("Inconsitent read"+stamp2);

            }
            else{
                System.out.println("Inconsistent Read");
            }

        });


        Thread t2=new Thread(()->{

            Long stamp=SharedRes.lock.writeLock();

            SharedRes.x++;
            SharedRes.lock.unlock(stamp);
        });

        t1.start();
        t2.start();



    }
}
