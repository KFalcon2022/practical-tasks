package com.walking.lesson28_generics_1.task_4;

/*
 * Реализовать параметризованный класс, хранящий и обрабатывающий стек.
 * Стек — структура данных, в котором каждый элемент хранит ссылку на следующий.
 * Работает по принципу LIFO (последний вошел — первый вышел).
 * Реализовать следующие методы:
 * Добавление элемента в стек;
 * Удаление элемента из стека. При удалении несуществующего элемента – исключение;
 * Получение глубины (количества элементов) стека;
 * Поиск по стеку, при отсутствии искомого значения – исключение;
 * Получение строкового эквивалента элементов стека, представленных в виде массива
 * ([строковое представление элемента1, ..., строковое представление элементаN]).
 */

public class Task {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        //System.out.println(list.find("two"));
        System.out.println(list.size()); // ==> 0
        System.out.println(list); // ==> [...]

        list.add("one");
        list.add("two");
        list.add("three");
        String fortyTwo = new String("42");
        list.add(fortyTwo);

        System.out.println(list.size()); // ==> 4
        System.out.println(list); // ==> [one, two, three, 42]

        System.out.println(list.find(fortyTwo)); // ==> 42

        list.delete(fortyTwo);
        list.delete("one");

        System.out.println(list.size()); // ==> 2
        System.out.println(list); // ==> [two, three]

        String twoAnother = new String("two");
        System.out.println(list.find(twoAnother)); // ==> Exception "Value not exist"
    }
}
