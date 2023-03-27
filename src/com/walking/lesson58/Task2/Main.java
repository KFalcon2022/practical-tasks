package com.walking.lesson58.Task2;

import com.walking.lesson57_stream.Department;
import com.walking.lesson57_stream.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args){
        List<Employee> employees = getEmployees(setupData());
        HashMap<String, List<Employee>> elders = getElders(employees);
        System.out.println(elders);
    }

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

    public static List<Employee> getEmployees(List<Department> departments){
        return departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .collect(Collectors.toList());
    }

    public static HashMap<String, List<Employee>> getElders(List<Employee> employees) {
        var temp = new HashMap<String, List<Employee>>();

        employees.forEach(e -> {
            temp.computeIfAbsent(e.getName(), k -> new ArrayList<Employee>()).add(e);
        });

        return temp;
    }
}
