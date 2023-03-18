package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте список сотрудников женского пола и сотрудников мужского пола по каждому департаменту.
 */
public class Task19 implements StatisticTask<Map<String, Map<Boolean, List<Employee>>>> {
    @Override
    public Map<String, Map<Boolean, List<Employee>>> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.groupingBy(
                        Department::getName,
                        Collectors.flatMapping(
                                department -> department.getEmployees().stream(),
                                Collectors.partitioningBy(Employee::isMale))));
    }
}
