package com.walking.lesson39_queue1.task4;

import com.walking.lesson39_queue1.task4.structure.Queue;

/**
 * Реализуйте одностороннюю очередь на базе двусвязного списка из Задачи 3.
 */
public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>();
        System.out.println("Очередь после создания:\n" + strings);

        strings.push("First");
        strings.push("Second");
        strings.push("Third");
        strings.push("Fourth");
        System.out.println("Очередь после добавления элементов:\n" + strings);

        System.out.println("Следующий элемент для извлечения из очереди:\n" + strings.peek());

        String fromQueue = strings.pop();
        System.out.println("Элемент извелченный из очереди:\n" + fromQueue);

        System.out.println("Очередь после извлечения элементов:\n" + strings);

        strings.pop();
        strings.pop();
        strings.pop();

        System.out.println("Очередь после извлечения всех элементов:\n" + strings);
    }
}