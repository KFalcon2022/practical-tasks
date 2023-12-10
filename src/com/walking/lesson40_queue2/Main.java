package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.models.Task;
import com.walking.lesson40_queue2.service.TaskService;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
        TaskService taskService = new TaskService(new Task("Task 0"));
        fillTaskList(taskService);
        taskService.perform();
    }
    private static void fillTaskList(TaskService tasks){
        tasks.add(new Task("Task 1"), new Task("Task 2"),new Task("Third task"));
    }
}
