package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.Service.TaskRepository;

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
        TaskRepository repository = new TaskRepository();

        repository.add(new Task("Task 1"));
        repository.add(new Task("Task 2"));
        repository.add(new Task("Task 3"));

        repository.complete();
        repository.complete();
        repository.complete();
        repository.complete();


    }
}
