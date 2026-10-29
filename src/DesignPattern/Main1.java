package DesignPattern;

import java.util.concurrent.atomic.AtomicReference;

public class Main1 {

    public static void main(String[] args) {
        AtomicReference<Singleton> singleton1 = null;
        AtomicReference<Singleton> singleton2 = null;

        Thread t1=new Thread(()->{
           singleton1.set(Singleton.getInstance());
        });
        Thread t2=new Thread(()->{
            singleton2.set(Singleton.getInstance());
        });

        System.out.println(singleton1==singleton2);

        StudentBuilder studentBuilder=new StudentBuilder();
        Student student=studentBuilder.name("Harsh").address("DLF").build();
        System.out.println(student.getAddress());
    }
}
