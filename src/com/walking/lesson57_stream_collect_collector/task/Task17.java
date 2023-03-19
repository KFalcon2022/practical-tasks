package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию по максимальному возрасту сотрудников в каждом из департаментов.
 */
public class Task17 implements StatisticTask<Map<String, Integer>> {
    @Override
    public Map<String, Integer> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.groupingBy(
                        Department::getName,
                        Collectors.flatMapping(
                                department -> department.getEmployees()
                                        .stream()
                                        .map(Employee::getAge),
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.naturalOrder()),
                                        maxAgeOptional -> maxAgeOptional.orElse(0)))));

//        Альтернативное решение с помощью merge-функции в toMap()
//        return departments.stream()
//                .collect(Collectors.toMap(
//                        Department::getName,
//                        department -> department.getEmployees()
//                                .stream()
//                                .map(Employee::getAge)
//                                .max(Comparator.naturalOrder())
//                                .orElse(0)));
    }
}
