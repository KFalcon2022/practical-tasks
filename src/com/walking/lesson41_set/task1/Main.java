package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.model.Task;
import com.walking.lesson41_set.task1.service.ServiceTask;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
 */
public class Main {
    public static void main(String[] args) {
        ServiceTask serviceTask = new ServiceTask();

        serviceTask.addTask(new Task("1"));
        serviceTask.addTask(new Task("2"));
        serviceTask.addTask(new Task("3"));
        serviceTask.addTask(new Task("4"));

        serviceTask.completeTask("1");
        serviceTask.completeTask("3");
    }
}
