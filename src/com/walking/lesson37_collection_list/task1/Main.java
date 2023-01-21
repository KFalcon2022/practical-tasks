package com.walking.lesson37_collection_list.task1;

import com.walking.lesson37_collection_list.task1.model.Counter;
import com.walking.lesson37_collection_list.task1.service.CounterService;

import java.util.List;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/CounterAggregation">...</a>, используя ArrayList.
 * Рекомендую максимально расширить функциональность сервиса (не в ущерб здравому смыслу),
 * чтобы посмотреть в работе как можно большее количество методов списка.
 * <p>
 * Опциональное условие: замените ArrayList на Vector.
 * Изменилось ли что-то в кодовой базе при использовании списка другой реализации?
 */
public class Main {
    public static final String GAS_COUNTER_NAME = "Газ";
    public static final String COLD_WATER_COUNTER_NAME = "Холодная вода";
    public static final String HOT_WATER_COUNTER_NAME = "Горячая вода";
    public static final String ELECTRIC_COUNTER_NAME = "Электричество";

    public static final String M_3_UNIT = "м3";
    public static final String KW_H_UNIT = "кВт/ч";

    public static void main(String[] args) {
        Counter gasCounter = new Counter(GAS_COUNTER_NAME, M_3_UNIT);
        Counter coldWaterCounter = new Counter(COLD_WATER_COUNTER_NAME, M_3_UNIT);
        Counter hotWaterCounter = new Counter(HOT_WATER_COUNTER_NAME, M_3_UNIT);

        Counter electricCounter = new Counter(ELECTRIC_COUNTER_NAME, KW_H_UNIT);
        electricCounter.setValue(15);

        CounterService counterService = new CounterService(List.of(gasCounter, coldWaterCounter));
        counterService.addCounter(hotWaterCounter);
        counterService.addCounter(electricCounter);

        counterService.increaseCounter(GAS_COUNTER_NAME, 100);
        counterService.increaseCounter(coldWaterCounter, 10);

        printCounterValues(counterService.getAllCounters());
    }

    private static void printCounterValues(List<Counter> counters) {
        for (Counter counter : counters) {
            System.out.printf("%s: %s\n", counter.getName(), counter.getValue());
        }
    }
}
