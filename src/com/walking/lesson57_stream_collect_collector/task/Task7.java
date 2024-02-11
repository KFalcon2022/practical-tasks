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
        // without collect
        return departments.stream()
                .mapToInt(d->d.getVacancyAmount()-d.getEmployees().size())
                .sum();

        //IDEA предлагает заменить на решение выше
//        return departments.stream()
//                .collect(Collectors.summingInt(
//                        d->d.getVacancyAmount()-d.getEmployees().size()
//                ));
    }
}
