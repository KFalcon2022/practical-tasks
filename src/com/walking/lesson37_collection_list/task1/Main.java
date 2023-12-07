package com.walking.lesson37_collection_list.task1;

import com.walking.lesson37_collection_list.task1.model.Counter;
import com.walking.lesson37_collection_list.task1.service.CounterService;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/CounterAggregation">...</a>, используя ArrayList.
 * Рекомендую максимально расширить функциональность сервиса (не в ущерб здравому смыслу),
 * чтобы посмотреть в работе как можно большее количество методов списка.
 * <p>
 * Опциональное условие: замените ArrayList на Vector.
 * Изменилось ли что-то в кодовой базе при использовании списка другой реализации?
 */
/* реализовать класс счетчика, который хранит название счетчика и его значение,
         * его единицы измерения, а также обеспечивает доступ к значениям.
         * Название счетчика и его единицы измерения должны быть неизменны.
         * <p>
 * Также реализовать сервис CounterService, зона ответственности которого —
         * хранение массива доступных счетчиков, получение всех доступных счетчиков,
         * получение доступа к счетчику по названию,
         * увеличение значения счетчика на единицу или заданное значение,
         * а также сброс счетчика до нулевого значения.
         * + добавление нового счетчика, удаление счетчика по названию или индексу
         * <p>
 * Ответственность класса, содержащего main() — создание счетчиков.
         * Сам класс также предлагаю назвать Main.
         * <p>
 * Также реализовать в классе Main приватный метод,
         * который позволяет вывести значения счетчиков в виде:
         * <Название счетчика>: <Значение счетчика>.
        */

public class Main {
    public static void main(String[] args) {

        CounterService csTest = new CounterService();

        Counter homeHotWater = new Counter("HOME_hot water","m3");
        Counter homeColdWater = new Counter("HOME_cold water","m3");
        Counter homeElectricity = new Counter("HOME_electricity","kw/h");

        csTest.addCounter(homeHotWater);
        csTest.addCounter(homeColdWater);
        csTest.addCounter(homeElectricity);

        System.out.println("\n");
        System.out.println("List before action:");
        csTest.displayAll();

        Counter searchCounter = csTest.getCounterByName("HOME_hot water");
        csTest.increment(searchCounter);
        csTest.increase(homeElectricity,70);

        System.out.println("\n");
        System.out.println("List after increment:");
        csTest.displayAll();

        Counter workElectricity = new Counter("WORK_electricity","kw/h");
        csTest.addCounter(workElectricity);

        System.out.println("\n");
        System.out.println("List after new counter:");
        csTest.displayAll();

        csTest.remove(2);

        System.out.println("\n");
        System.out.println("List after removing by index:");
        csTest.displayAll();
    }
}