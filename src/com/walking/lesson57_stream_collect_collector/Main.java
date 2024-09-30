package com.walking.lesson57_stream_collect_collector;

import java.util.ArrayList;
import java.util.List;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;
import com.walking.lesson57_stream_collect_collector.task.*;

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
        List<Department> departments=initData();
        var result1=new Task1().calculate(departments);
        var result2=new Task2().calculate(departments);
        var result3=new Task3().calculate(departments);
        var result4=new Task4().calculate(departments);
        var result5=new Task5().calculate(departments);
        var result6=new Task6().calculate(departments);
        var result7=new Task7().calculate(departments);
        var result8=new Task8().calculate(departments);
        var result9=new Task9().calculate(departments);
        var result10=new Task10().calculate(departments);
        var result11=new Task11().calculate(departments);
        var result12=new Task12().calculate(departments);
        var result13=new Task13().calculate(departments);
        var result14=new Task14().calculate(departments);
        var result15=new Task15().calculate(departments);
        var result16=new Task16().calculate(departments);
        var result17=new Task17().calculate(departments);
        var result18=new Task18().calculate(departments);
        var result19=new Task19().calculate(departments);
        var result20=new Task20().calculate(departments);
        var result21=new Task21().calculate(departments);
        var result22=new Task22().calculate(departments);
        var result23=new Task23().calculate(departments);
        var result24=new Task24().calculate(departments);

        int i=1;
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