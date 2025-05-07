package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Предоставьте список всех сотрудников компании.
 */
public class Task1 implements StatisticTask<List<Employee>> {
    @Override
    public List<Employee> calculate(List<Department> departments) {
        return departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toList());
    }
}
