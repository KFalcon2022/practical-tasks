package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию по числу женщин в каждом департаменте.
 */
public class Task9 implements StatisticTask<Map<String, Long>> {
    @Override
    public Map<String, Long> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.groupingBy(
                        Department::getName,
                        Collectors.flatMapping(
                                department -> department.getEmployees()
                                        .stream()
                                        .filter(Predicate.not(Employee::isMale)),
                                Collectors.counting())));

//        Здесь и далее, в ряде решений можно groupingBy() заменить на toMap() и наоборот.
//        Например, в этой задаче могло быть
//        return departments.stream()
//                .collect(Collectors.toMap(
//                        Department::getName,
//                        department -> department.getEmployees()
//                                .stream()
//                                .filter(Predicate.not(Employee::isMale))
//                                .count()));
    }
}
