package Multithreading.LocalThread123;

import java.lang.ref.WeakReference;

public class ThreadLocalkke {

    public static void main(String[] args) throws InterruptedException {


        ThreadLocal<Integer> th=ThreadLocal.withInitial(()->1234);


        Thread t=new Thread(()->{
            th.set(212212);
            System.out.println(th.get());
        });
        t.start();
        t.join();

        System.out.println(th.get());
        WeakReference<Integer> wk=new WeakReference<>(1234);


        System.gc();

        System.gc();

        Thread.sleep(1000);

        System.out.println(wk.get());


    }
}
