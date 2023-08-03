package com.walking.lesson37_collection_list.task1;

import com.walking.lesson37_collection_list.task1.model.Counter;
import com.walking.lesson37_collection_list.task1.service.ServiceCounter;

import java.util.ArrayList;
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
    public static void main(String[] args) {
        Counter gasCounter = new Counter("Газ", "м3");
        Counter coldWaterCounter = new Counter("Холодная вода", "м3");
        Counter hotWaterCounter = new Counter("Горячая вода", "м3");

        Counter electricCounter = new Counter("Электричество", "кВт/ч");
        electricCounter.setValue(15);

        ServiceCounter counterService = new ServiceCounter(List.of(gasCounter, coldWaterCounter));
        counterService.add(hotWaterCounter);
        counterService.add(electricCounter);

        counterService.increaceValue("Газ", 100);

        counterService.increaceValue("Холодная вода", 10);

        printCounterValues(counterService.getAll());

        counterService.increaceValue("Газ");

        printCounterValues(counterService.getAll());
    }

    public static void printCounterValues(List<Counter> counters) {
        for (Counter counter : counters) {
            System.out.printf("%s: %d\n",counter.getName(),counter.getValue());
        }
    }
}
