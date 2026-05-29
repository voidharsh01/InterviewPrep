package Streams;

import java.util.List;
class Employee {

    private String name;
    private String department;
    private int salary;

    public Employee(String name,
                    String department,
                    int salary) {

        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " " + salary;
    }
}

public class FlatMap {

    public static void main(String[] args) {

        List<List<Integer>> list1=List.of(
                List.of(1,2,3),
                List.of(4,5,6),
                List.of(7,1,2,3)
        );
        list1.stream()
                .flatMap(x->x.stream())
                .distinct()
                .forEach(System.out::println);


        List<Employee> employees =
                List.of(
                        new Employee("Harsh", "IT", 70000),
                        new Employee("Aman", "IT", 50000),
                        new Employee("Bob", "HR", 40000),
                        new Employee("Charlie", "HR", 60000),
                        new Employee("David", "IT", 70000)
                );

        /*


Find all employee names with salary > 50000
Sort by:
salary descending
then name ascending
Group employees by department
Find highest salary employee
Find department-wise average salary
         */


        employees.stream()
                .filter(x->x.getSalary()>5000)
                .map(x->x.getName())
                .forEach(System.out::println);



    }
}
