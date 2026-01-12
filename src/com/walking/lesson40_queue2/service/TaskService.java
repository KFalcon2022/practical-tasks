package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;

import java.util.LinkedList;
import java.util.Queue;

public class TaskService {
    private final Queue<Task> tasks;
    private int amount;

    public TaskService() {
        this.tasks = new LinkedList<>();
    }

    public void add(Task task) {
        tasks.add(task);
        amount++;
        System.out.printf("Задание '%s' добавлено.%n", task.getName());
    }

    public void complete(int answer) {
        Task completedTask = get();
        if (completedTask == null) {
            System.out.println("Все задания выполнены.");
        } else if (completedTask.getAnswer() == answer) {
            tasks.remove();
            amount--;
            System.out.printf("Задание '%s' выполнено.%n", completedTask.getName());
        } else {
            System.out.println("Ответ неверный.");
        }
    }

    public Task get() {
            return tasks.peek();
    }

    public int getAmount() {
        return amount;
    }
}
