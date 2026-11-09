package Java8.Streams;


import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class JavaStreamsPractice {

    // ==========================================
    // MODEL
    // ==========================================

    static class Employee {
        private int id;
        private String name;
        private String department;
        private int age;
        private double salary;

        public Employee(int id, String name, String department,
                        int age, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.age = age;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public int getAge() { return age; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + " (" + department + ", " + salary + ")";
        }
    }

    // ==========================================
    // TEST DATA
    // ==========================================

    static List<Employee> employees = List.of(
            new Employee(1, "Amit", "IT", 25, 70000),
            new Employee(2, "Rahul", "HR", 30, 50000),
            new Employee(3, "Neha", "IT", 28, 90000),
            new Employee(4, "Priya", "Finance", 26, 60000),
            new Employee(5, "Amit", "IT", 25, 70000),
            new Employee(6, "Karan", "HR", 35, 80000),
            new Employee(7, "Sneha", "Finance", 29, 75000),
            new Employee(8, "Rohit", "IT", 32, 95000),
            new Employee(9, "Ankit", "Sales", 27, 65000),
            new Employee(10, "Meera", "Sales", 31, 85000),
            new Employee(11, "Vikas", "HR", 24, 55000),
            new Employee(12, "Pooja", "Finance", 33, 95000)
    );

    static List<Integer> numbers = List.of(
            10, 20, 30, 40, 10, 20, 50, 60, 70
    );

    static List<String> words = List.of(
            "java", "spring", "boot", "microservices",
            "java", "spring", "kafka"
    );

    static List<List<Integer>> nestedNumbers = List.of(
            List.of(1, 2, 3),
            List.of(4, 5),
            List.of(6, 7, 8)
    );

    static List<String> sentences = List.of(
            "java spring boot",
            "spring microservices java",
            "kafka java backend"
    );

    static String text = "programming";

    record SalaryStats(double sum, double average) {}
    record SalaryRange(double min, double max) {}

    // ==========================================
    // RANDOMIZED PRACTICE QUESTIONS
    // ==========================================

    // Q1. Find the second-highest distinct salary among all employees.
    static Optional<Double> q1() {
        // Write your solution
       return employees.stream()
               .map(Employee::getSalary)
               .distinct()
               .sorted(Comparator.reverseOrder()).skip(1).findFirst();
    }

    // Q2. Convert all employee names to uppercase.
    static List<String> q2() {
        // Write your solution
        return employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase).toList();
    }

    // Q3. Find the frequency of every word in the words list.
    static Map<String, Long> q3() {
        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    }

    // Q4. Find employees whose salary is greater than 70000 and age is below 30.
    static List<Employee> q4() {
        // Write your solution



        return employees.stream()
                .filter(x->x.getAge()<30 && x.getSalary() > 70000).toList();
    }

    // Q5. Calculate the sum and average salary in a single traversal.
    static SalaryStats q5() {
        DoubleSummaryStatistics st=employees.stream()
                .map(Employee::getSalary)
                .mapToDouble(x->x.doubleValue())
                .summaryStatistics();

        return new SalaryStats(st.getSum(),st.getAverage());
    }

    // Q6. Flatten nestedNumbers into a single list.
    static List<Integer> q6() {
        return nestedNumbers.stream()
                .flatMap(x->x.stream()).toList();

    }

    // Q7. Find the employee with the highest salary in each department.
    static Map<String, Optional<Employee>> q7() {


        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    // Q8. Return the first three employees from the original list.
    static List<Employee> q8() {

        return employees.stream()
                .limit(3).toList();

    }

    // Q9. Find the first non-repeating character in text.
    static Optional<Character> q9() {

        return Arrays.stream(text.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()))

                .entrySet()
                .stream()
                .filter(x->x.getValue()==1).map(x->x.getKey().charAt(0)).findFirst();


    }

    // Q10. Check whether every employee earns more than 40000.
    static boolean q10() {
        return employees.stream()
                .allMatch(x->x.getSalary()>40000);
    }

    // Q11. Convert employees into a map using employee ID as key.
    static Map<Integer, Employee> q11() {


        return employees.stream()
                .collect(Collectors.toMap(x->x.getId(),Function.identity(),(old,new1)->new1));
    }

    //Imp Q12. Sort employees by department ascending, salary descending,
    // and name ascending.
    static List<Employee> q12() {

        return employees
                .stream()
                .sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparing(Employee::getSalary).reversed()).thenComparing(Comparator.comparing(Employee::getName))).toList();
    }

    // Q13. Calculate the product of all elements in a separate list
    // containing small positive integers.
    static int q13(List<Integer> values) {
        // Write your solution
        return 0;
    }

    // Q14. Find all distinct employee names.
    static List<String> q14() {

        return employees.stream()
                .map(x->x.getName())
                .distinct()
                .toList();
    }

    // Q15. Find employees whose salary is greater than the average
    // salary of their own department.
    static List<Employee> q15() {
        // Write your solution

        Map<String,Double> avgSal=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(x->x.getSalary())));

        return employees.stream()
                .filter(x->x.getSalary()>avgSal.get(x.getDepartment())).toList();
    }

    // Q16. Group employees by department and collect only their names.
    static Map<String, List<String>> q16() {

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(x->x.getName(),Collectors.toList())));
    }

    // Q17. Find the three highest-paid employees overall.
    static List<Employee> q17() {

        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList();
    }

    // Q18. Given a list of sentences, extract all distinct words.
    static List<String> q18() {
        // Write your solution
        return sentences.stream()
                .distinct().toList();
    }

    // Q19. Calculate the total salary of all employees.
    static double q19() {


        return employees.stream()
                .map(x->x.getSalary())
                .reduce(0.0,(x1,x2)->x1+x2);
    }

    // Q20. Divide employees into two groups based on whether
    // their age is greater than or equal to 30.
    static Map<Boolean, List<Employee>> q20() {



        return employees.stream()
                .collect(Collectors.partitioningBy(x->x.getAge()>30));
    }

    // Q21. Find all duplicate employee names and their frequencies.
    static Map<String, Long> q21() {
        return null;
    }

    // Q22. Given a list of strings, group them by length.
    static Map<Integer, List<String>> q22(List<String> values) {
        return null;
    }

    // Q23. Check whether no employee belongs to the Sales department.
    static boolean q23() {
        return false;
    }

    //IMP Q24. Find the second-highest-paid employee in each department.
    static Map<String, Optional<Employee>> q24() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.toCollection(TreeSet::new),x->x.stream().skip(1).findFirst())));
    }

    // Q25. Calculate the minimum, maximum, sum, count and average
    // of a list of integers.
//    static IntSummaryStatistics q25(List<Integer> values) {
//        values.stream()
//                .
//    }

    // Q26. Group employees by department, but include only employees
    // earning more than 70000 in each group.
    static Map<String, List<Employee>> q26() {
        return null;
    }

    // Q27. Find all employees whose names start with A or R,
    // sorted by salary descending.
    static List<Employee> q27() {
        return null;
    }

    // Q28. Given a list of integers, calculate their product.
    static int q28(List<Integer> values) {
        return 0;
    }

    // Q29. Find the department having the maximum number of employees.
    static Optional<String> q29() {
        return null;
    }

    // Q30. Given a list of employees, create a Map where employee name
    // is the key and salary is the value. Resolve duplicate names
    // by retaining the higher salary.
    static Map<String, Double> q30() {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getName,Employee::getSalary,(old1,new1)->{
                    return old1>new1?old1:new1;

    }));
    }

    // Q31. Find employees whose salary is above the overall average
    // salary and return them sorted by salary descending.
    static List<Employee> q31() {
        return null;
    }

    // Q32. Find the sum and product of a list of integers
    // in one traversal.
    static Map<String, Integer> q32(List<Integer> values) {
    return null;

    }

    // Q33. Given a list of strings, find the longest string.
    static Optional<String> q33(List<String> values) {
        return null;
    }

    // Q34. Group employees by department and collect their names
    // into a comma-separated string.
    static Map<String, String> q34() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.joining(","))));
    }

    // Q35. Find all employee names that occur exactly once.
    static List<String> q35() {
        return null;
    }

    // Q36. Given a list of integers, find the difference between
    // the maximum and minimum values.
    static int q36(List<Integer> values) {
        return 0;
    }

    // Q37. Process numbers in parallel and print them
    // in their original encounter order.
    static void q37() {
    }

    // Q38. Given a list of employees, find the top two highest-paid
    // employees in every department.
    static Map<String, List<Employee>> q38() {

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.toList(),x->x.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).toList())));
    }

    // Q39. Calculate the average salary of all employees,
    // rounded to two decimal places.
    static double q39() {
        return 0;
    }

    // Q40. Group employees by department and calculate
    // the number of employees earning more than 70000.
    static Map<String, Long> q40() {
        return null;
    }

    // Q41. Given a list of strings, group anagrams together.
    static Map<String, List<String>> q41(List<String> values) {
        return values.stream()
                .collect(Collectors.groupingBy(x->{
                    return Arrays.stream(x.split("")).sorted().collect(Collectors.joining());
                }));

    }

    // Q42. Find the first employee belonging to IT.
    static Optional<Employee> q42() {
        return null;
    }

    // Q43. Join all employee names using comma as delimiter,
    // with [ as prefix and ] as suffix.
    static String q43() {
        return null;
    }

    // Q44. Find the sum of squares of distinct even numbers,
    // skipping the first two elements of the input list.
    static int q44(List<Integer> values) {
        return 0;
    }

    // Q45. Find the employee with the highest salary in each department
    // and return only their names.
    static Map<String, String> q45() {

        return employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),x->x.get().getName())));
    }

    // Q46. Find the most frequently occurring employee name.
    static Optional<String> q46() {
        return employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                .entrySet()
                .stream().sorted()
                .map(x -> x.getKey())
                .findFirst();
    }

    // Q47. Group employees by department and calculate
    // both the total salary and average age of each department.
    static Map<String, String> q47() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.summarizingDouble(Employee::getSalary),x->x.getSum()+" "+x.getAverage())));
    }

    // Q48. Given a list of integers, return a map containing
    // each integer and the number of times it occurs,
    // retaining only numbers that occur more than once.
    static Map<Integer, Long> q48() {


        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()>1)
                .collect(Collectors.toMap(x->x.getKey(),x->x.getValue()));
    }

    public static void main(String[] args) {

    }

}

