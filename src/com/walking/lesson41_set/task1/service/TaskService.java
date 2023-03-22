package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TaskService {
    private LinkedHashSet<Task> tasks = new LinkedHashSet<>();

    public LinkedHashSet<Task> getTasks() {
        return tasks;
    }

    public void add(Task task) {
        tasks.add(task);

        System.out.printf("Task \"%s\" added to the queue\n", task.getName());
    }

    public void perform() {
        Iterator<Task> iterator = tasks.iterator();

        Task task = iterator.next();
        task.perform();

        tasks.remove(task);

        System.out.printf("Task \"%s\" completed\n", task.getName());
    }
}
