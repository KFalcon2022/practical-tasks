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
import com.walking.lesson28_generics1.task4.model.*;
public class Main {
    public static void main(String[] args) {

        Stack<Object> stack = new Stack<>();

        stack.push(5);
        stack.push("45");
        stack.push(56d);
        stack.push("23");

        System.out.println(stack.getAsArrayStr(stack.getTop()));
        System.out.println(stack.getDepth());

        System.out.println(stack.search(5));

        stack.delete(56d);

        System.out.println(stack.getAsArrayStr(stack.getTop()));
        System.out.println(stack.getDepth());

    }
}
