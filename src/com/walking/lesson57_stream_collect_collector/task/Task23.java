package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию, превышает ли численность мужчин в компании численность женщин.
 */
public class Task23 implements StatisticTask<Boolean> {
    @Override
    public Boolean calculate(List<Department> departments) {
        return departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.teeing(
                        Collectors.filtering(Employee::isMale,
                                Collectors.toList()),
                        Collectors.filtering(employee -> !employee.isMale(),
                                Collectors.toList()),
                        (male, female) -> male.size() > female.size()
                ));

        /* Я другие варианты как выполнить это задание не нашел.
         * Но если есть - дай намёк, пж) */
    }
}
