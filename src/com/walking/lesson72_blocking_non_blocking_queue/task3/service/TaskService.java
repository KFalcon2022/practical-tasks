package com.walking.lesson72_blocking_non_blocking_queue.task3.service;

import com.walking.lesson72_blocking_non_blocking_queue.task3.model.Task;

public class TaskService {
    private final TaskThreadPool threadPool = new TaskThreadPool();

    public Task add(Task task) throws InterruptedException {
        threadPool.execute(task);
        System.out.printf("Task with number '%s' was added!\n", task.getNumber());

        return task;
    }
}
