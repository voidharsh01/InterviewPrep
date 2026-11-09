package Java8.Streams;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.*;

public class StreamPractice2 {

    record Employee(
            int id,
            String name,
            String department,
            double salary,
            int age
    ) {}

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", 150000, 28),
                new Employee(2, "Rahul", "IT", 120000, 30),
                new Employee(3, "Priya", "HR", 90000, 26),
                new Employee(4, "John", "HR", 80000, 32),
                new Employee(5, "David", "Finance", 130000, 35),
                new Employee(6, "Mike", "Finance", 110000, 29),
                new Employee(7, "Sara", "IT", 120000, 27),
                new Employee(8, "Neha", "HR", 95000, 25)
        );




       // Q1. Find the second-highest distinct salary in each department.

       Map<String,Optional<Double>> map2=employees.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.collectingAndThen(Collectors.mapping(x->x.salary(),Collectors.toList()),x->x.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst())));

      /*

Q2. Find employees whose salary is greater than their department's average salary.
  */
        Map<String, Double> avgSal=employees.stream()
                        .collect(Collectors.groupingBy(Employee::department,Collectors.averagingDouble(Employee::salary)));
        employees.stream().filter(x->x.salary()>avgSal.get(x.department())).toList();

/*
Q3. Group employees by department and return a list of employee names for each department.


    Map
Q4. Find the youngest employee in each department.

Q5. Find the department having the highest average salary.

Q6. Sort employees by salary descending and name ascending when salaries are equal.
Level 2 — Medium-Hard
Q7. Find the top 2 highest-paid employees in each department.

Q8. Find duplicate employee names and their frequencies.

Q9. Find the highest-paid employee in each department, but return only employees earning more than 100000.

Q10. Calculate the average salary, maximum salary and employee count for every department in a single grouping operation.

Q11. Partition employees into two groups: salary greater than or equal to 100000 and salary below 100000.

Q12. Find the department with the second-highest average salary.
Level 3 — Hard
Q13. Find the top 3 employees across all departments by salary, but ensure that employees with identical salaries are ordered alphabetically.

Q14. Find departments where every employee earns more than 80000.

Q15. Find departments where at least two employees are older than 28.

Q16. Create a Map of department to highest-paid employee using downstream collectors.

Q17. Find the employee with the third-highest distinct salary across the entire organization.

Q18. Group employees by department and then partition each department into employees above and below its average salary.

Q19. Find the most frequently occurring salary across all employees.




Q20. Generate a Map containing department-wise salary statistics: count, sum, average, minimum and maximum.








         */

    }
}