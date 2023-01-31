package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

public class TaskServiceImplV2 implements TaskService {

    LinkedHashSet<Task> linkedHashSet = new LinkedHashSet<>();

    @Override
    public void addTask(Task task) {
        linkedHashSet.add(task);
    }

    @Override
    public Task executeTask() {
        Task task = linkedHashSet.stream().findFirst().orElseThrow(() -> new NoSuchElementException("There aren't tasks to complete"));
        linkedHashSet.remove(task);
        return task;
    }

    @Override
    public boolean haveTasks() {
        return !linkedHashSet.isEmpty();
    }

}
