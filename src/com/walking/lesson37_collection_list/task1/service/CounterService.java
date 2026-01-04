package com.walking.lesson37_collection_list.task1.service;

import com.walking.lesson37_collection_list.task1.model.Counter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Также реализовать сервис CounterService, зона ответственности которого —
 * хранение массива доступных счетчиков, получение всех доступных
 * счетчиков, получение доступа к счетчику по названию, увеличение значения
 * счетчика на единицу или заданное значение, а также сброс счетчика до
 * нулевого значения.
 */
public class CounterService {
    private final List<Counter> counters;

    public CounterService(Collection<Counter> counters) {
        this.counters = new ArrayList<>(counters);
    }

    public Counter getCounterByName(String name) {
        for (Counter counter : counters) {
            if (counter.getName().equals(name)) {
                return counter;
            }
        }

        return null;
    }

    public List<Counter> getCounters() {
        return new ArrayList<>(List.copyOf(counters));
    }

    public boolean addCounter(Counter newCounter) {
        return counters.add(newCounter);
    }

    public void reset(String name) {
        getCounterByName(name).setValue(0);
        System.out.println("Counter is reset");
    }

    public void decrease(String name, int value) {
        Counter counter = getCounterByName(name);
        if (counter == null) {
            throw new RuntimeException("This counter is empty");
        }

        counter.setValue(counter.getValue() - value);
        System.out.println("Counter's value decreased");
    }

    public void decrement(String name) {
        decrease(name, 1);
    }

    public void increase(String name, int value) {
        Counter counter = getCounterByName(name);
        if (counter == null) {
            throw new RuntimeException("This counter is empty");
        }

        counter.setValue(counter.getValue() + value);
        System.out.println("Counter's value increased");
    }

    public void increment(String name) {
        increase(name, 1);
    }
}
