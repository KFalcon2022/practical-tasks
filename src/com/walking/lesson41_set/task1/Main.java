package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.model.Task;
import com.walking.lesson41_set.task1.service.IteratorBasedTaskService;
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
        TaskService taskService = new IteratorBasedTaskService();
//        TaskService taskService = new CreatedFieldBasedTaskService();
//        TaskService taskService = new StaticFieldBasedTaskService();

        taskService.add(new Task("1"));
        taskService.add(new Task("2"));
        taskService.add(new Task("3"));

        taskService.complete();
        taskService.complete();

        taskService.add(new Task("4"));

        taskService.complete();
        taskService.complete();

        taskService.complete();
        taskService.complete();
    }
}
