package com.walking.lesson41_set.task1;


import com.walking.lesson41_set.task1.model.Task;
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
        TaskService service = new TaskService();

        service.added(new Task("Task 1"));
        service.added(new Task("Task 2"));
        service.added(new Task("Task 3"));
        service.added(new Task("Task 4"));

        service.completed();
        service.completed();

        service.added(new Task("Task 5"));
    }
}
