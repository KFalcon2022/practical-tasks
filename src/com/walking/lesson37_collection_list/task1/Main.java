package com.walking.lesson37_collection_list.task1;

import static com.walking.lesson37_collection_list.task1.CounterService.*;

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
        Counter gas = new Counter("Газ", "м/куб", 50);
        Counter hotWater = new Counter("Горячая вода", "м/куб");
        Counter coldWater = new Counter("Холодная вода", "м/куб");

        addCounter(gas);
        addCounter(hotWater);
        addCounter(coldWater);

        gas.setCounter(10);
        hotWater.setCounter(15);
        coldWater.setCounter(20);
        resetCounter(gas);
        printCounters();
        getCounters();
    }

    private static void printCounters() {
        for (Counter counter : counters) {
            System.out.println(counter.getName() + " " + counter.getCounter() + " " + counter.getMeasure());
        }
    }
}
