package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//03 Find the word that has the second highest length
public class Q3 {


    public static void main(String[] args) {


        String words="Hi Hi Hi Hi Hello Hello";
//        System.out.println(Arrays.stream(words.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).skip(1).;
    }
}
