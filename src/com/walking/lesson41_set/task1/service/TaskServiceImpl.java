package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;

import java.time.LocalDateTime;
import java.util.*;

public class TaskServiceImpl implements TaskService {

    long orderId = 0L;
    //  Варіант поки що фігня, тому що дає можливість зберігати однакові завдання в Set'і.
    //  Порівняння елементів відбуваеться за допомогою метода compareTo, а не equals.
    NavigableSet<TaskWrapper> taskSet = new TreeSet<>(Comparator.comparingLong(TaskWrapper::getOrderId));

    @Override
    public void addTask(Task task) {
        if (taskSet.add(new TaskWrapper(task, orderId))) {
            orderId++;
        }
    }

    @Override
    public Task executeTask() {
        return Objects.requireNonNull(taskSet.pollFirst()).task;
    }

    @Override
    public boolean haveTasks() {
        return !taskSet.isEmpty();
    }

    private static class TaskWrapper {
        private final Task task;
        private final long orderId;

        TaskWrapper(Task task, long orderId) {
            this.task = task;
            this.orderId = orderId;
        }

        public long getOrderId() {
            return orderId;
        }
    }
}
