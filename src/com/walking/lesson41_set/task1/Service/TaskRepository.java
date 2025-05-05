package com.walking.lesson41_set.task1.Service;

import com.walking.lesson41_set.task1.Task;

import java.util.*;

public class TaskRepository {
    NavigableSet<Task> repository = new TreeSet<>();

    public void add(Task task) {
        repository.add(task);
        System.out.printf("Задание '%s' добавлено!\n", task.getName());
    }

    public void complete() {

        if (repository.isEmpty()) {
            System.out.println("Очередь заданий пуста!");
        } else {
            Task task = repository.first();
            repository.remove(task);
            System.out.printf("Задание '%s' выполнено!\n", task.getName());
        }
    }

}
