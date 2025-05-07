package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Перечислите названия всех департаментов компании через запятую.
 */
public class Task8 implements StatisticTask<String> {
    @Override
    public String calculate(List<Department> departments) {
        return departments.stream()
                          .map(Department::getName)
                          .collect(Collectors.joining(", ", "", "."));
    }
}
