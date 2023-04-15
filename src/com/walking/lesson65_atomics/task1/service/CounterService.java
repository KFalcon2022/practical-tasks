package com.walking.lesson65_atomics.task1.service;

import com.walking.lesson65_atomics.task1.model.Counter;

public class CounterService {
    private final CounterStorageService counterStorageService;

    public CounterService(CounterStorageService counterStorageService) {
        this.counterStorageService = counterStorageService;
    }

    public Counter increaseValue(String name, int value) {
        return increaseValue(counterStorageService.get(name), value);
    }

    public Counter decreaseValue(String name, int value) {
        return decreaseValue(counterStorageService.get(name), value);
    }

    public Counter decreaseValue(Counter counter, int value) {
        return increaseValue(counter, -value);
    }

    public Counter increaseValue(Counter counter, int value) {
        counter.getValue().getAndAdd(value);

        return counter;
    }

    public Counter incrementValue(String name) {
        return incrementValue(counterStorageService.get(name));
    }

    public Counter incrementValue(Counter counter) {
        counter.getValue().getAndIncrement();

        return counter;
    }

    public Counter decrementValue(String name) {
        return decrementValue(counterStorageService.get(name));
    }

    public Counter decrementValue(Counter counter) {
        counter.getValue().getAndDecrement();

        return counter;
    }

    public Counter resetValue(String name) {
        return resetValue(counterStorageService.get(name));
    }

    public Counter resetValue(Counter counter) {
        counter.getValue().set(0);

        return counter;
    }
}
