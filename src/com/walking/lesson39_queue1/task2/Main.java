package com.walking.lesson39_queue1.task2;

import com.walking.lesson39_queue1.collections.StackTrue;

/**
 * Реализуйте структуру данных стек. Используйте односвязный список из Задачи 1.
 * При этом изменять сам класс, реализующий односвязный список, недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        StackTrue<Integer> testStack = new StackTrue<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);
        testStack.push(6);
        testStack.push(7);
        testStack.push(103);

        System.out.println(testStack);

        System.out.println(testStack.pop());
        System.out.println(testStack.pop());
        System.out.println(testStack.pop());
        System.out.println(testStack);
    }
}
