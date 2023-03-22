package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию по разнице в возрасте между самым молодым
 * и самым старым сотрудником по каждому департаменту.
 */
public class Task20 implements StatisticTask<Map<String, Integer>> {
    @Override
    public Map<String, Integer> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.groupingBy(
                        Department::getName,
                        Collectors.teeing(
                                Collectors.flatMapping(
                                        department -> department.getEmployees()
                                                .stream()
                                                .map(Employee::getAge),
                                        Collectors.maxBy(Integer::compareTo)),
                                Collectors.flatMapping(
                                        department -> department.getEmployees()
                                                .stream()
                                                .map(Employee::getAge),
                                        Collectors.minBy(Integer::compareTo)),
                                (oldestOptional, youngestOptional) ->
                                        oldestOptional.map(oldest -> oldest - youngestOptional.orElse(0))
                                                .orElse(0))));

//        Более оптимальное решение, но с вкраплением императивного стиля
//        return departments.stream()
//                .collect(Collectors.toMap(
//                        Department::getName,
//                        department -> {
//                            var sortedAges = department.getEmployees()
//                                    .stream()
//                                    .map(Employee::getAge)
//                                    .collect(Collectors.toCollection(TreeSet::new));
//
//                            return sortedAges.isEmpty() ? 0 : sortedAges.last() - sortedAges.first();
//                        }));
    }
}
