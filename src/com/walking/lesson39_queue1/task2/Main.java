package com.walking.lesson39_queue1.task2;

import com.walking.lesson39_queue1.task2.collection.Stack;

/**
 * Реализуйте структуру данных стек. Используйте односвязный список из Задачи 1.
 * При этом изменять сам класс, реализующий односвязный список, недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());//3
        System.out.println(stack.pop());//2

        stack.push(4);

        System.out.println(stack.pop());//4
        System.out.println(stack.pop());//1

        System.out.println(stack.pop());//NPE
    }
}
