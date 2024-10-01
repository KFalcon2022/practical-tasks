package com.walking.lesson58_collection_lamda_param.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.walking.lesson58_collection_lamda_param.model.Department;
import com.walking.lesson58_collection_lamda_param.model.Employee;

/**
 * Используя классы из практики к уроку 57,
 * реализуйте метод, принимающий на вход список сотрудников и возвращающий
 * самого старшего обладателя каждого имени.
 */
public class Main {
    public static void main(String[] args) {
        List<Department> departments=initData();
        var result=calc(departments.stream().flatMap(d->d.getEmployees().stream()).toList());
        result.forEach((k,v)-> System.out.println(k+"-"+v.getAge()));
    }

    public static Map<String, Employee> calc(List<Employee> employees){
        HashMap<String, Employee> oldMans=new HashMap<>();
        employees.forEach(e->oldMans.compute(e.getName(), 
        (k,v)->(v==null)?e:(v.getAge()>e.getAge())?v:e
        ));
        return oldMans;
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