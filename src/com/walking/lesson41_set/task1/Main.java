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
        TaskService taskService = addTasks();

        taskService.answerTask();
    }

    private static TaskService addTasks() {
        TaskService taskService = new TaskService();
        Task task1 = new Task("Task2", "1+1", 2);
        Task task2 = new Task("Task1", "2*2", 4);
        taskService.addTask(task1);
        taskService.addTask(task2);

        return taskService;
    }
}
