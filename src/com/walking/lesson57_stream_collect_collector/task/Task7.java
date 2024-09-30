package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Предоставьте общее число открытых вакансий в компании.
 */
public class Task7 implements StatisticTask<Integer> {
    @Override
    public Integer calculate(List<Department> departments) {
        return departments.stream()
        .collect(Collectors.summingInt(Department::getVacancyAmount));
    }
}
