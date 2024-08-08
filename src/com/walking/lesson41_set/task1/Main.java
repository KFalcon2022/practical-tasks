package com.walking.lesson41_set.task1;

import com.walking.lesson41_set.task1.service.TaskManager;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson40_queue2">...</a>,
 * используя Set, вместо Queue.
 * Продумайте, как можно эффективно реализовать задачу,
 * чтобы сохранить принцип FIFO при обработке заданий.
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
