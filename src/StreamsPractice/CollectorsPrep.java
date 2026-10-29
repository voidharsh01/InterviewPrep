package StreamsPractice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsPrep {

    public static void main(String[] args) {
        List<String> words = List.of(
                "java", "sql", "java", "spring",
                "sql", "java", "docker", "spring"
        );

        Map<String,Long> map1=words.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()>1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        List<Employee> employees = List.of(
                new Employee("Amit", "IT", 90000),
                new Employee("Neha", "IT", 120000),
                new Employee("Raj", "HR", 80000),
                new Employee("Priya", "HR", 95000),
                new Employee("Vikas", "IT", 110000),
                new Employee("Riya", "Finance", 100000)
        );

        Map<String, Optional<Integer>> map3=employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.mapping(Employee::salary,Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,x->x.getValue().stream().sorted(Comparator.reverseOrder()).skip(1).findFirst()));

        System.out.println(map3);
        record Developer(String name, List<String> skills) {}

        List<Developer> developers = List.of(
                new Developer("Amit", List.of("Java", "SQL", "Docker")),
                new Developer("Neha", List.of("Java", "Kafka")),
                new Developer("Raj", List.of("SQL", "Spring Boot"))
        );
        List<String> distinctSkills=developers.stream()
                        .flatMap(x->x.skills().stream()).sorted().distinct().toList();
        System.out.println(distinctSkills);
        System.out.println(map1);



        //Question :Find first non repeating character in a string

        String str="HHaarsh";

        Optional<String> op=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(op.get());
    }
}
