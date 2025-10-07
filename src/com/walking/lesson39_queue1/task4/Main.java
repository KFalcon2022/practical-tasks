package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.task4.queue.MyQueue;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>(12);
        myQueue.push(34);
        myQueue.push(55);

        System.out.println(myQueue.pop());
        myQueue.pop();
        System.out.println(myQueue.peek());
    }
}
