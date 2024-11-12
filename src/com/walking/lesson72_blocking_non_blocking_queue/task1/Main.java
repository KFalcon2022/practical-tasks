package com.walking.lesson72_blocking_non_blocking_queue.task1;

import java.util.concurrent.atomic.AtomicBoolean;

import com.walking.lesson72_blocking_non_blocking_queue.task1.service.TaskManager;

/**
 * Используя Задачу из урока 40, реализуйте сервис заданий,
 * позволяющий добавлять и получать задания.
 * Процесс добавления и получения задач должен быть потокобезопасен.
 * @see com.walking.lesson40_queue2.Main
 */
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager=new TaskManager();
        AtomicBoolean isEnd=new AtomicBoolean(false);
        Thread producer=new Thread(()->{
            try {
                taskManager.addTask("Полить цветы", "Только на подоконнике", "05.08.2024");
                taskManager.addTask("Помыть посуду", "Сковородку тоже", "07.08.2024");
                taskManager.addTask("Вынести мусор", "Не забыть заправить новый пакет", "08.08.2024");    
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isEnd.set(true);
        });

        Thread consumer=new Thread(()->{
            while (!isEnd.get()) {
                while (!taskManager.getNextTask().equals("Заданий нет")) {
                    try {
                        taskManager.completeTask();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        producer.start();
        consumer.start();
    }
}