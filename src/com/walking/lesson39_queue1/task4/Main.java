package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.task4.model.Queue;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        // System.out.println(queue.peek());
        // System.out.println(queue.size());
        // System.out.println(queue.pop());
        queue.offer("1");
        // System.out.println(queue.peek());
        // System.out.println(queue.size());
        queue.offer("2");
        // System.out.println(queue.peek());
        // System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
