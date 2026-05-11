package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Предоставьте список всех сотрудников женского пола, если их больше 30,
 * в противном случае – предоставьте список всех сотрудников мужского пола.
 */
public class Task22 implements StatisticTask<List<Employee>> {
    @Override
    public List<Employee> calculate(List<Department> departments) {
        return departments.stream()
                .flatMap(
                        d -> d.getEmployees()
                                .stream())
                .collect(Collectors.teeing(
                        Collectors.filtering(
                                Employee::isMale,
                                Collectors.toList()),
                        Collectors.filtering(
                                e -> !e.isMale(),
                                Collectors.toList()),
                        (maleEmployees, femaleEmployees) -> {
                            return femaleEmployees.size() > 30 ? femaleEmployees : maleEmployees;
                        }
                ));
    }
}
