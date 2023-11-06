package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.ArrayDeque;
import java.util.Queue;


public class TaskService {
    Queue<Task> list = new ArrayDeque<>();

    public Task taskAdded(String task) {
        Task addedTask = new Task(task);
        list.offer(addedTask);
        System.out.printf("Задача %s добавлена.\n", task);

        return addedTask;
    }

    public Task taskCompleted() {
        System.out.printf("Задача %s выполнена.\n", list.peek().getName());
        return list.remove();
    }
}
