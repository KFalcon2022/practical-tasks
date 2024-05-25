package com.walking.lesson37_collection_list.task1;

import java.util.ArrayList;
import java.util.List;

public class CounterService {
    static List<Counter> counters = new ArrayList<>();


    public static void addCounter(Counter counter) {
        counters.add(counter);

    }

    public static void getCounters() {
        for (Counter counter : counters) {
            System.out.println(counter.getName());

        }
    }

    public static void resetCounter(Counter counter) {
        counter.setCounter(0);
    }

    public static void increment(Counter counter) {
        counter.setCounter(counter.getCounter() + 1);
    }

    public static void increase(Counter counter, int number) {
        counter.setCounter(counter.getCounter() + number);
    }

    public static int getCounter(Counter counter) {
        return counter.getCounter();
    }
}
