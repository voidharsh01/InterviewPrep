package Streams;

import java.util.Arrays;
import java.util.Comparator;

//04 Find the 2nd highest length word in the given sentence
public class Q4 {

    public static void main(String[] args) {
        String s="Hello I am Hardhi";
        System.out.println(Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().get());
    }
}
