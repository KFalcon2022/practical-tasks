package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.Map;

/**
 * По каждой должности (position) предоставьте список сотрудников,
 * ее занимающих (допустимо ограничиться обозначением сотрудника по имени).
 */
public class Task16 implements StatisticTask<Map<String, List<String>>> {
    @Override
    public Map<String, List<String>> calculate(List<Department> departments) {
        return null;
    }
}
