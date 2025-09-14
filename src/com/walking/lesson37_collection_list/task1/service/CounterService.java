package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.ArrayList;
import java.util.List;

public class CounterService {
    private ArrayList<Counter> counters;

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
        if (counter == null) {
            System.out.println("Добавить счётчик не удалось.");
            return;
        }

        if (isContains(counter)) {
            System.out.printf("Счётчик с названием '%s' уже существует.\n", counter.getNAME());
            return;
        }

        if (counters.add(counter)) {
            System.out.printf("Счётчик '%s' добавлен.\n", counter.getNAME());
            counters.trimToSize();
        } else {
            System.out.println("Добавить счётчик не удалось.");
        }
    }

    public void delete(Counter counter) {
        if (counters.remove(counter)) {
            System.out.printf("Счётчик '%s' удалён.\n", counter.getNAME());
            counters.trimToSize();
        } else {
            System.out.println("Удалить счётчик не удалось.");
        }
    }

    public void increaseValue(Counter counter, int value) {
        if(counter == null) {
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

    public ArrayList<Counter> getCounters() {
        return new ArrayList<>(counters);
    }

    public void setCounters(List<Counter> counters) {
        if (!counters.isEmpty()) {
            this.counters = new ArrayList<>(counters);
        }
    }

    private boolean isContains(Counter counter) {
        for (Counter c : counters) {
            if (counter.getNAME().equals(c.getNAME())) {
                return true;
            }
        }
        return false;
    }
}
