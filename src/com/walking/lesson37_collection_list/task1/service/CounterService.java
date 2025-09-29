package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.ArrayList;
import java.util.List;

public class CounterService {
    private final List<Counter> counters;

    public CounterService(Counter... counters) {
        this.counters = new ArrayList<>(List.of(counters));
    }

    public CounterService(List<Counter> counters) {
        this.counters = new ArrayList<>(counters);
    }

    public Counter getByName(String name) {
        for (Counter counter : counters) {
            if (name.equals(counter.getNAME())) {
                return counter;
            }
        }
        return null;
    }

    public void add(Counter counter) {
        if (isNull(counter)) {
            System.out.println("Добавить счётчик не удалось.");
            return;
        }

        if (isContains(counter)) {
            System.out.printf("Счётчик с названием '%s' уже существует.\n", counter.getNAME());
            return;
        }
        counters.add(counter);
        System.out.printf("Счётчик '%s' добавлен.\n", counter.getNAME());

    }

    public void delete(Counter counter) {
        counters.remove(counter);
        System.out.printf("Счётчик '%s' удалён.\n", counter.getNAME());

    }

    public void increaseValue(Counter counter, int value) {
        if (isNull(counter)) {
            System.out.println("Обновить данные счётчика не удалось.");
            return;
        }

        int newValue = counter.getValue() + value;
        counter.setValue(newValue);
        System.out.printf("Данные счётчика '%s' обновлены.\n", counter.getNAME());
    }

    public void incrementValue(Counter counter) {
        increaseValue(counter, 1);
    }

    public void increaseValue(String name, int value) {
        increaseValue(getByName(name), value);
    }

    public void incrementValue(String name) {
        incrementValue(getByName(name));
    }

    public void resetValue(Counter counter) {
        counter.setValue(0);
    }

    public void resetValue(String name) {
        resetValue(getByName(name));
    }

    public List<Counter> getCounters() {
        return List.copyOf(counters);
    }

    private boolean isContains(Counter counter) {
        for (Counter c : counters) {
            if (counter.getNAME().equals(c.getNAME())) {
                return true;
            }
        }
        return false;
    }

    private boolean isNull(Counter counter) {
        return counter == null;
    }
}
