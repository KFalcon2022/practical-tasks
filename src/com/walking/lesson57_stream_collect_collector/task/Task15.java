package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте соотношение женщин и мужчин по каждому департаменту.
 */
public class Task15 implements StatisticTask<Map<String, Double>> {
    @Override
    public Map<String, Double> calculate(List<Department> departments) {
        return departments.stream()
        .collect(Collectors.toMap(
            Department::getName, 
            d->(double)d.getEmployees().stream()
            .collect(Collectors.partitioningBy(Employee::isMale))
            .get(false).size()/(double)d.getEmployees().stream()
            .collect(Collectors.partitioningBy(Employee::isMale))
            .get(true).size()
            ));
    }
}
