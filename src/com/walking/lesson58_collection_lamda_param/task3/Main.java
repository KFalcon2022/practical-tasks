package com.walking.lesson58_collection_lamda_param.task3;

import com.walking.lesson58_collection_lamda_param.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Используя классы из практики к уроку 57, реализуйте метод,
 * принимающий на вход список сотрудников и возвращающий суммарный возраст обладателей каждого имени.
 * Не используйте Map.merge()
 */
public class Main {
    public static void main(String[] args) {
    }

    public static Map<String, Integer> getSumAgeEmployeesByName(List<Employee> employees) {
        Map<String, Integer> employeeMap = new HashMap<>();

        employees.forEach(e -> employeeMap.compute(e.getName(), (k, v) -> v == null ? e.getAge() : v + e.getAge()));

        return employeeMap;
    }
}