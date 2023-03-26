package com.walking.lesson57_stream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Department> departments = setupData();
        //task01(departments); // Full employees list
        //task02(departments); // List of unique names
        //task03(departments); // Unique names by department
        //LinkedList<String> depNames = task04(departments); // Linked list
        //task05(departments); // Oldest in department
        //task06(departments); // Vacancy percentage
        //long vacancies = task07(departments); // Total vacancy number
        //System.out.println(task08(departments)); // Department names
        //task09(departments); // Women
        //Map<String, List<Employee>> namedLists = task10(departments); // List of employees per name
        //namedLists.entrySet().forEach(System.out::println);
        //Map<String, List<Employee>> namedLists = task11(departments); // List of employees per name, sorted
        //namedLists.entrySet().forEach(System.out::println);
        //task12(departments); // Employees older (or equal) than 50
        //double avgAge = task13(departments); // Average age
        //System.out.println(avgAge);
        //task14(departments); // Average age per department
        //task15(departments); // Sex ratio per department
        //task16(departments); // Lists of positions
        //task17(departments); // 17 - Oldest in dep
        //task18(departments); // Lists per sex
        //task19(departments); // Lists of sex per dep
        //task20(departments); // Old'n'young
        //task21(departments); // Position stats
        //task22(departments); //
        //task23(departments); //
        task24(departments); //
    }

    // 01 - Full employees list
    public static void task01(List<Department> departments){
        departments.stream()
                .map(Department::getEmployees)
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    // 02 - List of unique names
    public static void task02(List<Department> departments){
        departments.stream()
                .map(Department::getEmployees)
                .flatMap(List::stream)
                .map(Employee::getName)
                .distinct().sorted()
                .forEach(System.out::println);
    }

    // 03 - Unique names by department
    public static void task03(List<Department> departments) {
        departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees()
                                .stream().map(Employee::getName)
                                .collect(Collectors.toSet())

                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 04 - Linked list
    public static LinkedList<String> task04(List<Department> departments) {
        return departments.stream()
                .map(Department::getName)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    // 05 - Oldest in department
    public static void task05(List<Department> departments) {
        departments.stream()
                .filter(d -> !d.getEmployees().isEmpty())
                .collect(Collectors.groupingBy(
                        Department::getName,
                        Collectors.flatMapping(
                                d -> d.getEmployees().stream(),
                                Collectors.maxBy(Comparator.comparing(Employee::getAge))
                        )
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 06 - Vacancy percentage
    public static void task06(List<Department> departments) {
        departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        // d -> 100 - Math.round(Double.valueOf(d.getEmployees().size()) / d.getVacancyAmount() * 100) // но это некрасиво, поэтому отдается на откуп самому классу
                        Department::getAvailablePercentage
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 07 - Total vacancy number
    public static long task07(List<Department> departments) {
        return departments.stream()
                .mapToLong(Department::getAvailablePositions)
                .sum();

        // или так
                //.collect(Collectors.summarizingLong(Department::getAvailablePositions))
                //.getSum();
    }

    // 08 - Department names
    public static String task08(List<Department> departments) {
        return departments.stream()
                .map(Department::getName)
                .collect(Collectors.joining(", "));
    }

    // 09 - Women
    public static void task09(List<Department> departments) {
        departments.stream()
                .collect(Collectors.groupingBy(
                        Department::getName,
                        Collectors.flatMapping(
                                d -> d.getEmployees().stream()
                                        .filter(e -> !e.getSex()),
                                Collectors.counting()
                        )
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 10 - List of employees per name
    public static Map<String, List<Employee>> task10(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        Employee::getName
                ));
    }

    // 11 - List of employees per name, sorted
    public static LinkedHashMap<String, List<Employee>> task11(List<Department> departments) {
        // наверное можно было использовать task10 и вернуть лист, но нутрянка выходит унылая
        //Map<String, List<Employee>> namesInfo = task10(departments);
        //return namesInfo.entrySet()
        //       .stream().sorted(Comparator.comparing(e -> e.getKey()))

        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }

    // 12 - Employees older (or equal) than 50
    public static void task12(List<Department> departments) {
        departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .filter(e -> e.getAge() >= 50)
                                .collect(Collectors.counting())
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 13 - Average age
    public static double task13(List<Department> departments) {
        return departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.averagingLong(Employee::getAge));
    }

    // 14 - Average age per department
    public static void task14(List<Department> departments) {
        departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .collect(Collectors.averagingLong(Employee::getAge))
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 15 - Sex ratio per department
    public static void task15(List<Department> departments) {
        departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .collect(Collectors.summarizingInt(e -> e.getSex() ? 1 : 0))
                                .getAverage()
                ))
                .entrySet()
                .forEach(
                        e -> System.out.println("%s - males=%.2f%%, females=%.2f%%".formatted(e.getKey(), e.getValue()*100, 100-e.getValue()*100))
                );
    }

    // 16 - Lists of positions
    public static void task16(List<Department> departments) {
        departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getPosition))
                .entrySet()
                .forEach(System.out::println);
    }

    // 17 - Oldest in dep
    public static void task17(List<Department> departments) {
        departments.stream()
                .filter(d -> !d.getEmployees().isEmpty())
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .mapToLong(Employee::getAge)
                                .max()
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 18 - Lists per sex
    public static void task18(List<Department> departments) {
        departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.partitioningBy(Employee::getSex))
                .entrySet()
                .forEach(System.out::println);
    }

    // 19 - Lists of sex per dep
    public static void task19(List<Department> departments) {
        departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .collect(Collectors.partitioningBy(Employee::getSex))
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 20 - Old'n'young
    public static void task20(List<Department> departments) {
        departments.stream()
                .filter(d -> !d.getEmployees().isEmpty())
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .collect(Collectors.teeing(
                                        Collectors.mapping(
                                                Employee::getAge,
                                                Collectors.maxBy(Comparator.naturalOrder())
                                        ),
                                        Collectors.mapping(
                                                Employee::getAge,
                                                Collectors.minBy(Comparator.naturalOrder())
                                        ),
                                        (M, m) -> {
                                            return (M.isPresent() ? M.get() : 0) - (m.isPresent() ? m.get() : 0);
                                        }
                                ))
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    // 21 - Position stats
    public static void task21(List<Department> departments) {
        departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.groupingBy(
                        Employee::getPosition,
                        Collectors.summarizingLong(Employee::getAge)
                ))
                .entrySet()//.stream()
                .forEach(System.out::println); // можно и отформатировать
    }

    // ничего красивого без императивщины дальше не придумывается
    public static List<Employee> task22(List<Department> departments) {
        Map<Boolean, List<Employee>> map = departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.partitioningBy(Employee::getSex));
        return map.get(false).size() > 30 ? map.get(false) : map.get(true);
    }

    public static boolean task23(List<Department> departments) {
        Map<Boolean, List<Employee>> map = departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.partitioningBy(Employee::getSex));
        return map.get(true).size() > map.get(false).size();
    }

    public static void task24(List<Department> departments) {
        departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .collect(Collectors.partitioningBy(
                                        Employee::getSex
                                ))
                ))
                .entrySet().stream()
                .map(e -> {
                    return Arrays.asList(e.getKey(), e.getValue().get(true).size() > e.getValue().get(false).size());
                })
                .forEach(System.out::println);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static List<Department> setupData() {
        return Arrays.asList(
                new Department("Department 1", 10, Arrays.asList(
                        new Employee("Abel", true, "engineer", 30),
                        new Employee("Boris", true, "lead", 60),
                        new Employee("Gregory", true, "manager", 18)
                )),
                new Department("Department 2", 8, Arrays.asList(
                        new Employee("Claire", false, "artist", 20),
                        new Employee("Dora", false, "lead", 22),
                        new Employee("Eva", false, "artist", 24),
                        new Employee("Faina", false, "manager", 50)
                )),
                new Department("Doubles", 3, Arrays.asList(
                        new Employee("Abel", true, "unknown position", 33),
                        new Employee("Eva", false, "unknown position", 44),
                        new Employee("Eva", false, "unknown position", 22)
                )),
                new Department("Empty", 3, Arrays.asList(
                ))
        );
    }
}
