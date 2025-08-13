package com.walking.lesson58_collection_lamda_param.task3;

import com.walking.lesson58_collection_lamda_param.Employee;

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

    public static Map<String, Integer> getAgeSumByName(List<Employee> employees) {
        Map<String, Integer> ageSumByName = new HashMap<>();

        employees.forEach(employee -> {
            ageSumByName.compute(employee.getName(), (k, v) ->
                    v == null ? employee.getAge() : v + employee.getAge());
        });

        return ageSumByName;
    }
}