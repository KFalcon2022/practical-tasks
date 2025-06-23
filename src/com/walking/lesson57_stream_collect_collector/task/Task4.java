package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Предоставьте список всех департаментов в алфавитном порядке в виде LinkedList.
 */
public class Task4 implements StatisticTask<LinkedList<Department>> {
    @Override
    public LinkedList<Department> calculate(List<Department> departments) {
        return departments.stream()
                          .sorted(Comparator.comparing(Department::getName))
                          .collect(Collectors.toCollection(LinkedList::new));
    }
}
