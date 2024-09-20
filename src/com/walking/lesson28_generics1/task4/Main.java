package com.walking.lesson28_generics1.task4;

import com.walking.lesson28_generics1.task4.structure.Stack;

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
        Stack<Integer> stack = initStack();
        System.out.println("Размер стека: " + stack.getSize());

        stack.add(7);
        System.out.println("Размер стека: " + stack.getSize());

        stack.delete(3);
        System.out.println("Размер стека: " + stack.getSize());

        System.out.println(stack.find(5));
        System.out.println(stack);
    }

    private static Stack<Integer> initStack() {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);

        return stack;
    }
}


