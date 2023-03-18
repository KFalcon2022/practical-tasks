package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.Set;

/**
 * Предоставьте полный перечень оригинальных имен сотрудников компании.
 */
public class Task2 implements StatisticTask<Set<String>> {
    @Override
    public Set<String> calculate(List<Department> departments) {
        return null;
    }
}
