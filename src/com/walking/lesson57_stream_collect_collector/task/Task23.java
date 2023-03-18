package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию, превышает ли численность мужчин в компании численность женщин.
 */
public class Task23 implements StatisticTask<Boolean> {
    @Override
    public Boolean calculate(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .filter(Predicate.not(Employee::isMale))
                .collect(Collectors.collectingAndThen(Collectors.partitioningBy(Employee::isMale), Optional::of))
                .map(map -> map.get(true).size() > map.get(false).size())
                .orElse(false);

//        Также есть вариант без Optional, но с повторяющейся фильтрацией:
//        return departments.stream()
//                .map(Department::getEmployees)
//                .flatMap(Collection::stream)
//                .collect(Collectors.teeing(
//                        Collectors.filtering(Employee::isMale, Collectors.counting()),
//                        Collectors.filtering(Predicate.not(Employee::isMale), Collectors.counting()),
//                        (maleAmount, femaleAmount) -> maleAmount > femaleAmount));

//        Также можно использовать partitioningBy(). См. Task24
    }
}
