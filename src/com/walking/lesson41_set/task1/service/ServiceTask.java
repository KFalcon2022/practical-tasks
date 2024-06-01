package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.LinkedHashSet;

public class ServiceTask {
    private final LinkedHashSet<Task> tasks = new LinkedHashSet<>();

    public Task addTask(Task task) {
        tasks.add(task);
        System.out.printf("Task %s added! \n", task.getName());

        return task;
    }

    public void completeTask(String s) {
        if (tasks.getFirst().getName().equals(s)) {
            System.out.printf("Task %s complete!\n", s);
            tasks.removeFirst();
        } else {
            System.out.printf("Task %s is not the first in line!\n", s);
        }
    }
}
