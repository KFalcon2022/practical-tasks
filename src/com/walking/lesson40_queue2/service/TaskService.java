package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.Deque;

public interface TaskService {

    void addTask(Task task);

    Task executeTask();

    boolean haveTasks();
}
