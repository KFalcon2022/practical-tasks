package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.util.HashSet;
import java.util.Set;

public class TaskService {
    private Node<Task> first;
    private Node<Task> last;

    private final Set<Task> tasks = new HashSet<>();

    public boolean added(Task task) {

        boolean result = tasks.add(task);

        if (result) {
            System.out.printf("Задача %s добавлена.\n", task);

            Node<Task> node = new Node<>(last, task, null);

            if (last == null) {
                first = node;
            } else {
                first.next = node;
            }
        }

        return result;
    }

    public boolean completed() {
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
