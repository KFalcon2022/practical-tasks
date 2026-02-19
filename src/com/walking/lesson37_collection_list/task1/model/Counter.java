package com.walking.lesson37_collection_list.task1.model;

/**
 * Разработать программу в рамках компании com.walking, позволяющую
 * следить за счетчиками на газ, холодную воду, горячую воду и электричество.
 * Обозначение программы в рамках компании — counterAggregation.
 * Используя за основу задачу из темы про классы и объекты (ссылка на
 * разбор), реализовать класс счетчика, который хранит название счетчика и его
 * значение, его единицы измерения, а также обеспечивает доступ к значениям.
 * Название счетчика и его единицы измерения должны быть неизменны.
 * Также реализовать сервис CounterService, зона ответственности которого —
 * хранение массива доступных счетчиков, получение всех доступных
 * счетчиков, получение доступа к счетчику по названию, увеличение значения
 * счетчика на единицу или заданное значение, а также сброс счетчика до
 * нулевого значения.
 * Ответственность класса, содержащего main() — создание счетчиков. Сам
 * класс также предлагаю назвать Main.
 * Также реализовать в классе Main приватный метод, который позволяет
 * вывести значения счетчиков в виде: <Название счетчика>: <Значение
 * счетчика>. Например:
 * Газ: 2333
 * Горячая вода: 0
 * Холодная вода: 23
 */
public class Counter {
    private final String name;
    private final String unit;

    private int value;

    public Counter(String name, String unit) {
        this(name, unit, 0);
    }

    public Counter(String name, String unit, int value) {
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "This counter's name is " + getName();
    }
}
