package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.*;
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
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toMap(Employee::getName, Function.identity(),
                        (o1, o2) -> o1.getAge() >= o2.getAge() ? o1 : o2));
    }
}
