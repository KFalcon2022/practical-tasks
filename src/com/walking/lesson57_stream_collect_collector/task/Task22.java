package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Предоставьте список всех сотрудников женского пола, если их больше 30,
 * в противном случае – предоставьте список всех сотрудников мужского пола.
 */
public class Task22 implements StatisticTask<List<Employee>> {
    @Override
    public List<Employee> calculate(List<Department> departments) {
        return departments.stream()
                  .map(Department::getEmployees)
                  .flatMap(Collection::stream)
                  .collect(Collectors.collectingAndThen(Collectors.partitioningBy(Employee::isMale), Optional::of))
                  .map(map -> map.get(false).size() > 30 ? map.get(false) : map.get(true))
                  .orElse(List.of());
    }
}
