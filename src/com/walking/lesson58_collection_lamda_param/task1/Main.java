package com.walking.lesson58_collection_lamda_param.task1;

import com.walking.lesson58_collection_lamda_param.model.Department;
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

    private static Map<String, Employee> getOldestEmployees(List<Department> departments) {
        Map<String, Employee> oldestEmployees = new HashMap<>();
        departments.forEach(department ->
                department.getEmployees()
                        .forEach(employee ->
                                oldestEmployees.merge(
                                        employee.getName(),
                                        employee,
                                        (oldEmpl, newEmpl) ->
                                                oldEmpl.getAge() > newEmpl.getAge() ? oldEmpl : newEmpl)));

        return oldestEmployees;
    }
}