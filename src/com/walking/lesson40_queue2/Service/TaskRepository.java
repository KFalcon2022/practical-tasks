package com.walking.lesson40_queue2.Service;

import com.walking.lesson40_queue2.Task;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskRepository {
    Queue<Task> repository = new ArrayDeque<>();

    public void add(Task task) {
        repository.offer(task);
        System.out.println("Задание " + task.getName() + " добавлено!");
    }

    public void complete() {
        Task task = repository.poll();

        if (task == null) {
            System.out.println("Очередь заданий пуста!");
        } else {
            System.out.printf("Задание '%s' выполнено!\n", task.getName());
        }
    }

}
