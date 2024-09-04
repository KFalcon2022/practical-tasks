package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Предоставьте полный перечень оригинальных имен сотрудников компании.
 */
public class Task2 implements StatisticTask<Set<String>> {
    @Override
    public Set<String> calculate(List<Department> departments) {
        return departments.stream()
                          .flatMap(d -> d.getEmployees()
                                         .stream())
                          .map(Employee::getName)
                          .collect(Collectors.toSet());
    }
}
