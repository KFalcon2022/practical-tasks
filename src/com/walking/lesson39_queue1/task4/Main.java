package com.walking.lesson39_queue1.task4;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        SingleQueue<Integer> queue = new SingleQueue<>();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue);

        queue.pop();
        System.out.println(queue);
    }
}
