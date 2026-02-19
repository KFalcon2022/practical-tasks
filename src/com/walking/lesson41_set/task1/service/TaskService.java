package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.TreeSet;

public class TaskService {
    private final TreeSet<Task> tasks = new TreeSet<>();

    public boolean add(Task task) {
        tasks.add(task);
        task.setIndex(tasks.size());
        System.out.printf("Task %s added and his index is %d\n", task.getName(), task.getIndex());

        return true;
    }

    public void complete() {
        Task task = tasks.pollLast();

        if (tasks.isEmpty()) {
            System.out.println("TaskList is empty!");
            return;
        }

        for (Task t : tasks) {
            t.setIndex(t.getIndex() - 1);
        }

        System.out.printf("Task %s completed\n", task.getName());
    }
}
