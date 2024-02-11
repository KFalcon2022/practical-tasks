package com.walking.lesson58_collection_lamda_param.task1;

import com.walking.lesson57_stream_collect_collector.model.*;

import java.util.*;

import static com.walking.lesson57_stream_collect_collector.Main.*;

/**
 * Используя классы из практики к уроку 57,
 * реализуйте метод, принимающий на вход список сотрудников и возвращающий
 * самого старшего обладателя каждого имени.
 */
public class Main {
    public static void main(String[] args) {
        Department accountingDP = new Department("Accounting",14,createEmployeesAccounting());
        Department salesDP = new Department("Sales",20,createEmployeesSales());
        Department managersDP = new Department("Administration",6, createEmployeesAdministration());
        List<Department> departments = new ArrayList<>(List.of(accountingDP,salesDP,managersDP));

        System.out.println(getOldestEmployeeByName(departments));
    }
    // Оставил входным параметром департаменты для приемственности написанной проверки из урока 57
    private static Map<String, Employee> getOldestEmployeeByName(List<Department> departments){
        Map<String,Employee> oldestEmployeeByName = new HashMap<>();

        departments.forEach(d->{
            for (Employee e : d.getEmployees()){
                oldestEmployeeByName.merge(e.getName(),e,(e1,e2)->e1.getAge()>e2.getAge() ? e1 : e2);
            }
        });
        return oldestEmployeeByName;
    }
}