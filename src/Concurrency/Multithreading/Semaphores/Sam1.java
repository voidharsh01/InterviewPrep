package Concurrency.Multithreading.Semaphores;

import java.util.concurrent.Semaphore;

public class Sam1 {
    static Semaphore semaphore=new Semaphore(3);
    static void checkAPI() throws InterruptedException {
            try {
                semaphore.acquire();
                System.out.println("Acquired");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }





    }
    public static void main(String[] args) throws InterruptedException {






        for(int i=1;i<=5;i++)
        {

            Thread t=new Thread(()-> {
                try {
                    checkAPI();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    throw new RuntimeException(e);
                }
            });
            t.start();

        }


    }
}
