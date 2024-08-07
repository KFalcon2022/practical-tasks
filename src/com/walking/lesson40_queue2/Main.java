package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.service.TaskManager;

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
        TaskManager taskManager=new TaskManager();
        taskManager.addTask("Полить цветы", "Только на подоконнике", "05.08.2024");
        taskManager.addTask("Помыть посуду", "Сковородку тоже", "07.08.2024");
        taskManager.addTask("Вынести мусор", "Не забыть заправить новый пакет", "08.08.2024");
        System.out.println(taskManager.getNextTask());
        taskManager.completeTask();
        taskManager.completeTask();
        taskManager.completeTask();
        taskManager.completeTask();
    }
}
