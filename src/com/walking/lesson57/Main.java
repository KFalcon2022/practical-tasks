package com.walking.lesson57;

import com.walking.lesson57.model.Department;
import com.walking.lesson57.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
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

        Map<String, List<Employee>> employeesByName = getEmployeesByName(departmentList);
        Map<String, List<Employee>> employeesByNameV2 = getEmployeesByNameV2(departmentList);

        Map<String, List<Employee>> employeesByNameSorted = getEmployeesByNameSorted(departmentList);

        Map<String, Integer> employeesOlderThan50ByDepartment = getEmployeesOlderThan50ByDepartment(departmentList);

        OptionalDouble averageAge = getAverageAge(departmentList);

        System.out.println();
    }

    public static void init(List<Department> departmentList){
        Department department1 = new Department();
        department1.setVacancyAmount(50);
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
        for (int i=0; i<10; i++) {
            Employee employee = new Employee();
            employee.setAge(i+18);
            employee.setMale(true);
            employee.setName("Employee %d".formatted(i));
            employee.setPosition("Position %d".formatted(i));
            department.addEmployee(employee);
        }

        Employee employee = new Employee();
        employee.setAge(1+50);
        employee.setMale(false);
        employee.setName("Employee %d".formatted(1));
        employee.setPosition("Position %d".formatted(1));
        department.addEmployee(employee);
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
                .flatMap(dep-> dep.getEmployees().stream())
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
                .flatMap(dep-> dep.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getName, Collectors.maxBy(Comparator.comparing(Employee::getAge))));
    }
    //Задача 5. Предоставьте самого старшего обладателя каждого из имен. Попробуйте сделать это без использования downstream. V2
    public static Map<String, Employee> getOldestNameHolderV2(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep-> dep.getEmployees().stream())
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

    //Задача 10. Предоставьте список сотрудников по каждому имени.
    public static Map<String, List<Employee>> getEmployeesByName(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep-> dep.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getName));
    }
    // звращение, но ведь работает)
    public static Map<String, List<Employee>> getEmployeesByNameV2(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep-> dep.getEmployees().stream())
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
                .flatMap(dep-> dep.getEmployees().stream())
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(Employee::getName, LinkedHashMap::new, Collectors.toList()));
    }

    //Задача 12. Предоставьте количество сотрудников старше 50 по каждому департаменту.
    // Da,da никаких цифр в названии методов...
    public static Map<String, Integer> getEmployeesOlderThan50ByDepartment(List<Department> departmentList) {
       return departmentList
               .stream()
               .collect(Collectors.groupingBy(Department::getName, Collectors.summingInt(dep-> Math.toIntExact(dep.getEmployees().stream().filter(emp -> emp.getAge() > 50).count()))));
    }

    //Задача 13. Предоставьте информацию о среднем возрасте сотрудников компании.
    public static OptionalDouble getAverageAge(List<Department> departmentList) {
        return departmentList
                .stream()
                .flatMap(dep->dep.getEmployees().stream())
                .mapToInt(Employee::getAge)
                .average();
    }
}