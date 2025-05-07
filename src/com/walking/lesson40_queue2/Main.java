package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.service.TaskService;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте класс Задание. Он должен содержать поле Название,
 * состав остальных полей - на ваше усмотрение.
 * <p>
 * Реализуйте сервис, хранящий задания.
 * Он должен иметь методы для добавления заданий и их "выполнения".
 * Задания должны обрабатываться в порядке очереди.
 * Критерием выполнения задания будем считать выведение в консоль фразы
 * "Задание %название задания% выполнено!".
 * <p>
 * Также добавьте вывод сообщения в консоль о том,
 * что задание (с указанием названия) добавлено.
 */
public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService(getTaskList());

        taskService.acceptSingleTask(new Task("Fourth"));
        taskService.executeSingleTask();

        if (taskService.haveTask()) {
            taskService.cancelNextTask();
        }

        taskService.executeMultipleTasks(2);
        taskService.acceptAllTasks(getTaskList());

        List<Task> canceledTasks = taskService.cancelMultipleTasks(2);
        System.out.println("Canceled tasks:");

        for (Task canceledTask : canceledTasks) {
            System.out.println(canceledTask.getName());
        }

        Task nextTask = taskService.lookNextTask();
        System.out.println("Next task: " + nextTask.getName());
    }

    public static List<Task> getTaskList() {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("First"));
        tasks.add(new Task("Second"));
        tasks.add(new Task("Third"));

        return tasks;
    }
}