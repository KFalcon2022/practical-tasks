package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * По каждой должности (position) предоставьте список сотрудников,
 * ее занимающих (допустимо ограничиться обозначением сотрудника по имени).
 */
public class Task16 implements StatisticTask<Map<String, List<String>>> {
    @Override
    public Map<String, List<String>> calculate(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Employee::getPosition,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList())));
    }
}
