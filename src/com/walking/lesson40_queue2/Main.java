package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.service.TaskService;
import com.walking.lesson40_queue2.service.TaskServiceImpl;

import java.util.Deque;

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
        TaskService taskService = new TaskServiceImpl();
        initTasks(taskService);
        while (taskService.haveTasks()) {
            Task task = taskService.executeTask();
            System.out.printf("Задание %s выполнено! \n", task.getTitle());
        }
    }

    public static void initTasks(TaskService taskService) {
        for (int i = 0; i <= 20; i++) {
            taskService.addTask(new Task(String.valueOf(i)));
        }
    }
}
