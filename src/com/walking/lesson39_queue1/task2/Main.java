package com.walking.lesson39_queue1.task2;

import com.walking.lesson39_queue1.task2.structure.Stack;

/**
 * Реализуйте структуру данных стек. Используйте односвязный список из Задачи 1.
 * При этом изменять сам класс, реализующий односвязный список, недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println(stack);

        System.out.println("На верху стека: " + stack.peek());

        System.out.println("Из стека извекли: " + stack.pop());

        System.out.println(stack);

        System.out.println("На верху стека: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);
    }
}