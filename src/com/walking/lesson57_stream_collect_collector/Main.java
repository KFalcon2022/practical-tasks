package com.walking.lesson57_stream_collect_collector;

import com.walking.lesson41_set.task1.model.Task;
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
        Department department1 = createDepartment1();
        Department department2 = createDepartment2();
        Department department3 = createDepartment3();

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);

        Task24 task24 = new Task24();
        System.out.println(task24.calculate(departmentList));
    }

    public static Department createDepartment1() {
        Employee employee1 = new Employee("Dmitriy", true, "chief", 45);
        Employee employee2 = new Employee("Olga", false, "secretary", 36);
        Employee employee3 = new Employee("Andrey", true, "deputy chief", 29);
        Employee employee4 = new Employee("Ruslan", true, "engineer", 25);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

        Department department = new Department("Department1", 2, employeeList);

        return department;
    }

    public static Department createDepartment2() {
        Employee employee1 = new Employee("Aleksey", true, "chief", 38);
        Employee employee2 = new Employee("Elena", false, "deputy chief", 57);
        Employee employee3 = new Employee("Dmitriy", true, "engineer", 29);
        Employee employee4 = new Employee("Olga", false, "engineer", 31);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

        Department department = new Department("Department2", 1, employeeList);

        return department;
    }

    public static Department createDepartment3() {
        Employee employee1 = new Employee("Elena", false, "chief", 55);
        Employee employee2 = new Employee("Irina", false, "engineer", 22);
        Employee employee3 = new Employee("Andrey", true, "engineer", 31);
        Employee employee4 = new Employee("Sergey", true, "engineer", 25);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

        Department department = new Department("Department3", 5, employeeList);

        return department;
    }
}