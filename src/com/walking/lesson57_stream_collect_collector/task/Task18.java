package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * Предоставьте список сотрудников женского пола и сотрудников мужского пола в компании.
 */
public class Task18 implements StatisticTask<Map<Boolean, List<Employee>>> {
    @Override
    public Map<Boolean, List<Employee>> calculate(List<Department> departments) {
        return null;
    }
}
