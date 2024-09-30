package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте количество сотрудников старше 50 по каждому департаменту.
 */
public class Task12 implements StatisticTask<Map<String, Long>> {
    @Override
    public Map<String, Long> calculate(List<Department> departments) {
        return departments.stream()
        .collect(Collectors.groupingBy(
            Department::getName,
            Collectors.flatMapping(
                d->d.getEmployees().stream().map(Employee::getAge).filter(age->age>=50),
                Collectors.counting())
            
        ));
    }
}
