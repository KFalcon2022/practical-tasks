package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.ArrayDeque;

public class TaskService {
    private ArrayDeque<Task> tasks = new ArrayDeque<>();

    public ArrayDeque<Task> getTasks() {
        return tasks;
    }

    public void add(Task task) {
        tasks.add(task);

        System.out.printf("Task \"%s\" added to the queue\n", task.getName());
    }

    public void perform() {
        Task task = tasks.pollFirst();

        task.perform();

        System.out.printf("Task \"%s\" completed\n", task.getName());
    }
}
