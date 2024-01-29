package com.walking.lesson58_collection_lamda_param.task2;

import com.walking.lesson57_stream_collect_collector.model.*;

import java.util.*;

import static com.walking.lesson57_stream_collect_collector.Main.*;

/**
 * Используя классы из практики к уроку 57, реализуйте метод,
 * принимающий на вход список сотрудников и возвращающий список обладателей каждого имени.
 */
public class Main {
    public static void main(String[] args) {
        Department accountingDP = new Department("Accounting",14,createEmployeesAccounting());
        Department salesDP = new Department("Sales",20,createEmployeesSales());
        Department managersDP = new Department("Administration",6, createEmployeesAdministration());
        List<Department> departments = new ArrayList<>(List.of(accountingDP,salesDP,managersDP));

        System.out.println(getEmployeeListByName(departments));
    }
    private static Map<String,List<Employee>> getEmployeeListByName(List<Department> departments){
        Map<String,List<Employee>> employeeMapByName = new HashMap<>();

//        departments.forEach(d->{
//            for (Employee e : d.getEmployees()){
//                employeeMapByName.compute(
//                        e.getName(),(k,v)-> {
//                            if (v==null){
//                                var returnList = new ArrayList<Employee>();
//                                returnList.add(e);
//                                return returnList;
//                            }
//                            v.add(e);
//                            return v;
//                        });
//            }
//        });

        // alternative
        departments.forEach(d->{
            for (Employee e : d.getEmployees()){
                employeeMapByName.computeIfAbsent(
                        e.getName(),
                        k-> new ArrayList<>())
                        .add(e);
            }
        });

        return employeeMapByName;
    }
}