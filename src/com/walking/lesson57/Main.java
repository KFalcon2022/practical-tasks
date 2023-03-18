package com.walking.lesson57;

import com.walking.lesson57.model.Department;
import com.walking.lesson57.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Department> departmentList = new ArrayList<>();
        init(departmentList);


        List<Employee> allEmployees = getAllEmployees(departmentList);

        Set<String> uniqueNames = getUniqueNames(departmentList);

        Map<String, Set<String>> uniqueNamesInDepartment = getUniqueNamesInDepartment(departmentList);

        LinkedList<Department> depsInNamesOrder = getDepsInNamesOrder(departmentList);

        Map<String, Optional<Employee>> oldestNameHolder = getOldestNameHolderV1(departmentList);

        Map<String, Employee> oldestNameHolderV2 = getOldestNameHolderV2(departmentList);

        Map<String, Double> freeVacancyPercent = getFreeVacancyPercent(departmentList);

        int freeVacancyCount = getFreeVacancyCount(departmentList);

        String departmentNames = getDepartmentNames(departmentList);

        Map<String, Integer> womanCount = getWomanCount(departmentList);
        Map<String, Long> womanCountV2 = getWomanCountV2(departmentList);

        Map<String, List<Employee>> employeesByName = getEmployeesByName(departmentList);
        Map<String, List<Employee>> employeesByNameV2 = getEmployeesByNameV2(departmentList);

        Map<String, List<Employee>> employeesByNameSorted = getEmployeesByNameSorted(departmentList);

        Map<String, Integer> employeesOlderThan50ByDepartment = getEmployeesOlderThan50ByDepartment(departmentList);
        Map<String, Long> employeesOlderThan50ByDepartmentV2 = getEmployeesOlderThan50ByDepartmentV2(departmentList);

        OptionalDouble averageAge = getAverageAge(departmentList);

        Map<String, Double> averageAgeByDepartment = getAverageAgeByDepartment(departmentList);
        Map<String, Double> averageAgeByDepartmentV2 = getAverageAgeByDepartmentV2(departmentList);

        Map<String, String> ratio = ratio(departmentList);

        Map<String, Boolean> stringBooleanMap = mByDepartment(departmentList);

        System.out.println();
    }

    public static void init(List<Department> departmentList) {
        Department department1 = new Department();
        department1.setVacancyAmount(900);
        department1.setName("lastDep1");

        Department department2 = new Department();
        department2.setVacancyAmount(43);
        department2.setName("dep2");

        departmentList.add(department1);
        departmentList.add(department2);

        addEmployeeToDep(department1);
        addEmployeeToDep(department2);
    }

    public static void addEmployeeToDep(Department department) {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setAge(i + 18);
            employee.setMale(true);
            employee.setName("Employee %d".formatted(i));
            employee.setPosition("Position %d".formatted(i));
            department.addEmployee(employee);
        }

        Employee employee = new Employee();
        employee.setAge(1 + 50);
        employee.setMale(false);
        employee.setName("Employee %d".formatted(1));
        employee.setPosition("Position %d".formatted(1));
        department.addEmployee(employee);
    }

    public static void addEmployeeToDepV2(Department department) {
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setAge(50);
            employee.setMale(true);
            employee.setName("Employee %d".formatted(i));
            employee.setPosition("Position %d".formatted(i));
            department.addEmployee(employee);
        }
    }

    // Задача 1. Предоставьте список всех сотрудников компании.
    public static List<Employee> getAllEmployees(List<Department> department) {
        return department
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .toList();
    }

    //Задача 2. Предоставьте полный перечень оригинальных имен сотрудников компании.
    public static Set<String> getUniqueNames(List<Department> department) {
        return department
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .map(Employee::getName)
                .collect(Collectors.toSet());
    }

    //Задача 3. Предоставьте полный перечень оригинальных имен сотрудников по каждому департаменту.
    public static Map<String, Set<String>> getUniqueNamesInDepartment(List<Department> departmentList) {
        return departmentList
                .stream()
                .collect(Collectors.groupingBy(Department::getName, Collectors.flatMapping(department -> department.getEmployees().stream().map(Employee::getName), Collectors.toSet())));
    }

    //Задача 4. Предоставьте список всех департаментов в алфавитном порядке в виде LinkedList.
    public static LinkedList<Department> getDepsInNamesOrder(List<Department> departmentList) {
        return departmentList
                .stream()
                .sorted(Comparator.comparing(Department::getName))
                .collect(LinkedList::new, List::add, List::addAll);
    }

    //Задача 5. Предоставьте самого старшего обладателя каждого из имен. Попробуйте сделать это без использования downstream.
    public static Map<String, Optional<Employee>> getOldestNameHolderV1(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getName, Collectors.maxBy(Comparator.comparing(Employee::getAge))));
    }

    //Задача 5. Предоставьте самого старшего обладателя каждого из имен. Попробуйте сделать это без использования downstream. V2
    public static Map<String, Employee> getOldestNameHolderV2(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .collect(Collectors.toMap(Employee::getName, Function.identity(), Main::getOldest));
    }

    // до метода getOldestNameHolderV2
    public static Employee getOldest(Employee employee1, Employee employee2) {
        return employee1.getAge() > employee2.getAge() ? employee1 : employee2;
    }

    //Задача 6. Предоставьте информацию о проценте открытых вакансий относительно текущего числа сотрудников по каждому департаменту.
    public static Map<String, Double> getFreeVacancyPercent(List<Department> departmentList) {

        return departmentList
                .stream()
                .collect(Collectors.toMap(Department::getName, Main::getPercent));
    }

    public static double getPercent(Department department) {
        double employees = department.getEmployees().size();
        double vacancyAmount = department.getVacancyAmount();

        if (employees > vacancyAmount || vacancyAmount == 0) {
            throw new IllegalStateException();
        }

        return (1 - employees / vacancyAmount) * 100;
    }

    //Задача 7. Предоставьте общее число открытых вакансий в компании.
    public static int getFreeVacancyCount(List<Department> departmentList) {
        return departmentList
                .stream()
                .mapToInt(dep -> dep.getVacancyAmount() - dep.getEmployees().size())
                .sum();
    }

    //Задача 8. Перечислите названия всех департаментов компании через запятую.
    public static String getDepartmentNames(List<Department> departmentList) {
        return departmentList
                .stream()
                .map(Department::getName)
                .collect(Collectors.joining(", "));
    }

    //Задача 9. Предоставьте информацию по числу женщин в каждом департаменте.
    public static Map<String, Integer> getWomanCount(List<Department> departmentList) {
        return departmentList.stream()
                .collect(Collectors.groupingBy(Department::getName, Collectors.summingInt(dep -> Math.toIntExact(dep.getEmployees().stream().filter(emp -> !emp.isMale()).count()))));
    }

    public static Map<String, Long> getWomanCountV2(List<Department> departmentList) {
        return departmentList.stream()
                .collect(Collectors.toMap(Department::getName, dep -> dep.getEmployees().stream().filter(emp -> !emp.isMale()).count(), Long::sum));
    }

    //Задача 10. Предоставьте список сотрудников по каждому имени.
    public static Map<String, List<Employee>> getEmployeesByName(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getName));
    }

    // Ивращение, но ведь работает)
    public static Map<String, List<Employee>> getEmployeesByNameV2(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .collect(Collectors.toMap(Employee::getName, Arrays::asList, (v1, v2) -> {
                    ArrayList<Employee> newList = new ArrayList<>();
                    newList.addAll(v1);
                    newList.addAll(v2);
                    return newList;
                }));
    }

    //Задача 11. Предоставьте список сотрудников по каждому имени. Имена должны быть представлены в алфавитном порядке.
    public static Map<String, List<Employee>> getEmployeesByNameSorted(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(Employee::getName, LinkedHashMap::new, Collectors.toList()));
    }

    //Задача 12. Предоставьте количество сотрудников старше 50 по каждому департаменту.
    // Da,da никаких цифр в названии методов...
    public static Map<String, Integer> getEmployeesOlderThan50ByDepartment(List<Department> departmentList) {
        return departmentList
                .stream()
                .collect(Collectors.groupingBy(Department::getName, Collectors.summingInt(dep -> Math.toIntExact(dep.getEmployees().stream().filter(emp -> emp.getAge() > 50).count()))));
    }

    public static Map<String, Long> getEmployeesOlderThan50ByDepartmentV2(List<Department> departmentList) {
        return departmentList
                .stream()
                .collect(Collectors.toMap(Department::getName, dep -> dep.getEmployees().stream().filter(emp -> emp.getAge() > 50).count(), Long::sum));
    }

    //Задача 13. Предоставьте информацию о среднем возрасте сотрудников компании.
    public static OptionalDouble getAverageAge(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .mapToInt(Employee::getAge)
                .average();
    }

    //Задача 14. Предоставьте информацию о среднем возрасте сотрудников по каждому департаменту.
    public static Map<String, Double> getAverageAgeByDepartment(List<Department> departmentList) {
        return departmentList
                .stream()
                .collect(Collectors.groupingBy(Department::getName, Collectors.averagingDouble(dep -> dep.getEmployees().stream().mapToDouble(Employee::getAge).average().orElse(0))));
    }

    public static Map<String, Double> getAverageAgeByDepartmentV2(List<Department> departmentList) {
        return departmentList.stream()
                .collect(Collectors.toMap(Department::getName, dep -> dep.getEmployees().stream().mapToDouble(Employee::getAge).average().orElse(0)));
    }

    //Задача 15. Предоставьте соотношение женщин и мужчин по каждому департаменту.
    public static Map<String, String> ratio(List<Department> departmentList) {
        return departmentList.stream()
                .collect(Collectors.toMap(Department::getName, Main::ratio));
    }

    public static String ratio(Department department) {
//        long count = department.getEmployees().stream().filter(Employee::isMale).count();
//        return "%d/%d".formatted(department.getEmployees().size() - count, count);

        Map<Boolean, List<Employee>> collect = department.getEmployees().stream().collect(Collectors.partitioningBy(Employee::isMale));
        return "%d/%d".formatted(collect.get(false).size(), collect.get(true).size());
    }

    //Задача 16. По каждой должности (position) предоставьте список сотрудников, ее занимающих (допустимо ограничиться обозначением сотрудника по имени).
    public static Map<String, List<Employee>> getEmployeeByPosition(List<Department> departmentList) {
        return departmentList.stream().flatMap(dep -> dep.getEmployees().stream()).collect(Collectors.groupingBy(Employee::getPosition));
    }

    //Задача 17. Предоставьте информацию по максимальному возрасту сотрудников в каждом из департаментов.
    public static Map<String, OptionalInt> getMaxAgeByDepartment(List<Department> departmentList) {
        return departmentList.stream().collect(Collectors.toMap(Department::getName, dep -> dep.getEmployees().stream().mapToInt(Employee::getAge).max()));
    }

    //Задача 18. Предоставьте список сотрудников женского пола и сотрудников мужского пола в компании.
    public Map<Boolean, List<Employee>> getEmployeesByGender(List<Department> departmentList) {
        return departmentList.stream().flatMap(dep -> dep.getEmployees().stream()).collect(Collectors.partitioningBy(Employee::isMale));
    }

    //Задача 19. Предоставьте список сотрудников женского пола и сотрудников мужского пола и по каждому департаменту.
    public Map<String, Map<Boolean, List<Employee>>> getEmployeesByGenderByDepartment(List<Department> departmentList) {
        return departmentList.stream().collect(Collectors.toMap(Department::getName, dep -> dep.getEmployees().stream().collect(Collectors.partitioningBy(Employee::isMale))));
    }

    //Задача 20. Предоставьте информацию по разнице в возрасте между самым молодым и самым старым сотрудником по каждому департаменту.
    public static Map<String, Integer> getAgeRange(List<Department> departmentList) {
        return departmentList.stream().collect(Collectors.toMap(Department::getName, Main::getAgeRange, (v1, v2) -> v1));
    }

    public static Integer getAgeRange(Department department) {
        IntSummaryStatistics intSummaryStatistics = department.getEmployees().stream().mapToInt(Employee::getAge).summaryStatistics();

        return intSummaryStatistics.getMax() - intSummaryStatistics.getMin();
    }

    //Задача 21. Предоставьте информацию по минимальному, максимальному и среднего возрасту сотрудников на каждой должности.
    public static Map<String, IntSummaryStatistics> getEmployeeAgeInfoByPosition(List<Department> departmentList) {
        return departmentList.stream().flatMap(dep -> dep.getEmployees().stream()).collect(Collectors.groupingBy(Employee::getPosition, Collectors.summarizingInt(Employee::getAge)));
    }

    //Задача 22. Предоставьте список всех сотрудников женского пола, если их больше 30, в противном случае – предоставьте список всех сотрудников мужского пола.
    public static List<Employee> getEmployeeConditional(List<Department> departmentList) {
        Map<Boolean, List<Employee>> employeesByGender = departmentList.stream().flatMap(dep -> dep.getEmployees().stream()).collect(Collectors.partitioningBy(Employee::isMale));
        return employeesByGender.get(false).size() > 30 ? employeesByGender.get(false) : employeesByGender.get(true);
    }

    //Задача 23. Предоставьте информацию, превышает ли численность мужчин в компании численность женщин.
    public static boolean m(List<Department> departmentList) {
        Map<Boolean, List<Employee>> employees = departmentList
                .stream()
                .flatMap(dep -> dep.getEmployees().stream())
                .collect(Collectors.partitioningBy(Employee::isMale));

        return employees.get(true).size() > employees.get(false).size();
    }

    //Задача 24. Предоставьте информацию, превышает ли численность мужчин численность женщин по каждому департаменту.
    public static Map<String, Boolean> mByDepartment(List<Department> departmentList) {
        return departmentList
                .stream()
                .collect(Collectors.toMap(Department::getName, Main::m));
    }

    public static boolean m(Department department) {
        Map<Boolean, List<Employee>> collect = department.getEmployees().stream().collect(Collectors.partitioningBy(Employee::isMale));

        return collect.get(true).size() > collect.get(false).size();
    }
}
