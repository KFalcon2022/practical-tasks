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

    private static Map<String, List<Employee>> getEmployeesName(List<Employee> employees) {
        Map<String, List<Employee>> employeesMap = new HashMap<>();
        employees.forEach(employee ->
                employeesMap.computeIfAbsent(employee.getName(), _ -> new ArrayList<>())
                        .add(employee));

        return employeesMap;
    }
}