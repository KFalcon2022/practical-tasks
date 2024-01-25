package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию, превышает ли численность мужчин в компании численность женщин.
 */
public class Task23 implements StatisticTask<Boolean> {
    @Override
    public Boolean calculate(List<Department> departments) {

        //with teeing
//        return departments.stream()
//                .map(Department::getEmployees)
//                .flatMap(Collection::stream)
//                .collect(Collectors.teeing(
//                        Collectors.filtering(
//                                Employee::isMale,
//                                Collectors.counting()),
//                        Collectors.filtering(
//                                Predicate.not(Employee::isMale),
//                                Collectors.counting()),
//                        (maleNumber,femaleNumber)->maleNumber>femaleNumber));

        //without teeing
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                Employee::isMale,
                                Collectors.counting()),
                        map-> map.get(true)>map.get(false)));
    }
}
