package Streams;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

//01 Given a sentence, find the word that has the highest length
public class Q1 {
    public static void main(String[] args) {
        
        String s="My name is Harsh. I am a boy Harqh.";

        System.out.println(Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(String::length, TreeMap::new,Collectors.toList())).lastEntry().getValue());
    }
}
