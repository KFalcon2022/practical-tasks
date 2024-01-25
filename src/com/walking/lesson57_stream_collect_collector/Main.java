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
        Department accountingDP = new Department("Accounting",14,createEmployeesAccounting());
        Department salesDP = new Department("Sales",20,createEmployeesSales());
        Department managersDP = new Department("Administration",6, createEmployeesAdministration());
        List<Department> departments = new ArrayList<>();
        Collections.addAll(departments,accountingDP,salesDP,managersDP);

        Task1 task1 = new Task1();
        task1.calculate(departments).forEach(System.out::println);
        System.out.println("--------------");
        Task2 task2 = new Task2();
        task2.calculate(departments).forEach(System.out::println);
        System.out.println("--------------");
        Task3 task3 = new Task3();
        System.out.println(task3.calculate(departments));
        System.out.println("--------------");
        Task4 task4 = new Task4();
        System.out.println(task4.calculate(departments));
        System.out.println("--------------");
        Task5 task5 = new Task5();
        System.out.println(task5.calculate(departments));
        System.out.println("--------------");
        Task6 task6 = new Task6();
        System.out.println(task6.calculate(departments));
        System.out.println("--------------");
        Task7 task7 = new Task7();
        System.out.println("Open vacancies: "+task7.calculate(departments));
        System.out.println("--------------");
        Task8 task8 = new Task8();
        System.out.println("Departments names: "+task8.calculate(departments));
        System.out.println("--------------");
        Task9 task9 = new Task9();
        System.out.println("Amount of women: "+task9.calculate(departments));
        System.out.println("--------------");
        Task10 task10 = new Task10();
        System.out.println(task10.calculate(departments));
        System.out.println("--------------");
        Task11 task11 = new Task11();
        System.out.println(task11.calculate(departments));
        System.out.println("--------------");
        Task12 task12 = new Task12();
        System.out.println(task12.calculate(departments));
        System.out.println("--------------");
        Task13 task13 = new Task13();
        System.out.println("Average employees' age: "+task13.calculate(departments));
        System.out.println("--------------");
        Task14 task14 = new Task14();
        System.out.println(task14.calculate(departments));
        System.out.println("--------------");
        Task15 task15 = new Task15();
        System.out.println(task15.calculate(departments));
        System.out.println("--------------");
        Task16 task16 = new Task16();
        System.out.println(task16.calculate(departments));
        System.out.println("--------------");
        Task17 task17 = new Task17();
        System.out.println(task17.calculate(departments));
        System.out.println("--------------");
        Task18 task18 = new Task18();
        System.out.println(task18.calculate(departments));
        System.out.println("--------------");
        Task19 task19 = new Task19();
        System.out.println(task19.calculate(departments));
        System.out.println("--------------");
        Task20 task20 = new Task20();
        System.out.println(task20.calculate(departments));
        System.out.println("--------------");
        Task21 task21 = new Task21();
        System.out.println(task21.calculate(departments));
        System.out.println("--------------");
        Task22 task22 = new Task22();
        System.out.println(task22.calculate(departments));
        System.out.println("--------------");
        Task23 task23 = new Task23();
        System.out.println("Male number > female number = "+task23.calculate(departments));
        System.out.println("--------------");
        Task24 task24 = new Task24();
        System.out.println(task24.calculate(departments));

    }
    private static List<Employee> createEmployeesAccounting(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Kevin", true, "Counter", 45));
        list.add(new Employee("Martin", true, "Counter", 33));
        list.add(new Employee("Idris", false, "High counter", 60));
        list.add(new Employee("Mooze", false, "Head of department", 53));
        list.add(new Employee("Mike", true, "Intern", 24));
        list.add(new Employee("Rob", true, "Intern", 24));
        return list;
    }
    private static List<Employee> createEmployeesSales(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Kevin", true, "Salesman", 34));
        list.add(new Employee("Goose", false, "Salesman", 41));
        list.add(new Employee("Mike", true, "Senior salesman", 50));
        list.add(new Employee("Alexa", false, "Head of department", 66));
        list.add(new Employee("Creed", true, "Intern", 18));
        list.add(new Employee("Creed", true, "Intern", 29));
        list.add(new Employee("Polly", false, "Salesman", 27));
        return list;
    }
    private static List<Employee> createEmployeesAdministration(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Steve", true, "General manager", 48));
        list.add(new Employee("Alexander", true, "Serviceman", 65));
        list.add(new Employee("Mike", true, "Postman", 25));
        list.add(new Employee("Tronty", false, "Secretary", 30));
        return list;
    }
}