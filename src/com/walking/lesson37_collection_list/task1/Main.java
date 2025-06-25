package com.walking.lesson37_collection_list.task1;

import com.walking.lesson37_collection_list.task1.model.Counter;
import com.walking.lesson37_collection_list.task1.service.CounterService;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    private static final String LINE_DELIMITER = "-".repeat(20);

    public static void main(String[] args) {
        CounterService counterService = new CounterService(new ArrayList<>());
        printOverview(counterService.getAllCounters());

        Counter gasCounter = new Counter(GAS_COUNTER_NAME, M_3_UNIT);
        Counter hotWaterCounter = new Counter(HOT_WATER_COUNTER_NAME, M_3_UNIT);
        Counter coldWaterCounter = new Counter(COLD_WATER_COUNTER_NAME, M_3_UNIT);

        Counter electricCounter = new Counter(ELECTRIC_COUNTER_NAME, KW_H_UNIT);
        electricCounter.setValue(15);

        counterService = new CounterService(List.of(coldWaterCounter, gasCounter));

        counterService.addCounter(hotWaterCounter);
        counterService.addCountersIfAbsent(electricCounter);
        counterService.addCountersIfAbsent(electricCounter);
        counterService.addCounter(electricCounter);
        counterService.addFirst(electricCounter);
        counterService.addFirst(new Counter("Электричество", KW_H_UNIT, 456));
        counterService.increaseCounter(GAS_COUNTER_NAME, 100);
        counterService.increaseCounter(coldWaterCounter, 10);
        printOverview(counterService.getAllCounters());

        counterService.removeDuplicates();
        counterService.sortByName();
        counterService.removeIdleCounters();
        System.out.println(">>>Удаляем дубликаты, счетчики с нулевыми показаниями и сортируем по алфавиту:");
        printOverview(counterService.getAllCounters());


        System.out.println("Название первого в списке счетчика: " + counterService.getFirst().getName());

        Counter[] allCounters = counterService.getAllCounters().toArray(new Counter[0]);
        System.out.println(">>>Переносим счетчики из списка в массив и выводим их названия:");
        printCounterNames(allCounters);

        List<Counter> waterCounters = List.of(hotWaterCounter, coldWaterCounter);


        hotWaterCounter.setValue(100);
        counterService.addCounter(hotWaterCounter);
        counterService.removeIfNotMatch(waterCounters);
        System.out.println(">>>Оставляем только счетчики воды:");
        printOverview(counterService.getAllCounters());
    }

    public static void printCounterNames(Counter[] counters) {
        StringJoiner result = new StringJoiner("\n", LINE_DELIMITER + "\n", "\n" + LINE_DELIMITER);

        for (Counter counter : counters) {
            result.add(counter == null ? "-" : counter.getName());
        }

        System.out.println(result);
    }

    public static void printOverview(List<Counter> counters) {
        System.out.printf("Всего счетчиков: %s\n%s\n", counters.size(), LINE_DELIMITER);

        if (counters.isEmpty()) {
            System.out.println("Добавьте счетчики для работы с ними.");
        } else {
            printCounterValues(counters);
        }

        System.out.println(LINE_DELIMITER);
    }

    private static void printCounterValues(List<Counter> counters) {
        for (Counter counter : counters) {
            System.out.printf("%s: %d %s\n", counter.getName(), counter.getValue(), counter.getUnitOfMeasure());
        }
    }
}