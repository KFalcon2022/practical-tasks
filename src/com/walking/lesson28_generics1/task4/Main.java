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
        Stack<Integer> stringStack = new Stack<>();

        stringStack.push(1);
        stringStack.push(2);
        stringStack.push(3);
        stringStack.push(4);
        stringStack.push(5);

        System.out.println("Содержимое стека: " + stringStack);
        System.out.printf("Глубина стека: %s фреймов\n", stringStack.size());

        stringStack.delete(2);

        System.out.println("Содержимое стека: " + stringStack);
        System.out.printf("Глубина стека: %s фреймов\n", stringStack.size());

        stringStack.push(2);

        System.out.printf("Элемент %S найден\n", stringStack.find(2));
        System.out.println("Содержимое стека: " + stringStack);
        System.out.printf("Глубина стека: %s фреймов\n", stringStack.size());
    }
}
