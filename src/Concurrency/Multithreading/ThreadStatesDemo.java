package Concurrency.Multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStatesDemo {
    static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        ReentrantLock lock = new ReentrantLock();
        Condition cond = lock.newCondition();

        // NEW -> RUNNABLE -> TERMINATED
        Thread runnable = new Thread(() -> {
            while (!stop) { /* busy spin */ }
        });
        System.out.println("runnable (before start)      : " + runnable.getState());
        runnable.start();
        Thread.sleep(100);
        System.out.println("runnable (spinning)          : " + runnable.getState());

        // BLOCKED: waiting to enter a synchronized block held by main
        Thread blocked;
        synchronized (monitor) {
            blocked = new Thread(() -> {
                synchronized (monitor) { }
            });
            blocked.start();
            Thread.sleep(100);
            System.out.println("blocked (synchronized)       : " + blocked.getState());
        }

        // WAITING: Object.wait()
        Thread waiting = new Thread(() -> {
            synchronized (monitor) {
                try { monitor.wait(); } catch (InterruptedException ignored) { }
            }
        });
        waiting.start();
        Thread.sleep(100);
        System.out.println("waiting (Object.wait)        : " + waiting.getState());

        // WAITING: Condition.await() on a ReentrantLock
        Thread condWaiting = new Thread(() -> {
            lock.lock();
            try { cond.awaitUninterruptibly(); } finally { lock.unlock(); }
        });
        condWaiting.start();
        Thread.sleep(100);
        System.out.println("waiting (Condition.await)    : " + condWaiting.getState());

        // WAITING (not BLOCKED!): lock.lock() contention on a ReentrantLock
        lock.lock();
        Thread lockWaiter = new Thread(() -> {
            lock.lock();
            lock.unlock();
        });
        lockWaiter.start();
        Thread.sleep(100);
        System.out.println("waiting (ReentrantLock.lock) : " + lockWaiter.getState());
        lock.unlock();

        // TIMED_WAITING: sleep
        Thread timed = new Thread(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException ignored) { }
        });
        timed.start();
        Thread.sleep(100);
        System.out.println("timed_waiting (sleep)        : " + timed.getState());

        // cleanup -> TERMINATED
        stop = true;
        synchronized (monitor) { monitor.notifyAll(); }
        lock.lock();
        try { cond.signalAll(); } finally { lock.unlock(); }
        timed.interrupt();
        runnable.join();
        waiting.join();
        condWaiting.join();
        timed.join();
        System.out.println("runnable (after finish)      : " + runnable.getState());
    }
}
