package com.walking.lesson58_collection_lamda_param.task2;

import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Используя классы из практики к уроку 57, реализуйте метод,
 * принимающий на вход список сотрудников и возвращающий список обладателей каждого имени.
 */
public class Main {
    public static void main(String[] args) {
        var employees = List.of(new Employee()); // some init

        System.out.println(getEmployeesByName(employees));
    }

    private static Map<String, List<Employee>> getEmployeesByName(List<Employee> employees) {
        var employeesByName = new HashMap<String, List<Employee>>();

        for (Employee e : employees) {
            employeesByName.computeIfAbsent(e.getName(), k -> new ArrayList<>())
                    .add(e);
        }

        return employeesByName;
    }
}