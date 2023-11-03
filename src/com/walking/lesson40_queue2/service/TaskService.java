package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.LinkedList;


public class TaskService extends LinkedList<Task> {

    public void taskAdded(String task) {
        offer(new Task(task));
        System.out.printf("Задача %s добавлена.\n", task);
    }

    public void taskCompleted() {
        System.out.printf("Задача %s выполнена.\n", getFirst().getName());
        poll();
    }
}
