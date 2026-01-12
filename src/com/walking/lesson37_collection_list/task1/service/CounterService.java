package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.exception.CounterAlreadyExistException;
import com.walking.lesson37_collection_list.task1.exception.CounterIsNullException;
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

    public Counter add(Counter counter) throws CounterAlreadyExistException, CounterIsNullException {
        if (isNull(counter)) {
            throw new CounterIsNullException("Невозможно добавить счётчик равный null.");
        }

        if (isContains(counter)) {
            throw new CounterAlreadyExistException(counter.getNAME());
        }

        counters.add(counter);
        System.out.printf("Счётчик '%s' добавлен.\n", counter.getNAME());
        return counter;
    }

    public Counter delete(Counter counter) {
        counters.remove(counter);
        System.out.printf("Счётчик '%s' удалён.\n", counter.getNAME());
        return counter;
    }

    public Counter increaseValue(Counter counter, int value) throws CounterIsNullException {
        if (isNull(counter)) {
            throw new CounterIsNullException("Изменить показания счётчика, равного null, невозможно.");
        }

        int newValue = counter.getValue() + value;
        counter.setValue(newValue);
        System.out.printf("Показания счётчика '%s' обновлены.\n", counter.getNAME());
        return counter;
    }

    public Counter incrementValue(Counter counter) {
        return increaseValue(counter, 1);
    }

    public Counter increaseValue(String name, int value) {
        return increaseValue(getByName(name), value);
    }

    public Counter incrementValue(String name) {
        return incrementValue(getByName(name));
    }

    public Counter resetValue(Counter counter) {
        counter.setValue(0);
        return counter;
    }

    public Counter resetValue(String name) {
        return resetValue(getByName(name));
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
