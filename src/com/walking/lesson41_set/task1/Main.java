package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.service.TaskService;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
 */
public class Main {
    public static void main(String[] args) {
        TaskService tasks = new TaskService();

        tasks.add("pizda");
        tasks.add("pidor");
        tasks.add("govno");
        tasks.add("zalupa");

        System.out.println("\n" + tasks);

        tasks.execute();

        System.out.println("\nresult:\n" + tasks);

    }
}
