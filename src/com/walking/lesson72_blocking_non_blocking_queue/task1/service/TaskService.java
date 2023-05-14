package com.walking.lesson72_blocking_non_blocking_queue.task1.service;

import com.walking.lesson72_blocking_non_blocking_queue.task1.model.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskService {
    private final BlockingQueue<Task> tasks = new LinkedBlockingQueue<>();

    public Task add(Task task) throws InterruptedException {
        tasks.put(task);
        System.out.printf("Task '%s' added!\n", task.getName());

        return task;
    }

    public void complete() throws InterruptedException {
        Task task = tasks.take();
        System.out.printf("Task '%s' completed!\n", task.getName());
    }
}
