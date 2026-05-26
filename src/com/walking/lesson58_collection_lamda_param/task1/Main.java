package com.walking.lesson58_collection_lamda_param.task1;

import com.walking.lesson58_collection_lamda_param.model.Employee;

import java.util.ArrayList;
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
        Map<String, Employee> employeeMap = getOldest(getSalesEmployees());
        employeeMap.get("Michael").print();
    }

    public static Map<String, Employee> getOldest(List<Employee> employees) {
        Map<String, Employee> oldest = new HashMap<>();
        employees.forEach(employee -> oldest.compute(
                employee.getName(), (k, v) -> {
                    if (v == null) {
                        return employee;
                    } else {
                        return v.getAge() > employee.getAge() ? v : employee;
                    }
                }));

        return oldest;
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