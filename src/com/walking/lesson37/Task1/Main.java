package com.walking.lesson37.Task1;

import java.util.Scanner;

public class Main {
    public static Scanner SCANNER = new Scanner(System.in);

    public static void main (String[] args){
        CounterService counters = new CounterService();
        counters.add(new Counter("CT0594", "kVt", 16.8))
                .add(new Counter("CX594", "kVt", 5549.1))
                .add(new Counter("ZZZ999", "test", 111.777))
                .add(new Counter("asd7As", "L", -1.0))
                .insert(1, new Counter("B27As", "L", 0.0))
                .insert(15, new Counter("qwe53q", "L", 54.0));

        counters.printCounters();

        //// Более наивный подход
        // change value by order id
        Counter testCounter = counters.getCounter(2);
        testCounter.setValue(999.0);

        // search and remove
        testCounter = counters.findCounter("ZZZ999");
        if (testCounter != null) {
            counters.remove(testCounter); // ну пока так
        }

        //// Чуть менее наивный
        counters.incValue("CX594", 18);
        counters.remove("CT0594");
        counters.clear("asd7As");

        counters.printCounters();
    }
}
