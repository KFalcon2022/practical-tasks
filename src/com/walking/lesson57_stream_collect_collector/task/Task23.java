package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию, превышает ли численность мужчин в компании численность женщин.
 */
public class Task23 implements StatisticTask<Boolean> {
    @Override
    public Boolean calculate(List<Department> departments) {
        return departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.collectingAndThen(
                        Collectors.partitioningBy(Employee::isMale),
                        Optional::of))
                .map(map -> map.get(true).size() > map.get(false).size())
                .orElse(false);
    }
}
