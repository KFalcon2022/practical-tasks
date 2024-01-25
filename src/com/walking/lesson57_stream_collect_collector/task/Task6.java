package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию о проценте открытых вакансий
 * относительно текущего числа сотрудников по каждому департаменту.
 */
public class Task6 implements StatisticTask<Map<String, Double>> {
    @Override
    public Map<String, Double> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d-> 1-((double)d.getEmployees().size()/d.getVacancyAmount())));
    }
}
