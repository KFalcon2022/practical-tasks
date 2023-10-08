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
                .collect(Collectors.groupingBy(Department::getName,
                        Collectors.flatMapping(
                                department -> department.getEmployees().stream(),
                                Collectors.collectingAndThen(
                                        Collectors.partitioningBy(Employee::isMale,
                                                Collectors.counting()),
                                        map -> (double) map.get(true) / map.get(false)))));
    }
}
