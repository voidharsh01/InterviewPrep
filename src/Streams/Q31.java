package Streams;

import java.util.stream.IntStream;

//API - 30 Convert a list of strings to uppercase
public class Q31 {

    public static void main(String[] args) {


        System.out.println(IntStream.rangeClosed(1,100).average().getAsDouble());
    }
}
