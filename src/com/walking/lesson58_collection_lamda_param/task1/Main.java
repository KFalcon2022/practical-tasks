package com.walking.lesson58_collection_lamda_param.task1;

import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Используя классы из практики к уроку 57,
 * реализуйте метод, принимающий на вход список сотрудников и возвращающий
 * самого старшего обладателя каждого имени.
 */
public class Main {
    public static void main(String[] args) {
        var employees = List.of(new Employee()); // some init

        System.out.println(getOlderEmployeeByName(employees));
    }

    private static Map<String, Employee> getOlderEmployeeByName(List<Employee> employees) {
        var olderByName = new HashMap<String, Employee>();

        for (Employee e : employees) {
            olderByName.compute(e.getName(), (k, v) -> v == null || e.getAge() > v.getAge() ? e : v);
        }

        return olderByName;
    }
}