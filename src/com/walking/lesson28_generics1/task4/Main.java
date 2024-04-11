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
        Stack<Integer> stack = createTestStack();
        System.out.println(stack.getSize());
        System.out.println(stack.search(1));
        stack.delete(1);
        stack.add(8);

        try {
            stack.delete(9);
        } catch (StackElementNotFoundException e) {
            System.out.println(e.getMessage());
        }

        stack.add(100);
        System.out.println(stack.getSize());
        System.out.println(stack);
    }

    private static Stack<Integer> createTestStack() {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        return stack;
    }
}
