package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.Service.TaskRepository;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
 */
public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();

        repository.add(new Task("Task 1"));
        repository.add(new Task("Task 2"));
        repository.add(new Task("Task 3"));
        repository.add(new Task("Task 4"));
        repository.add(new Task("Task 5"));

        System.out.println("_________________________");

        repository.complete();
        repository.complete();
        repository.complete();
        repository.complete();
        repository.complete();
        repository.complete();
    }
}
