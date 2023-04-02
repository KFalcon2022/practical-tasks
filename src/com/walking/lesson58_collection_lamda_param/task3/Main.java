package com.walking.lesson58_collection_lamda_param.task3;

import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.ArrayList;
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
        var employees = List.of(new Employee()); // some init

        System.out.println(getEmployeeAgeSumByName(employees));
    }

    private static Map<String, Integer> getEmployeeAgeSumByName(List<Employee> employees) {
        var employeeAgeSumByName = new HashMap<String, Integer>();

        for (Employee e : employees) {
            employeeAgeSumByName.compute(e.getName(), (k, v) -> v == null ? e.getAge() : v + e.getAge());
        }

        return employeeAgeSumByName;
    }
}