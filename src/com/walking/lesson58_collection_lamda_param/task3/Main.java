package com.walking.lesson58_collection_lamda_param.task3;

import com.walking.lesson57_stream_collect_collector.model.Department;

import com.walking.lesson57_stream_collect_collector.model.*;

import java.util.*;

import static com.walking.lesson57_stream_collect_collector.Main.*;

/**
 * Используя классы из практики к уроку 57, реализуйте метод,
 * принимающий на вход список сотрудников и возвращающий суммарный возраст обладателей каждого имени.
 * Не используйте Map.merge()
 */
public class Main {
    public static void main(String[] args) {
        Department accountingDP = new Department("Accounting",14,createEmployeesAccounting());
        Department salesDP = new Department("Sales",20,createEmployeesSales());
        Department managersDP = new Department("Administration",6, createEmployeesAdministration());
        List<Department> departments = new ArrayList<>(List.of(accountingDP,salesDP,managersDP));

        System.out.println(getEmployeeSumAgeByName(departments));
    }
    private static Map<String,Integer> getEmployeeSumAgeByName(List<Department> departments){
        Map<String, Integer> sumAgeMap = new HashMap<>();

        departments.forEach(d->{
            for (Employee e : d.getEmployees()){
                sumAgeMap.compute(
                        e.getName(),
                        (k,v)-> v==null ? e.getAge() : v+e.getAge());
            }
        });

        return sumAgeMap;
    }
}