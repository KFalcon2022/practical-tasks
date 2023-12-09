package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.collections.DoublyLinkedList;
import com.walking.lesson39_queue1.collections.OneEndQueue;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        OneEndQueue<Integer> queue = new OneEndQueue<>();
        fillListInteger(queue);
        System.out.println(queue);
        System.out.println("Peek element: "+queue.peek());
        System.out.println(queue);
        System.out.println("\nPoll element: "+queue.poll());
        System.out.println(queue);
        System.out.println("\nRemove element");
        queue.remove();
        System.out.println(queue);
    }
    static void fillListInteger(OneEndQueue<Integer> list){
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(21);
        list.add(44);
        list.add(45);
        list.add(19);
        list.add(1);
        list.add(0);
    }
}
