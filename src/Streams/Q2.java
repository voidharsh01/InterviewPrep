package Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

//02 Remove duplicates from the string and return in the same order
public class Q2 {
    public static void main(String[] args) {
        String s="Haaarrasshhh";
        System.out.println(Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .keySet().stream().collect(Collectors.joining("")));
    }
}
