package com.walking.lesson58_collection_lamda_param.task2;

import com.walking.lesson58_collection_lamda_param.model.Employee;

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
    }

    public static Map<String, List<Employee>> getAllEmployeesByName(List<Employee> employees) {
        Map<String, List<Employee>> employeeMap = new HashMap<>();

        employees.forEach(e -> employeeMap.computeIfAbsent(e.getName(), k -> new ArrayList<>())
                                          .add(e));

        return employeeMap;
    }
}