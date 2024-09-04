package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Предоставьте список всех сотрудников женского пола, если их больше 30,
 * в противном случае – предоставьте список всех сотрудников мужского пола.
 */
public class Task22 implements StatisticTask<List<Employee>> {
    @Override
    public List<Employee> calculate(List<Department> departments) {
        return departments.stream()
                          .flatMap(d -> d.getEmployees()
                                         .stream())
                          .distinct()
                          .collect(Collectors.teeing(Collectors.filtering(Employee::isMale, Collectors.toList()),
                                  Collectors.filtering(e -> !e.isMale(), Collectors.toList()),
                                  (mans, women) -> women.size() > 30 ? women : mans));
    }

    /* такой способ многословнее, но позволяет
     не собирать список сотрудников мужского пола, если это не нужно*/
    public List<Employee> calculate1(List<Department> departments) {
        return departments.stream()
                          .flatMap(d -> d.getEmployees()
                                         .stream())
                          .filter(e -> !e.isMale())
                          .distinct()
                          .collect(Collectors.collectingAndThen(Collectors.toList(), women -> women.size() > 30 ?
                                  women :
                                  departments.stream()
                                             .flatMap(d -> d.getEmployees()
                                                            .stream())
                                             .filter(Employee::isMale)
                                             .distinct()
                                             .collect(Collectors.toList())));
    }
}
