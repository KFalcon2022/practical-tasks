package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию, превышает ли численность мужчин численность женщин по каждому департаменту.
 */
public class Task24 implements StatisticTask<Map<String, Boolean>> {
    @Override
    public Map<String, Boolean> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        department -> department.getEmployees()
                                .stream()
                                .collect(Collectors.teeing(
                                        Collectors.filtering(Employee::isMale, Collectors.counting()),
                                        Collectors.filtering(Predicate.not(Employee::isMale), Collectors.counting()),
                                        (maleAmount, femaleAmount) -> maleAmount > femaleAmount))));

//        И вариант с partitioningBy():
//        return departments.stream()
//                .collect(Collectors.toMap(
//                        Department::getName,
//                        department -> department.getEmployees()
//                                .stream()
//                                .collect(Collectors.collectingAndThen(
//                                        Collectors.partitioningBy(Employee::isMale, Collectors.counting()),
//                                        map -> map.get(true) > map.get(false)))));
    }
}
