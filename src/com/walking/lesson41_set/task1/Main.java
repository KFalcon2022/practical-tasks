package com.walking.lesson41_set.task1;

import com.walking.lesson40_queue2.service.TaskService;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
 */
public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();

        service.taskAdded("Task 1");
        service.taskAdded("Task 2");
        service.taskAdded("Task 3");
        service.taskAdded("Task 4");

        service.taskCompleted();
        service.taskCompleted();

        service.taskAdded("Task 5");
    }
}
