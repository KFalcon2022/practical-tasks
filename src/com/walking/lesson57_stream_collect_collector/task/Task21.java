package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию по минимальному,
 * максимальному и среднего возрасту сотрудников на каждой должности.
 */
public class Task21 implements StatisticTask<Map<String, IntSummaryStatistics>> {
    @Override
    public Map<String, IntSummaryStatistics> calculate(List<Department> departments) {
        return departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getPosition,
                        Collectors.summarizingInt(Employee::getAge)));
    }
}
