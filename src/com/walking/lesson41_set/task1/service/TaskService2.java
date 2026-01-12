package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class TaskService2 {
    private final TreeSet<Task> tasks;
    private int amount;

    public TaskService2() {
        this.tasks = new TreeSet<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getNumber() - t2.getNumber();
            }
        });
    }

    public void add(Task task) {
        amount++;
        task.setNumber(amount);
        tasks.add(task);
        System.out.printf("Задание '%s' добавлено.%n", task.getName());
    }

    public String complete(int answer) {
        Task completedTask = getFirst();
        if (completedTask == null) {
            return "Все задания выполнены.";
        }
        if (completedTask.getAnswer() == answer) {
            tasks.remove(completedTask);
            amount--;
            return "Задание '%s' выполнено.%n".formatted(completedTask.getName());
        }
        return "Ответ неверный.";
    }

    public Task getFirst() {
        try {
            return tasks.first();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public int getAmount() {
        return amount;
    }
}
