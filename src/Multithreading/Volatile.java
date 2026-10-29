package Multithreading;

import java.util.concurrent.Executors;

public class Volatile {
    public static void main(String[] args) throws InterruptedException {

            Bucket bucket=new Bucket();
            Thread producer=new Thread(()->{
                for(int i=1;i<=10;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        bucket.produce(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        });

        Thread consumer=new Thread(()->{
            for(int i=1;i<=10;i++){
            try {
                bucket.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }}
        });
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}

 class Bucket{

    volatile boolean produced;
    volatile Integer value;
    Bucket(){
        produced=false;
        value=null;
    }

    synchronized void produce(int value) throws InterruptedException {

        while(produced==true){
            wait();
        }
        produced=true;
        this.value=value;
        notify();
        System.out.println("Produced value is "+value);
    }

    synchronized void consume() throws InterruptedException {

        while(produced==false){
            wait();
        }
        System.out.println("Consumed value is "+value);
        produced=false;
        notify();


    }

}
