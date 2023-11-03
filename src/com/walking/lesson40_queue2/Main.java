package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.service.TaskService;

import java.util.Arrays;
import java.util.Collection;

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
        TaskService service = new TaskService();
        service.addAll(initTaskArray());

        service.taskAdded("Task 6");
        service.taskAdded("Task 7");

        service.taskCompleted();
        service.taskCompleted();
    }

    public static Collection<? extends Task> initTaskArray() {
        Task[] tasks = new Task[]{
                new Task("Task 1"),
                new Task("Task 2"),
                new Task("Task 3"),
                new Task("Task 4"),
                new Task("Task 5")
        };

        return Arrays.asList(tasks.clone());
    }
}
