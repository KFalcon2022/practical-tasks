package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.model.Task;
import com.walking.lesson41_set.task1.service.TaskService;
import com.walking.lesson41_set.task1.service.TaskServiceImpl;
import com.walking.lesson41_set.task1.service.TaskServiceImplV2;

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
        TaskService taskServiceV2 = new TaskServiceImplV2();

        taskService.addTask(new Task("5"));
        taskService.addTask(new Task("6"));

        initTasks(taskService);
        initTasks(taskService);

        taskServiceV2.addTask(new Task("5"));
        taskServiceV2.addTask(new Task("6"));

        initTasks(taskServiceV2);
        initTasks(taskServiceV2);

        while (taskService.haveTasks()) {
            Task task = taskService.executeTask();
            System.out.printf("Задание %s выполнено! \n", task.getTitle());
        }
        System.out.println("\n \n");
        while (taskServiceV2.haveTasks()) {
            Task task = taskServiceV2.executeTask();
            System.out.printf("Задание %s выполнено! \n", task.getTitle());
        }

    }

    public static void initTasks(TaskService taskService) {
        for (int i = 0; i <= 5; i++) {
            Task task = new Task(String.valueOf(i));
            taskService.addTask(task);
        }
    }
}
