package StreamsPractice;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class StreamsInterviewRound1 {

    record Employee(
            int id,
            String name,
            String department,
            int salary,
            List<String> skills
    ) {}

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Amit11111111", "IT", 90000,
                        List.of("Java", "SQL")),
                new Employee(2, "Neha", "IT", 80000,
                        List.of("Java", "Spring")),
                new Employee(3, "Ravi", "IT", 80000,
                        List.of("SQL", "Kafka111111111")),
                new Employee(4, "Sara1111111", "HR", 70000,
                        List.of("Excel", "SQL")),
                new Employee(5, "John", "HR", 60000,
                        List.of("Excel", "Java")),
                new Employee(6, "Priy11111a", "HR", 60000,
                        List.of("Java", "Spring"))
        );

        // Q1. Find the second-highest distinct salary
        // from a list of integers.
        Optional<Integer> salary=employees.stream()
                .map(Employee::salary).
                distinct().
                sorted(Comparator.reverseOrder()).
                skip(1).findFirst();
        System.out.println(salary.orElseGet(()->{

            return -1;
        }));



        // Q2. Group employees by department.
        // Expected return type: Map<String, List<Employee>>


        Map<String,List<Employee>> map=employees.stream()
                .collect(Collectors.groupingBy(Employee::department));

        System.out.println(map);

        // Q3. Count employees in each department.
        // Expected return type: Map<String, Long>

        Map<String,Long> map2=employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.counting()));
        System.out.println(map2);
        // Q4. Find the highest-paid employee in each department.
        // Expected return type: Map<String, Optional<Employee>>

        Map<String,Optional<Employee>> map3=employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparingInt(Employee::salary).reversed())));
        System.out.println(map3);
        // Q5. Convert employees into a Map<Integer, Employee>
        // using employee ID as the key.
        // If duplicate IDs occur, keep the employee
        // with the higher salary.

        Map<Integer, Employee> map4=employees.stream()
                .collect
                        (Collectors.toMap(Employee::id, x->x,(old,n)->{
                            if(old.salary()>n.salary())
                                return old;
                            else
                                return n;
                        }
                ));
        // Q6. Flatten all employee skills into a list
        // containing unique skills in alphabetical order.


        employees.stream()
                .flatMap(x->x.skills().stream()).distinct().sorted().forEach(System.out::print);


        // Q7. Department-wise salary statistics
        // Return Map<String, IntSummaryStatistics>.
        // For each department, calculate:
        // - Employee count
        // - Minimum salary
        // - Maximum salary
        // - Average salary
        // - Total salary

        Map<String, IntSummaryStatistics> map12=employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.summarizingInt(Employee::salary)));
        System.out.println("MAP12---------------------------------------------------------------------------");
        System.out.println(map12.get("HR").getAverage());
        // Q8. Nested grouping: department -> salary -> employee names
        // Return Map<String, Map<Integer, List<String>>>.
        // Group employees by department, then by salary.
        // Store employee names in the innermost list.


        Map<String,Map<Integer,List<Employee>>> map6=employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.groupingBy(Employee::salary,Collectors.toList())));
        System.out.println(map6);
        // Q9. Partition employees by salary
        // Return Map<Boolean, Long>.
        // Count employees earning >= 80000 and employees
        // earning < 80000.
        // true = salary >= 80000
        // false = salary < 80000
        System.out.println("map13-------------------------------------------------------------------------------");
        Map<Boolean,List<Employee>> map13=employees.stream()
                .collect(Collectors.partitioningBy(x->x.salary()>=80000));

        System.out.println(map13);

        // Q10. First non-repeating character
        // Given a string, find the first character that
        // appears exactly once, preserving encounter order.
        // Return Optional<Character>.
        // Expected result for "swiss": Optional[w]

        String input = "swiss";
        System.out.println("Q10--------------------------------------------------------------------------");
        System.out.println(Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),LinkedHashMap::new,Collectors.counting()
                )).entrySet()
                .stream()
                .filter(x->x.getValue()==1).map(Map.Entry::getKey)
                .findFirst().get());



        // Q11. Sort a map by values
        // Sort entries by:
        // 1. Value descending
        // 2. Key ascending when values are equal
        // Return the sorted entries as a List<Map.Entry<String, Integer>>.

        Map<String, Integer> scores = Map.of(
                "Amit", 80,
                "Neha", 95,
                "Ravi", 80,
                "Sara", 90
        );

                scores
                        .entrySet().
                stream()
                .sorted(Comparator.comparing((Map.Entry<String,Integer> x)->x.getValue()).reversed().thenComparing(Map.Entry::getKey))
                        .collect(Collectors.toMap(
                                x->x.getKey(),

                                x->x.getValue(),
                                (a, b) -> a,LinkedHashMap::new
                        ));


        // Q12. Group anagrams
        // Group words containing the same characters.
        // Return Map<String, List<String>>.
        // Expected groups, in any order:
        // [eat, tea, ate]
        // [tan, nat]
        // [bat]

        List<String> words = List.of(
                "eat", "tea", "tan", "ate", "nat", "bat"
        );

        System.out.println();
        Map<String,List<String>> map9=words.stream()
                .collect(Collectors.groupingBy(x->{

                    return x.chars().sorted().mapToObj(xx->String.valueOf(xx)).collect(Collectors.joining());
                }));
        System.out.println(map9);


        // Q13. Longest employee name in each department
        // Return Map<String, Optional<Employee>>.
        // If multiple employees have the same maximum name
        // length, any one of them may be selected.
        System.out.println("---------------------------------------------------------------------------------------");
        Map<String, Optional<Employee>> map7=employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparing(Employee::name).reversed())));
        System.out.println(map7);
        // Q14. Merge two integer lists, remove duplicates,
        // and return the unique elements in ascending order.
        // Return List<Integer>.
        // Expected result: [1, 2, 3, 4, 5]

        List<Integer> a = List.of(1, 4, 2, 4);
        List<Integer> b = List.of(3, 2, 5, 1);

        Stream.concat(a.stream(),b.stream()).distinct().sorted().forEach(System.out::println);



    }
}
