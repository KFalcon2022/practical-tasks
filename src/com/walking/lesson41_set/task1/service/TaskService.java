package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.HashSet;
import java.util.Set;

public class TaskService {
    private Node<Task> first;
    private Node<Task> last;

    private final Set<Task> tasks = new HashSet<>();

    public boolean taskAdded(String task) {
        Task addedTask = new Task(task);

        boolean result = tasks.add(addedTask);

        if (result) {
            System.out.printf("Задача %s добавлена.\n", task);

            Node<Task> node = new Node<>(last, addedTask, null);

            if (last == null) {
                first = node;
            } else {
                first.next = node;
            }

            return result;
        }

        return result;
    }

    public boolean taskCompleted() {
        System.out.printf("Задача %s выполнена.\n", first.value.getName());
        return tasks.remove(first);
    }

    private static class Node<Task> {
        private Node<Task> prev;
        private Task value;
        private Node<Task> next;

        private Node(Task value) {
            this.value = value;
        }

        private Node(Node<Task> prev, Task value, Node<Task> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
