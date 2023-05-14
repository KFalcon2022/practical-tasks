package com.walking.lesson72_blocking_non_blocking_queue.task1;

import com.walking.lesson72_blocking_non_blocking_queue.task1.model.Task;
import com.walking.lesson72_blocking_non_blocking_queue.task1.service.TaskService;

/**
 * Используя Задачу из урока 40, реализуйте сервис заданий,
 * позволяющий добавлять и получать задания.
 * Процесс добавления и получения задач должен быть потокобезопасен.
 *
 * @see com.walking.lesson40_queue2.Main
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskService taskService = new TaskService();

        // Обратите внимание, получение запускается до появления заданий.
        // И даже при задержке до запуска потоков,
        // добавляющих задания (чтобы гарантировать порядок запуска потоков),
        // эти потоки лишь ждут их появления
        new Thread(getCompleteTask(taskService)).start();
        new Thread(getCompleteTask(taskService)).start();

        Thread.sleep(1000);

        taskService.add(new Task("1"));
        taskService.add(new Task("2"));
        taskService.add(new Task("3"));

        new Thread(() -> {
            try { // для разнообразия добавим задачу в другом потоке
                taskService.add(new Task("4"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        })
                .start();

        new Thread(getCompleteTask(taskService)).start();
        new Thread(getCompleteTask(taskService)).start();
        new Thread(getCompleteTask(taskService)).start(); // Здесь программа должна зависнуть - заданий в очереди нет
    }

    private static Runnable getCompleteTask(TaskService taskService) {
        return () -> {
            try {
                taskService.complete();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}