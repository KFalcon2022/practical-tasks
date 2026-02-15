package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте соотношение женщин и мужчин по каждому департаменту.
 */
public class Task15 implements StatisticTask<Map<String, Double>> {
    @Override
    public Map<String, Double> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.groupingBy(Department::getName,
                        Collectors.flatMapping(department -> department.getEmployees()
                                        .stream(),
                                Collectors.teeing(
                                        Collectors.filtering(Employee::isMale,
                                                Collectors.toList()),
                                        Collectors.filtering(employee -> !employee.isMale(),
                                                Collectors.toList()),
                                        (men, women) ->
                                                (double) (men.size() / women.size())))));

        /*Я так и не нашел способ, как задействовать Collectors.partitioningBy
         * Если не сложно, намекни (и да, я только прямые намёки понимаю ахахахаххаха),
         * пожалуйста)*/
    }
}
