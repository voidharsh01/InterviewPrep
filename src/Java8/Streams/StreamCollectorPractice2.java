package Java8.Streams;


import java.util.*;
import java.util.stream.Collectors;

class Employee3 {
    private String name;
    private String department;
    private String gender;
    private String designation;
    private int age;
    private double salary;

    public Employee3(String name, String department, String gender,
                     String designation, int age, double salary) {
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.designation = designation;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getGender() { return gender; }
    public String getDesignation() { return designation; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + salary + ")";
    }
}

public class StreamCollectorPractice2 {

    static List<Employee3> employees = List.of(

            // IT Department
            new Employee3("Amit", "IT", "Male", "Developer", 25, 1200000),
            new Employee3("Rahul", "IT", "Male", "Developer", 28, 1500000),
            new Employee3("Priya", "IT", "Female", "Manager", 32, 1800000),
            new Employee3("Neha", "IT", "Female", "Developer", 26, 1200000),
            new Employee3("Karan", "IT", "Male", "Architect", 35, 2200000),

            // HR Department
            new Employee3("Sneha", "HR", "Female", "HR Executive", 27, 700000),
            new Employee3("Rohit", "HR", "Male", "HR Executive", 30, 800000),
            new Employee3("Anjali", "HR", "Female", "Manager", 34, 1100000),

            // Finance Department
            new Employee3("Vikas", "Finance", "Male", "Analyst", 29, 900000),
            new Employee3("Pooja", "Finance", "Female", "Analyst", 31, 900000),
            new Employee3("Meera", "Finance", "Female", "Manager", 36, 1400000),

            // Marketing Department
            new Employee3("Arjun", "Marketing", "Male", "Executive", 25, 600000),
            new Employee3("Simran", "Marketing", "Female", "Executive", 26, 750000),
            new Employee3("Dev", "Marketing", "Male", "Manager", 33, 950000)
    );

    public static void main(String[] args) {


        // Q1. Count the number of employees in each department.
        // Expected: Map<String, Long>
//        Map<String,Long> m1=employees.stream()
//                .collect(Collectors.groupingBy(Employee3::getDepartment,Collectors.counting()));
//
//        // Q2. Calculate the average salary of each department.
//        // Expected: Map<String, Double>
//        Map<String,Double> m2=employees.stream()
//                .collect(Collectors.groupingBy(Employee3::getDepartment,Collectors.averagingDouble(Employee3::getSalary)));


        // Q3. Find the highest-paid employee in each department.
        // Expected: Map<String, Optional<Employee>>
//        Map<String, Optional<Employee3>> m3=employees.stream()
//                .collect(Collectors.groupingBy(Employee3::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee3::getSalary))));


        // Q4. Group employee names by department.
        // Expected: Map<String, List<String>>

//        Map<String,List<Employee3>> m4=employees.stream()
//                .collect(Collectors.groupingBy(Employee3::getDepartment));


        // Q5. Find all unique designations in each department.
        // Expected: Map<String, Set<String>>
//        employees.stream()
//                .collect(Collectors.groupingBy(Employee3::getDepartment,Collectors.collectingAndThen(Collectors.mapping(x->x.d))));
        
        // Q6. Group employees first by department and then by gender.
        // Expected: Map<String, Map<String, List<Employee>>>


        // Q7. Calculate total salary by department and then by gender.
        // Expected: Map<String, Map<String, Double>>


        // Q8. Count employees earning more than 10 lakhs in each department.
        // Important: Departments with zero qualifying employees
        // should also be present.
        // Expected: Map<String, Long>


        // Q9. Find the second-highest DISTINCT salary in each department.
        // Expected: Map<String, Optional<Double>>


        // Q10. Find the top 3 highest-paid employees in each department.
        // Expected: Map<String, List<Employee>>


        // Q11. Find the department having the highest average salary.
        // Expected: Optional<Map.Entry<String, Double>>


        // Q12. Partition employees based on salary > 10 lakhs
        // and count employees in each partition.
        // Expected: Map<Boolean, Long>


        // Q13. Calculate the sum of salaries in each department
        // using Collectors.reducing().
        // Expected: Map<String, Double>


        // Q14. Find the names of employees earning more than
        // the average salary of their respective department.
        // Expected: Map<String, List<String>>


        // Q15. Group employees by department and return
        // only the maximum salary (not Optional<Double>).
        // Expected: Map<String, Double>
        // Hint: collectingAndThen + maxBy
    }

}

