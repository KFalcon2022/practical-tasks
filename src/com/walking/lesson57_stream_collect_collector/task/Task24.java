package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию, превышает ли численность мужчин численность женщин по каждому департаменту.
 */
public class Task24 implements StatisticTask<Map<String, Boolean>> {
    @Override
    public Map<String, Boolean> calculate(List<Department> departments) {
        return departments.stream()
                          .collect(Collectors.groupingBy(Department::getName, Collectors.teeing(Collectors.flatMapping(
                                  d -> d.getEmployees()
                                        .stream()
                                        .filter(Employee::isMale)
                                        .distinct(), Collectors.counting()), Collectors.flatMapping(
                                  d -> d.getEmployees()
                                        .stream()
                                        .filter(e -> !e.isMale())
                                        .distinct(), Collectors.counting()), (mans, women) -> mans > women)));
    }
}
