package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

public class TaskService {
    private final LinkedHashSet<Task> tasks;
    private int amount;

    public TaskService() {
        this.tasks = new LinkedHashSet<>();
    }

    public void add(Task task) {
        tasks.add(task);
        amount++;
        System.out.printf("Задание '%s' добавлено.%n", task.getName());
    }

    public String complete(int answer) {
        Task completedTask = get();
        if (completedTask == null) {
            return "Все задания выполнены.";
        }
        if (completedTask.getAnswer() == answer) {
            tasks.removeFirst();
            amount--;
            return "Задание '%s' выполнено.%n".formatted(completedTask.getName());
        }
        return "Ответ неверный.";

    }

    public Task get() {
        try {
            return tasks.getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public int getAmount() {
        return amount;
    }
}
