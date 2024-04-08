package com.walking.lesson28_generics1.task4;

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
        Stack<Integer> testStack = createTestStack();
        System.out.println(testStack.getSize());
        System.out.println(testStack.search(1));
        testStack.delete(1);
        testStack.add(100);
        System.out.println(testStack.getSize());
    }

    private static Stack<Integer> createTestStack() {
        Stack<Integer> testStack = new Stack<>();
        testStack.add(1);
        testStack.add(2);
        testStack.add(3);
        testStack.add(4);
        return testStack;
    }
}
