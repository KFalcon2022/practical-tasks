package com.walking.lesson12_inkapsulyaciya;

import com.walking.lesson12_inkapsulyaciya.model.Counter;
import com.walking.lesson12_inkapsulyaciya.service.CounterService;

public class Main {
    public static void main(String[] args) {
        Counter gas = new Counter("Газ", "м3");
        Counter water = new Counter("Вода", "м3");
        Counter electro = new Counter("Электричество", "кв/ч");

        CounterService service = new CounterService(new Counter[]{gas, water, electro});

        service.increase(gas, 5);
        service.increment(gas);
        service.increase(water, 10);
        service.decrement(water);
        service.increment(electro);

        printCounters(service.getAllCounters());
    }

    private static void printCounters(Counter[] counters) {
        for (Counter counter : counters) {
            System.out.printf("%s: %d\n", counter.getName(), counter.getCount());
        }
    }
}
