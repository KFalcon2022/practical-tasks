package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskServiceImpl implements TaskService {

    Deque<Task> taskQueue = new ArrayDeque<>();

    @Override
    public void addTask(Task task) {
        taskQueue.add(task);
    }

    @Override
    public Task executeTask() {
        return taskQueue.pop();
    }

    @Override
    public boolean haveTasks() {
        return !taskQueue.isEmpty();
    }
}
