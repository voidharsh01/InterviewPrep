package Java8.FunctionalInterfaces;

import java.util.function.*;

public class FunctionalInterfaceClass {

    public static void main(String[] args) {


        Function<String,Integer> f1=(x)->x.length();
        System.out.println(f1.apply("Harsh"));


        Supplier<Integer> f2=()->3;
        System.out.println(f2.get());

        Consumer<String> f3=(x)-> {
            System.out.println(x);
        };
        f3.accept("Harsh");

        Predicate<Integer> f4=x->x%2==0;

        System.out.println(f4.test(10));

        BiFunction<String,String,String> f5=(x1,x2)->x1+x2;

        System.out.println(f5.apply("Harsh","Srivastava"));

    }
}
