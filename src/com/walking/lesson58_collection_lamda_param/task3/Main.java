package com.walking.lesson58_collection_lamda_param.task3;

import com.walking.lesson58_collection_lamda_param.model.Employee;

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
        var employees = getEmployeesAgeSum(getSalesEmployees());
        System.out.println(employees);
    }

    public static Map<String, Integer> getEmployeesAgeSum(List<Employee> employees) {
        Map<String, Integer> map = new HashMap<>();
        employees.forEach(e -> map.compute(e.getName(),
                (k, v) -> {
            if (v == null) {
                return e.getAge();
            } else {
                return v + e.getAge();
            }
        }));

        return map;
    }

    public static List<Employee> getSalesEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", true, "manager", 21));
        employees.add(new Employee("Alex", true, "director", 54));
        employees.add(new Employee("Helen", false, "assistant", 24));
        employees.add(new Employee("Jane", false, "commercial director", 42));
        employees.add(new Employee("Michael", true, "manager", 33));
        employees.add(new Employee("Michael", true, "inside sales representative", 55));
        employees.add(new Employee("Michael", true, "manager", 43));
        employees.add(new Employee("Anna", false, "inside sales representative", 39));
        employees.add(new Employee("Steeve", true, "account executive", 39));
        employees.add(new Employee("Steeve", true, "manager", 28));
        return employees;
    }
}