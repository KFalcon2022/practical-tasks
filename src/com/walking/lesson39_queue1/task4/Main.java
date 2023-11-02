package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.task4.collection.Queue;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> list = initList();

        System.out.println(list.pop());
        System.out.println(list.pop());
    }

    public static Queue<Integer> initList() {
        Queue<Integer> list = new Queue<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        return list;
    }
}
