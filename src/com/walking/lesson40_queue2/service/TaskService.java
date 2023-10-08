package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskService {
    private Deque<Task> tasks = new ArrayDeque<>();

    public Deque<Task> getTasks() {
        return tasks;
    }

    public void add(Task task) {
        tasks.add(task);

        System.out.printf("Task \"%s\" added to the queue\n", task.getName());
    }

    public void perform() {
        Task task = tasks.poll();

        System.out.printf("Task \"%s\" completed\n", task.getName());
    }
}
