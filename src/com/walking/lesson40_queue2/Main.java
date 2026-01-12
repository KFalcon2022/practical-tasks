package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.service.TaskService;

import java.util.Scanner;

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
        TaskService tasks = createTaskPool();
        while(tasks.getAmount() != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println(tasks.get().getName());
            int answer = in.nextInt();
            tasks.complete(answer);
        }

    }

    public static TaskService createTaskPool() {
        TaskService tasks = new TaskService();
        tasks.add(new Task("Корень из 576", 24));
        tasks.add(new Task("32 в квадрате", 1024));
        tasks.add(new Task("12 в квадрате", 144));

        return tasks;
    }
}
