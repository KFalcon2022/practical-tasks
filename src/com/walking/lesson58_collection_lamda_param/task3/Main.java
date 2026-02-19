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

    private static Map<String, Integer> getSumAges(List<Employee> employees) {
        Map<String, Integer> sumAges = new HashMap<>();
        employees.forEach(employee ->
                sumAges.compute(employee.getName(), (k,v) ->
                        v == null ? employee.getAge() : v + employee.getAge()));

        return sumAges;
    }
}