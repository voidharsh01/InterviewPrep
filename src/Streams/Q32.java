package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//API -32 Find the intersection of two lists using Java streams
public class Q32 {


    public static void main(String[] args) {
        List<Integer> list1= Arrays.asList(1,2,3,10,11,12,13);
        List<Integer> list2=Arrays.asList(1,2,3,11,12,13);
            list1.stream().filter(x->list2.stream().filter(x2->x2==x).collect(Collectors.counting())>0).forEach(System.out::println);
    }

}
