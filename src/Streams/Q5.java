package Streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

//05 Given a sentence, find the occurrence of each word
public class Q5 {

    public static void main(String[] args) {
        String s="My name is Harsh Harsh is my jame";

        Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .forEach(x->{
                    System.out.println(x.getKey()+ "occurs "+x.getValue());
                });
    }
}
