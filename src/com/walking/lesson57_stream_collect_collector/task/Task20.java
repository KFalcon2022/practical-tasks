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
                                d -> d.getEmployees()
                                        .stream()
                                        .map(Employee::getAge),
                                Collectors.teeing(
                                        Collectors.minBy(Integer::compareTo),
                                        Collectors.maxBy(Integer::compareTo),
                                        (ageMin,ageMax) -> ageMax.orElse(0)-ageMin.orElse(0)))));
    }
}
