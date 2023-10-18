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
    private final static String GAS_COUNTER_NAME = "Газ";
    private final static String WATER_COUNTER_NAME = "Вода";
    private final static String ELECTRO_COUNTER_NAME = "Электричество";
    private final static String GAS_COUNTER_TYPE = "м3";
    private final static String WATER_COUNTER_TYPE = "м3";
    private final static String ELECTRO_COUNTER_TYPE = "кв/ч";

    public static void main(String[] args) {
        Counter gas = new Counter(GAS_COUNTER_NAME, GAS_COUNTER_TYPE);
        Counter water = new Counter(WATER_COUNTER_NAME, WATER_COUNTER_TYPE);
        Counter electro = new Counter(ELECTRO_COUNTER_NAME, ELECTRO_COUNTER_TYPE);

        CounterService service = new CounterService(List.of(gas, water));
        service.add(electro);

        service.increase(GAS_COUNTER_NAME, 50);
        service.increase(water, 100);
        service.increment(electro);
        service.increment(ELECTRO_COUNTER_NAME);
        service.decrease(WATER_COUNTER_NAME, 5);
        service.decrease(gas, 6)    ;
        service.decrement(ELECTRO_COUNTER_NAME);

        printCounters(service.getAllCounters());
    }

    private static void printCounters(List<Counter> counters) {
        for (Counter counter : counters) {
            System.out.println(counter);
        }
    }
}
