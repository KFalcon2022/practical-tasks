package com.walking.lesson39_queue1.task2;

import com.walking.lesson39_queue1.task2.stack.MyStack;

/**
 * Реализуйте структуру данных стек. Используйте односвязный список из Задачи 1.
 * При этом изменять сам класс, реализующий односвязный список, недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        MyStack<Integer> nums = new MyStack<>(12);
        nums.push(23);
        nums.push(34);
        nums.push(42);
        nums.push(28);

        System.out.println(nums.peek());
        System.out.println(nums.pop());
        System.out.println(nums.pop());
        System.out.println(nums.pop());
    }
}
