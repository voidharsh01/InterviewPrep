package Streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

//06Given a sentence, find the words with a specified number of vowels
public class Q7 {


    public static void main(String[] args) {
        int count=3;
        String vowels="aeiou";
        String s="Abcdei aei iae uoi";
        Arrays.stream(s.split(" ")).filter(x-> {
                    String str = (x.replaceAll("[^aeiouAEIOU]", ""));
                    return str.length() == count;
                }

        ).forEach(System.out::println);
    }
}
