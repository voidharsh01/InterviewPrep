package Streams;

import java.util.ArrayList;
import java.util.List;

// API - 34 Generate the first 10 numbers of the Fibonacci Sequence
public class Q34 {
    public static void modifyList(List<Integer> list){
        list.add(4);
    }
    public static void main(String[] args) {
        // 0 1 1 2 3 5
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        modifyList(list1);
        System.out.println(list1)


    }
}
