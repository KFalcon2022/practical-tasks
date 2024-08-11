package com.walking.lesson58_collection_lamda_param.task1;

import com.walking.lesson58_collection_lamda_param.model.Employee;

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
    }

    public static Map<String, Employee> getOldestEmployeeByName(List<Employee> employees) {
        Map<String, Employee> employeeMap = new HashMap<>();

        employees.forEach(
                e -> employeeMap.merge(e.getName(), e, (oldE, newE) -> oldE.getAge() < newE.getAge() ? newE : oldE));

        return employeeMap;
    }
}