package com.walking.lesson40_queue2.service;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.model.TaskStatus;
import com.walking.lesson40_queue2.util.Logger;

import java.util.*;

public class TaskService {
    private final Queue<Task> tasks;
    private final Logger logger;

    public TaskService() {
        this.tasks = new ArrayDeque<>();
        this.logger = new Logger();
    }

    public TaskService(Collection<? extends Task> incomingTasks) {
        this.tasks = new ArrayDeque<>(incomingTasks);
        this.logger = new Logger();

        for (Task incomingTask : incomingTasks) {
            logger.log(getTaskStatusMessage(incomingTask, TaskStatus.ACCEPTED));
        }
    }

    public List<Task> getAllTasks() {
        return List.copyOf(tasks);
    }

    public boolean acceptSingleTask(Task acceptedTask) {
        if (tasks.offer(acceptedTask)) {
            logger.log(getTaskStatusMessage(acceptedTask, TaskStatus.ACCEPTED));
            return true;
        }

        return false;
    }

    public boolean acceptAllTasks(Collection<? extends Task> incomingTasks) {
        if (tasks.addAll(incomingTasks)) {
            for (Task acceptedTask : incomingTasks) {
                logger.log(getTaskStatusMessage(acceptedTask, TaskStatus.ACCEPTED));
            }

            return true;
        }

        return false;
    }

    public Task executeSingleTask() {
        Task executedTask = tasks.poll();

        if (executedTask != null) {
            logger.log(getTaskStatusMessage(executedTask, TaskStatus.EXECUTED));
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
        Task canceledTask = tasks.poll();

        if (canceledTask != null) {
            logger.log(getTaskStatusMessage(canceledTask, TaskStatus.CANCELED));
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
        return tasks.peek();
    }

    public boolean haveTask() {
        return tasks.peek() != null;
    }

    private String getTaskStatusMessage(Task task, TaskStatus status) {
        return "Task <%s> %s".formatted(task.getName(), status);
    }
}