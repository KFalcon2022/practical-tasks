package com.walking.lesson12_Incapsulation_package.task.my;

import com.walking.lesson12_Incapsulation_package.task.my.counter.Counter;
import com.walking.lesson12_Incapsulation_package.task.my.counter.CounterService;

/**
 * Разработать программу в рамках компании walking/com,
 * позволяющую следить за счетчиками на газ, холодную воду, горячую воду и электричество.
 * Обозначение программы в рамках компании — counterAggregation.
 *<p>
 * Используя за основу задачу из темы про классы и объекты,
 * реализовать класс счетчика, который хранит название счетчика и его значение, его единицы измерения,
 * а также обеспечивает доступ к значениям.
 * Название счетчика и его единицы измерения должны быть неизменны. !DONE
 *<p>
 * Также реализовать сервис CounterService, зона ответственности которого —
 * хранение массива доступных счетчиков, !DONE
 * получение всех доступных счетчиков, !DONE
 * получение доступа к счетчику по названию, !DONE
 * увеличение значения счетчика на единицу !DONE или заданное значение !DONE, а также
 * сброс счетчика до нулевого значения.!DONE
 *<p>
 * Ответственность класса, содержащего main() — создание счетчиков.
 * Сам класс также предлагаю назвать Main.
 *<p>
 * Также реализовать в классе Main приватный метод,
 * который позволяет вывести значения счетчиков в виде:
 *<p></p>
 *     <Название счетчика>: <Значение счетчика>
 *         <p></p>
 * Например:
 * <p>
 *   Газ: 2333 <p>
 *   Горячая вода: 0 <p>
 *   Холодная вода: 23
 *   ...
 */
public class Main {
    public static void main(String[] args) {

        Counter hotWater = new Counter("Hot water", 124, "m^3");
        Counter coldWater = new Counter("Cold water", 1172, "m^3");
        Counter electricity = new Counter("Electricity", 15100, "kW/h");

        CounterService counters = new CounterService(hotWater, coldWater, electricity);

        counters.getOneObject("Electricity");
        counters.increment("Electricity");
        counters.increase("Electricity", 20);
        counters.getOneObject("Electricity");
//        counters.reset("Electricity");
        counters.getOneObject("Electricity");


        getCountersInfo(counters);

        electricity.reset();

        getCountersInfo(counters);
    }

    private static void getCountersInfo(CounterService counterService) {
        counterService.getObjects();
    }
}
