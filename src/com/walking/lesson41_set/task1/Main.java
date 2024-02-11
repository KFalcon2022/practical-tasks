package com.walking.lesson41_set.task1;

import com.walking.lesson40_queue2.models.Task;
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
        TaskService taskService = new TaskService(new Task("Task 0"));
        fillTaskList(taskService);
        taskService.perform();
        taskService.perform();
        taskService.perform();
        taskService.perform();
        taskService.perform();
    }
    private static void fillTaskList(TaskService tasks){
        tasks.add(new Task("Task 1"), new Task("Task 2"),new Task("Third task"));
    }
}
