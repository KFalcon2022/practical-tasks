package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.Map;

/**
 * Предоставьте информацию по разнице в возрасте между самым молодым
 * и самым старым сотрудником по каждому департаменту.
 */
public class Task20 implements StatisticTask<Map<String, Integer>> {
    @Override
    public Map<String, Integer> calculate(List<Department> departments) {
        return null;
    }
}
