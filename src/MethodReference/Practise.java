package MethodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Employee {

    String name;

    Employee(String name) {
        this.name = name;
    }
}
public class Practise {


    public static void main(String[] args) {
        List<String> nums =
                List.of("1", "2", "3", "4");



        nums.stream()
                .map(Integer::parseInt).toList();

        List<String> words =
                List.of("java", "spring", "aws");

        List<String> upper =
                words.stream()
                        .map(String::toUpperCase)
                        .toList();

        System.out.println(upper);

        List<String> wordList =
                new ArrayList<>(
                        List.of("banana", "cat", "apple"));
        wordList.stream().sorted(String::compareTo);

    }
}
