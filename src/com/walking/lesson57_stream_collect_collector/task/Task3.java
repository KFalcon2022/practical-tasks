package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Предоставьте полный перечень оригинальных имен сотрудников по каждому департаменту.
 */
public class Task3 implements StatisticTask<Map<String, Set<String>>> {
    @Override
    public Map<String, Set<String>> calculate(List<Department> departments) {
        return null;
    }
}
