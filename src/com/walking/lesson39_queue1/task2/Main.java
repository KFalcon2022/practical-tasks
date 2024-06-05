package com.walking.lesson39_queue1.task2;

/**
 * Реализуйте структуру данных стек. Используйте односвязный список из Задачи 1.
 * При этом изменять сам класс, реализующий односвязный список, недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);


    }
}
