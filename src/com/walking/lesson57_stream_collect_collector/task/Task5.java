package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Предоставьте самого старшего обладателя каждого из имен.
 * Попробуйте сделать это без использования downstream.
 */
public class Task5 implements StatisticTask<Map<String, Employee>> {
    @Override
    public Map<String, Employee> calculate(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(
                        Employee::getName,
                        Function.identity(),
                        (e1, e2) -> e1.getAge() >= e2.getAge() ? e1 : e2));
    }
}
