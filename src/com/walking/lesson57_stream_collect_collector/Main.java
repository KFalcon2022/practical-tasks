package com.walking.lesson57_stream_collect_collector;


import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;
import com.walking.lesson57_stream_collect_collector.task.*;

import java.util.*;

/**
 * Необходимо реализовать набор функций для HRM-системы компании,
 * каждая из которых сводится к формированию определенной статистики на базе информации
 * о всех департаментах компании и сотрудниках в них.
 * Реализация каждой задачи должна представлять собой отдельный метод (или класс),
 * единственным параметром которого является список всех департаментов в компании,
 * а возвращаемым значением – произвольный объект (чаще всего – какая-то коллекция),
 * хранящий информацию, которую требуется получить по условию задачи.
 */
public class Main {
    public static void main(String[] args) {
//        Task6 task = new Task6();
//        Map<String, Double> employees = task.calculate(getDepartments());
//        System.out.println(employees);

        Task20 task = new Task20();
        System.out.println(task.calculate(getDepartments()));
    }

    public static List<Department> getDepartments() {
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department("Sales", 4, getSalesEmployees()));
        departments.add(new Department("Finance", 2, getFinanceEmployees()));
        departments.add(new Department("IT", 1, getITEmployees()));
        return departments;
    }

    public static List<Employee> getSalesEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", true, "manager", 21));
        employees.add(new Employee("Helen", false, "assistant", 24));
        employees.add(new Employee("Jane", false, "commercial director", 42));
        employees.add(new Employee("Michael", true, "manager", 33));
        employees.add(new Employee("Anna", false, "inside sales representative", 39));
        employees.add(new Employee("Steeve", true, "account executive", 39));
        return employees;
    }

    public static List<Employee> getFinanceEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Steeve", true, "clerc", 25));
        employees.add(new Employee("Inna", false, "financial analyst", 29));
        employees.add(new Employee("Bob", true, "financial analyst", 33));
        employees.add(new Employee("David", true, "finance manager", 44));
        employees.add(new Employee("Benedict", true, "finance director", 57));
        employees.add(new Employee("Ariana", false, "treasurer", 32));
        employees.add(new Employee("Jane", false, "accountant", 40));
        return employees;
    }

    public static List<Employee> getITEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("David", true, "web developer", 47));
        employees.add(new Employee("Helen", false, "support specialist", 30));
        employees.add(new Employee("Lisa", false, "tester", 29));
        employees.add(new Employee("Helen", false, "web developer", 34));
        employees.add(new Employee("Michael", true, "database administrator", 33));
        employees.add(new Employee("Anna", false, "date analyst", 39));
        employees.add(new Employee("Bob", true, "cybersecurity analyst", 50));
        employees.add(new Employee("John", true, "software developer", 53));
        return employees;
    }
}