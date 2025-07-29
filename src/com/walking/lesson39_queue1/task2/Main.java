package com.walking.lesson39_queue1.task2;

import com.walking.lesson39_queue1.task2.collection.Stack;

/**
 * Реализуйте структуру данных стек. Используйте односвязный список из Задачи 1.
 * При этом изменять сам класс, реализующий односвязный список, недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = createStack();

        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static Stack<Integer> createStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        return stack;
    }
}
