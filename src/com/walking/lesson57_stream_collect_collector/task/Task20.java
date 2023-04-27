package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию по разнице в возрасте между самым молодым
 * и самым старым сотрудником по каждому департаменту.
 */
public class Task20 implements StatisticTask<Map<String, Integer>> {
    @Override
    public Map<String, Integer> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.groupingBy(
                        Department::getName,
                        Collectors.flatMapping(
                                department -> department.getEmployees().stream()
                                        .map(Employee::getAge),
                                Collectors.teeing(
                                        Collectors.maxBy(Integer::compareTo),
                                        Collectors.minBy(Integer::compareTo),
                                        (maxAge, minAge) -> (maxAge.orElse(0) - minAge.orElse(0))))));
    }
}
