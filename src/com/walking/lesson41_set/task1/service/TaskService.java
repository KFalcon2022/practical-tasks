package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskService {
    private Set<Task> tasks = new LinkedHashSet<>();

    public Set<Task> getTasks() {
        return tasks;
    }

    public void add(Task task) {
        tasks.add(task);

        System.out.printf("Task \"%s\" added to the queue\n", task.getName());
    }

    public void perform() {
        Iterator<Task> iterator = tasks.iterator();

        Task task;

        if (iterator.hasNext()) {
            task = iterator.next();

            tasks.remove(task);

            System.out.printf("Task \"%s\" completed\n", task.getName());
        }
    }
}
