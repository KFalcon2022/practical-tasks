package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.LinkedHashSet;

public class TaskServiceImplV2 implements TaskService {

    LinkedHashSet<Task> linkedHashSet = new LinkedHashSet<>();

    @Override
    public void addTask(Task task) {
        linkedHashSet.add(task);
    }

    @Override
    public Task executeTask() {
        Task task = linkedHashSet.stream().findFirst().get();
        linkedHashSet.remove(task);
        return task;
    }

    @Override
    public boolean haveTasks() {
        return !linkedHashSet.isEmpty();
    }

}
