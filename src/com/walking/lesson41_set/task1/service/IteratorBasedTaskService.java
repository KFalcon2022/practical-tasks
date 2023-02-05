package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

//Решение на основе итератора. Скажу честно: идея не моя, а одного из подписчиков. Но решение очень лаконичное
public class IteratorBasedTaskService implements TaskService {
    private final Set<Task> tasks = new LinkedHashSet<>();

    @Override
    public Task add(Task task) {
        tasks.add(task);
        System.out.printf("Task '%s' added!\n", task.getName());

        return task;
    }

    @Override
    public void complete() {
        Iterator<Task> taskIterator = tasks.iterator();

        if (!taskIterator.hasNext()) {
            System.out.println("Tasks' queue is empty!");
        } else {
            System.out.printf("Task '%s' completed!\n", taskIterator.next().getName());
            taskIterator.remove();
        }
    }
}
