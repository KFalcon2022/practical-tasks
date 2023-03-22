package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.service.TaskService;

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
        Task stepForward = new Task("Step Forward");
        Task stepBack = new Task("Step Back");
        Task turnLeft = new Task("Turn left");
        Task turnRight = new Task("Turn right");
        Task turnAround = new Task("Turn around");

        TaskService tasks = new TaskService();

        tasks.add(stepForward);
        tasks.add(stepBack);
        tasks.add(turnLeft);
        tasks.add(turnRight);
        tasks.add(turnAround);

        while(tasks.getTasks().peek() != null) {
            tasks.perform();
        }
    }
}
