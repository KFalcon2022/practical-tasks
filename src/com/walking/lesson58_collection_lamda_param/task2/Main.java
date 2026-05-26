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
        var employees = getEmployeesNamesMap(getSalesEmployees());
        System.out.println(employees);
    }

    public static Map<String, List<Employee>> getEmployeesNamesMap(List<Employee> employees) {
        Map<String, List<Employee>> mapEmployees = new HashMap<>();
        employees.forEach(e -> mapEmployees.computeIfAbsent(
                        e.getName(), k -> new ArrayList<>())
                .add(e));

        return mapEmployees;
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