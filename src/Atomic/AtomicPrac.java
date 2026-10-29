package Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicPrac {


    public static void main(String[] args) {


        AtomicReference<String> stringAtomicReference=new AtomicReference<>("PENDING");




        System.out.println(stringAtomicReference.compareAndSet("PENDING","FINISHED"));


        AtomicInteger atm1=new AtomicInteger(0);


    }
}
