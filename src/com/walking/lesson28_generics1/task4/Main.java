package com.walking.lesson28_generics1.task4;

import com.walking.lesson28_generics1.task4.model.Stack;

/**
 * Реализовать параметризованный класс, хранящий и обрабатывающий стек.
 * Стек — структура данных, в котором каждый элемент хранит ссылку на следующий.
 * Работает по принципу LIFO (последний вошел — первый вышел).
 * <p>
 * Реализовать следующие методы:
 * <p>
 * Добавление элемента в стек;
 * Удаление элемента из стека. При удалении несуществующего элемента – исключение;
 * Получение глубины (количества элементов) стека;
 * Поиск по стеку, при отсутствии искомого значения – исключение;
 * Получение строкового эквивалента элементов стека, представленных в виде массива
 * ([строковое представление элемента1, ..., строковое представление элементаN]).
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>(2);

        integerStack.push(5);
        integerStack.push(2);
        integerStack.push(6);
        integerStack.push(-2);
        integerStack.push(77);

        System.out.println(integerStack);
        System.out.println(integerStack.searchElement(5));

        integerStack.deleteElement(6);

        System.out.println(integerStack);

    }
}
