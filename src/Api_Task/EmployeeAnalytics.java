import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class EmployeeAnalytics {
    record Employee(int id, String name, String dept, BigDecimal salary,
                    LocalDate hireDate, Set<String> skills) {}

    static Employee e(int id, String n, String d, int sal, String date, String... skills) {
        return new Employee(id, n, d, BigDecimal.valueOf(sal),
                LocalDate.parse(date), Set.of(skills));
    }

    public static void main(String[] args) {
        List<Employee> emps = List.of(
                e(1, "Asha",   "Engineering",  90000, "2019-03-01", "Java", "SQL"),
                e(2, "Ravi",   "Engineering", 120000, "2016-07-15", "Java", "Spring", "AWS"),
                e(3, "Meera",  "HR",           60000, "2020-01-10", "Recruiting"),
                e(4, "John",   "Sales",        70000, "2018-11-20", "Negotiation", "CRM"),
                e(5, "Priya",  "Engineering", 105000, "2021-05-05", "Java", "React"),
                e(6, "Karan",  "Sales",        65000, "2022-02-14", "CRM"),
                e(7, "Sara",   "HR",           62000, "2017-09-09", "Recruiting", "Payroll"),
                e(8, "Vikram", "Finance",      80000, "2015-04-30", "Excel", "SQL"));

        System.out.println("=== Level 1: Basics ===");

        // Q1: Names of Engineering employees, sorted by salary descending
        List<String> q1 = emps.stream()
                .filter(emp -> emp.dept().equals("Engineering"))
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .map(Employee::name) // Naya concept: Sirf naam extract karo
                .toList();
        System.out.println("Q1: " + q1);

        // Q2: Names of the top 3 earners overall
        List<String> q2 = emps.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .limit(3) // Naya concept: Sirf shuru ke 3 uthao
                .map(Employee::name)
                .toList();
        System.out.println("Q2: " + q2);

        // Q3: Employees hired before 2018-01-01, oldest hire first, format "name (year)"
        List<String> q3 = emps.stream()
                .filter(emp -> emp.hireDate().isBefore(LocalDate.of(2018, 1, 1)))
                .sorted(Comparator.comparing(Employee::hireDate))
                .map(emp -> emp.name() + " (" + emp.hireDate().getYear() + ")")
                .toList();
        System.out.println("Q3: " + q3);

        // Q4: All names joined as comma-separated string
        String q4 = emps.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        System.out.println("Q4: " + q4);


        System.out.println("\n=== Level 2: Reduction and matching ===");

        // Q5: Total payroll using reduce
        BigDecimal q5 = emps.stream()
                .map(Employee::salary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Q5: " + q5);

        // Q6: anyMatch, allMatch, noneMatch
        boolean hasAWS = emps.stream().anyMatch(emp -> emp.skills().contains("AWS"));
        boolean allAbove50k = emps.stream().allMatch(emp -> emp.salary().compareTo(BigDecimal.valueOf(50000)) > 0);
        boolean noneAbove150k = emps.stream().noneMatch(emp -> emp.salary().compareTo(BigDecimal.valueOf(150000)) > 0);
        System.out.println("Q6: AWS=" + hasAWS + ", All>50k=" + allAbove50k + ", None>150k=" + noneAbove150k);

        // Q7: Highest-paid employee using Optional
        String q7 = emps.stream()
                .max(Comparator.comparing(Employee::salary))
                .map(Employee::name)
                .orElse("none");
        System.out.println("Q7: " + q7);


        System.out.println("\n=== Level 3: Grouping and collecting ===");

        // Q8: Average salary per department
        Map<String, Double> q8 = emps.stream()
                .collect(Collectors.groupingBy(Employee::dept,
                        Collectors.averagingDouble(emp -> emp.salary().doubleValue())));
        System.out.println("Q8: " + q8);

        // Q9: Highest-paid employee name per department
        Map<String, String> q9 = emps.stream()
                .collect(Collectors.groupingBy(Employee::dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                opt -> opt.map(Employee::name).orElse("")
                        )));
        System.out.println("Q9: " + q9);

        // Q10: Partition by salary >= 75000
        Map<Boolean, List<String>> q10 = emps.stream()
                .collect(Collectors.partitioningBy(
                        emp -> emp.salary().compareTo(BigDecimal.valueOf(75000)) >= 0,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));
        System.out.println("Q10: " + q10);


        System.out.println("\n=== Level 4: Nested data ===");

        // Q11: Sorted list of distinct skills
        List<String> q11 = emps.stream()
                .flatMap(emp -> emp.skills().stream()) // Naya concept: Har employee ki skills nikalkar ek badi stream banao
                .distinct() // Duplicate hatao
                .sorted()
                .toList();
        System.out.println("Q11: " + q11);

        // Q12: Skill frequency map and most common skill
        Map<String, Long> skillFreq = emps.stream()
                .flatMap(emp -> emp.skills().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String mostCommonSkill = skillFreq.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("none");

        System.out.println("Q12 Map: " + skillFreq);
        System.out.println("Q12 Most Common: " + mostCommonSkill);
    }
}