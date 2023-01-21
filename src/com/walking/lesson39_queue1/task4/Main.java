package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.task4.collection.Queue;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> stack = new Queue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());//1
        System.out.println(stack.pop());//2

        stack.push(4);

        System.out.println(stack.pop());//3
        System.out.println(stack.pop());//4

        System.out.println(stack.pop());//NPE
    }
}
