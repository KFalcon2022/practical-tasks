package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.ArrayDeque;
import java.util.Queue;


public class TaskService {
    Queue<Task> list = new ArrayDeque<>();

    public Task added(Task task) {;
        list.offer(task);
        System.out.printf("Задача %s добавлена.\n", task);

        return task;
    }

    public Task completed() {
        Task deletedTask = list.remove();

        System.out.printf("Задача %s выполнена.\n", deletedTask.getName());

        return deletedTask;
    }
}
