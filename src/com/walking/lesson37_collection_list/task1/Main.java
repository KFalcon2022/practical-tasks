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
    public static final String HOT_WATER_COUNTER_NAME = "Горячая вода";
    public static final String COLD_WATER_COUNTER_NAME = "Холодная вода";
    public static final String ELECTRIC_COUNTER_NAME = "Электричество";

    public static final String M_3_UNIT = "м3";
    public static final String KW_H_UNIT = "кВт*ч";

    public static void main(String[] args) {
        CounterService counterService = new CounterService();
        counterService.displayContent();

        Counter gasCounter = new Counter(GAS_COUNTER_NAME, M_3_UNIT);
        Counter hotWaterCounter = new Counter(HOT_WATER_COUNTER_NAME, M_3_UNIT);
        Counter coldWaterCounter = new Counter(COLD_WATER_COUNTER_NAME, M_3_UNIT);

        Counter electricCounter = new Counter(ELECTRIC_COUNTER_NAME, KW_H_UNIT);
        electricCounter.setValue(15);

        counterService = new CounterService(coldWaterCounter, gasCounter);

        counterService.addCounter(hotWaterCounter);
        counterService.addCountersIfAbsent(electricCounter);
        counterService.addCountersIfAbsent(electricCounter);
        counterService.addCounter(electricCounter);
        counterService.addFirst(electricCounter);
        counterService.increaseCounter(GAS_COUNTER_NAME, 100);
        counterService.increaseCounter(coldWaterCounter, 10);
        counterService.displayContent();

        counterService.removeDuplicates();
        counterService.sortByName();
        counterService.removeAllZeroValue();
        System.out.println("Удаляем дубликаты, счетчики с нулевыми показаниями и сортируем по алфавиту:");
        counterService.displayContent();


        System.out.println("Название первого в списке счетчика: " + counterService.getFirst().getName());

        Counter[] allCounters = new Counter[counterService.getAllCounters().size() + 5];

        counterService.getAllCounters().toArray(allCounters);
        System.out.println("Переносим счетчики из списка в заранее созданный массив:");
        printCounterNames(allCounters);

        List<Counter> waterCounters = List.of(hotWaterCounter, coldWaterCounter);


        hotWaterCounter.setValue(100);
        counterService.addCounter(hotWaterCounter);
        counterService.removeIfNotMatch(waterCounters);
        System.out.println("Оставляем только счетчики воды:");
        counterService.displayContent();
    }

    public static void printCounterNames(Counter[] counters) {
        System.out.println("Названия счетчиков в массиве:");

        for (Counter counter : counters) {
            if (counter == null) {
                System.out.println("-");
            } else {
                System.out.println(counter.getName());
            }
        }
    }
}
