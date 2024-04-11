package com.walking.lesson12_counterAggregation;


import com.walking.lesson12_counterAggregation.model.Counter;
import com.walking.lesson12_counterAggregation.model.CounterService;

public class Main {
    public static void main(String[] args) {
        CounterService counterService = new CounterService();
        Counter[] counters = counterService.getCounters();

        Counter gasCounter = new Counter(Counter.GAS, 0, Counter.GAS_UNITS);
        Counter coldWaterCounter = new Counter(Counter.COLD_WATER, 0, Counter.COLD_WATER_UNITS);
        Counter hotWaterCounter = new Counter(Counter.HOT_WATER, 0, Counter.HOT_WATER_UNITS);
        Counter electricCounter = new Counter(Counter.ELECTRIC, 0, Counter.ELECTRIC_UNITS);

        counters[0] = gasCounter;
        counters[1] = coldWaterCounter;
        counters[2] = hotWaterCounter;
        counters[3] = electricCounter;

        counterService.getAvailableCounters();
        printCounterInfo(counters[0]);
        printCounterInfo(counters[1]);
        printCounterInfo(counters[2]);
        printCounterInfo(counters[3]);
        Counter counter =  counterService.getCounterByName(Counter.GAS);
        counter.increaseCounter(1000);
        printCounterInfo(counterService.getCounterByName(Counter.GAS));
        counterService.clearCounter(counter);
        printCounterInfo(counterService.getCounterByName(Counter.GAS));
        counterService.increaseCounter(counter, 9543);
        printCounterInfo(counterService.getCounterByName(Counter.GAS));
    }

    private static void printCounterInfo(Counter counter) {
        System.out.println(counter.getName() + ": " + counter.getCount() + counter.getUnits());
    }
}
