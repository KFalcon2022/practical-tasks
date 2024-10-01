package com.walking.lesson58_collection_lamda_param.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.walking.lesson58_collection_lamda_param.model.Department;
import com.walking.lesson58_collection_lamda_param.model.Employee;

/**
 * Используя классы из практики к уроку 57, реализуйте метод,
 * принимающий на вход список сотрудников и возвращающий список обладателей каждого имени.
 */
public class Main {
    public static void main(String[] args) {
            List<Department> departments=initData();
        var result=calc(departments.stream().flatMap(d->d.getEmployees().stream()).toList());
    }

    public static Map<String, List<Employee>> calc(List<Employee> employees){
        HashMap<String, List<Employee>> listByName=new HashMap<>();
        employees.forEach(e->listByName.computeIfAbsent(e.getName(), 
        k->new ArrayList<>()).add(e));
        return listByName;
    }

        public static List<Department> initData(){
        List<Department> departments=new ArrayList<>(3);
        departments.add(new Department("Продажи", 3, List.of(
            new Employee("Иван", true, "Продавец", 20),
            new Employee("Пётр", true, "Продавец", 60),
            new Employee("Светлана", false, "Старший продавец", 29),
            new Employee("Галина", false, "Продавец", 55),
            new Employee("Светлана", false, "Продавец", 23)
        )));
        departments.add(new Department("Разработка", 24, List.of(
            new Employee("Василий", true, "Инженер-проектировщик", 35),
            new Employee("Пётр", true, "Тестировщик", 52),
            new Employee("Григорий", true, "Инженер-технолог", 39),
            new Employee("Виктория", false, "Начальник отдела", 48)
        )));
        departments.add(new Department("Управление", 1, List.of(
            new Employee("Григорий", true, "Директор", 18),
            new Employee("Александр", true, "Заместитель директора", 73)
        )));
        return departments;
    }
}