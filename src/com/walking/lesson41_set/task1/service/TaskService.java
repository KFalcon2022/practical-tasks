package com.walking.lesson41_set.task1.service;

import com.walking.lesson41_set.task1.model.Task;
import com.walking.lesson41_set.task1.model.TaskStatus;
import com.walking.lesson41_set.task1.util.Logger;

import java.time.Instant;
import java.util.*;

public class TaskService {
    private final NavigableSet<Task> tasks;
    private final Logger logger;

    public TaskService() {
        this.tasks = new TreeSet<>();
        this.logger = new Logger();
    }

    public TaskService(Collection<? extends Task> incomingTasks) {
        this.tasks = new TreeSet<>(incomingTasks);
        this.logger = new Logger();

        for (Task incomingTask : incomingTasks) {
            logger.log(getTaskStatusMessage(incomingTask, TaskStatus.ACCEPTED));
        }
    }

    public List<Task> getAllTasks() {
        return List.copyOf(tasks);
    }

    public boolean acceptSingleTask(Task acceptedTask) {
        if (tasks.add(acceptedTask)) {
            acceptedTask.setAcceptedAt(Instant.now());
            logger.log(getTaskStatusMessage(acceptedTask, TaskStatus.ACCEPTED));

            return true;
        }

        return false;
    }

    public boolean acceptAllTasks(Collection<? extends Task> incomingTasks) {
        if (tasks.addAll(incomingTasks)) {
            for (Task acceptedTask : incomingTasks) {
                acceptedTask.setAcceptedAt(Instant.now());
                logger.log(getTaskStatusMessage(acceptedTask, TaskStatus.ACCEPTED));
            }

            return true;
        }

        return false;
    }

    public Task executeSingleTask() {
        Task executedTask = tasks.pollFirst();

        if (executedTask != null) {
            logger.log(getTaskStatusMessage(executedTask, TaskStatus.EXECUTED));
            executedTask.setAcceptedAt(null);
        }

        return executedTask;
    }

    public List<Task> executeMultipleTasks(int taskCount) {
        List<Task> executedTasks = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            executedTasks.add(executeSingleTask());
        }

        return executedTasks;
    }

    public Task cancelNextTask() {
        Task canceledTask = tasks.pollFirst();

        if (canceledTask != null) {
            logger.log(getTaskStatusMessage(canceledTask, TaskStatus.CANCELED));
            canceledTask.setAcceptedAt(null);
        }

        return canceledTask;
    }

    public List<Task> cancelMultipleTasks(int taskCount) {
        List<Task> canceledTasks = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            canceledTasks.add(cancelNextTask());
        }

        return canceledTasks;
    }

    public Task lookNextTask() {
        return tasks.isEmpty() ? null : tasks.first();
    }

    public boolean haveTask() {
        return !tasks.isEmpty();
    }

    private String getTaskStatusMessage(Task task, TaskStatus status) {
        return "Task <%s> %s".formatted(task.getName(), status);
    }
}