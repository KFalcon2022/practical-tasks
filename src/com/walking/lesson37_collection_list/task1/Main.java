package com.walking.lesson37_collection_list.task1;

import com.walking.lesson37_collection_list.task1.model.Counter;
import com.walking.lesson37_collection_list.task1.service.CounterService;

import java.util.ArrayList;
import java.util.List;

/**
 * –еализуйте задачу
 * <a href="https://github.com/KFalcon2022/CounterAggregation">...</a>, использу€ ArrayList.
 * –екомендую максимально расширить функциональность сервиса (не в ущерб здравому смыслу),
 * чтобы посмотреть в работе как можно большее количество методов списка.
 * <p>
 * ќпциональное условие: замените ArrayList на Vector.
 * »зменилось ли что-то в кодовой базе при использовании списка другой реализации?
 */
public class Main {
    public static final String GAS_COUNTER_NAME = "Gas";
    public static final String COLD_WATER_COUNTER_NAME = "Cold water";
    public static final String HOT_WATER_COUNTER_NAME = "Hot water";
    public static final String ELECTRIC_COUNTER_NAME = "Electricity";

    public static final String M_3_UNIT = "m3";
    public static final String KW_H_UNIT = "kilowatt per hour";

    public static void main(String[] args) {
        Counter gasCounter = new Counter(GAS_COUNTER_NAME, M_3_UNIT);
        Counter coldWaterCounter = new Counter(COLD_WATER_COUNTER_NAME, M_3_UNIT);
        Counter hotWaterCounter = new Counter(HOT_WATER_COUNTER_NAME, M_3_UNIT);

        Counter electricCounter = new Counter(ELECTRIC_COUNTER_NAME, KW_H_UNIT);
        electricCounter.setValue(15);

        List<Counter> counters = new ArrayList<>();

        CounterService counterService = new CounterService(counters);
        counterService.addCounter(gasCounter);
        counterService.addCounter(coldWaterCounter);
        counterService.addCounter(hotWaterCounter);
        counterService.addCounter(electricCounter);

        counterService.increaseCounter(GAS_COUNTER_NAME, 100);
        counterService.increaseCounter(coldWaterCounter, 10);

        printCounterValues(counterService.getAllCounters());

        counterService.reset(gasCounter);
        counterService.decrementCounter(COLD_WATER_COUNTER_NAME);
        counterService.deleteCounter(hotWaterCounter);

        printCounterValues(counterService.getAllCounters());
    }

    private static void printCounterValues(List<Counter> counters) {
        for (Counter counter : counters) {
            System.out.printf("%s: %s\n", counter.getName(), counter.getValue());
        }
    }
}
