package com.walking.lesson41_set.task1;


import com.walking.lesson41_set.task1.model.Task;
import com.walking.lesson41_set.task1.service.TaskService;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
 */
public class Main {
    public static void main(String[] args) {
        TaskService tasks = createTaskPool();
        while(tasks.getAmount() != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println(tasks.get().getName());
            int answer = in.nextInt();
            System.out.println(tasks.complete(answer));
        }
        System.out.println("Все задания выполнены!");
    }

    public static TaskService createTaskPool() {
        TaskService tasks = new TaskService();
        tasks.add(new Task("Корень из 576", 24));
        tasks.add(new Task("32 в квадрате", 1024));
        tasks.add(new Task("12 в квадрате", 144));

        return tasks;
    }
}
