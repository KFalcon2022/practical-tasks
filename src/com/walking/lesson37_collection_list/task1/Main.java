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
    private static final String HOT_WATER_COUNTER_NAME = "Hot water";
    private static final String COLD_WATER_COUNTER_NAME = "Cold water";
    private static final String ELECTRICITY_COUNTER_NAME = "Electricity";

    private static final String WATER_UNIT = "m3";
    private static final String ELECTRICITY_UNIT = "kW/h";

    public static void main(String[] args) {
        Counter hotWaterCounter = new Counter(HOT_WATER_COUNTER_NAME, WATER_UNIT);
        Counter coldWaterCounter = new Counter(COLD_WATER_COUNTER_NAME, WATER_UNIT);
        Counter electricityCounter = new Counter(ELECTRICITY_COUNTER_NAME, ELECTRICITY_UNIT, 240);

        CounterService service = new CounterService(List.of(hotWaterCounter, coldWaterCounter));
        service.addCounter(electricityCounter);
        System.out.println(service.getCounterByName("Hot water"));
        service.reset("Electricity");

        System.out.println(service.getCounterByName(ELECTRICITY_COUNTER_NAME).getValue());
    }
}
