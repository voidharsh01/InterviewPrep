package StreamsPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapPrac {
    public static int printi(){
        System.out.println("hel");
        return 0;
    }
    public static void main(String[] args) {

        List<String> sentences = List.of(
                "Java is powerful",
                "Spring Boot is popular",
                "Streams simplify processing"
        );

       sentences.stream()
               .flatMap(x-> Arrays.stream(x.split(" ")))
               .distinct()
               .forEach(System.out::println);
       List<Student> studentList=List.of(new Student(1,"Harsh"),
               new Student(1,"Harsh2"));

      studentList.stream()
                       .collect(Collectors.toMap(x->x.name,x->x.name,(x1,x2)->x1+","+x2))
               .entrySet()
               .stream()
               .forEach(x->{
                   System.out.println(x.getKey()+" "+x.getValue());
               });
       studentList.stream()
               .distinct()
               .forEach(System.out::println);

        Optional<Integer> op=Optional.of(1);

        op.orElseGet(()->printi());


    }
}
