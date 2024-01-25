package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте список сотрудников по каждому имени.
 */
public class Task10 implements StatisticTask<Map<String, List<Employee>>> {
    @Override
    public Map<String, List<Employee>> calculate(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Employee::getName));
    }
}
