package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию по числу женщин в каждом департаменте.
 */
public class Task9 implements StatisticTask<Map<String, Long>> {
    @Override
    public Map<String, Long> calculate(List<Department> departments) {
        return departments.stream()
        .collect(Collectors.groupingBy(
            Department::getName,
            Collectors.flatMapping(
                department->department.getEmployees().stream().filter(e->!e.isMale()),
                 Collectors.counting())
        ));
    }
}
