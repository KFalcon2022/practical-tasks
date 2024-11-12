package com.walking.lesson72_blocking_non_blocking_queue.task3;

import java.util.concurrent.atomic.AtomicBoolean;

import com.walking.lesson72_blocking_non_blocking_queue.task3.model.Task;
import com.walking.lesson72_blocking_non_blocking_queue.task3.service.TaskManager;

/**
 * Развейте Задачу 1 из текущего урока.
 * <p>
 * Заданиями должно выступать выведение случайно сгенерированного числа
 * (пределы определите самостоятельно) в консоль,
 * а потом усыпления потока-исполнителя на указанное число секунд.
 * Задания должны генерироваться безостановочно
 * (можно ограничить емкость хранилища заданий),
 * обрабатывать их должно не более 4 потоков одновременно.
 * <p>
 * По сути, корректным решением данной задачи является эмуляция работы пула потоков
 * в его наивной реализации. С пулами потоков, предоставляемыми Java,
 * мы познакомимся в ближайших уроках.
 * @see com.walking.lesson72_blocking_non_blocking_queue.task1.Main
 */
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager=new TaskManager();
        AtomicBoolean isEnd=new AtomicBoolean(false);
        Thread producer=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    taskManager.addTask(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isEnd.set(true);
        });

        Runnable consumerTask=()->{
            Task task;
            while (!isEnd.get()) {
                while (taskManager.getNextTask()!=null) {
                    try {
                        task=taskManager.completeTask();
                        System.out.println("Выполняется задание: "+task.getNumber());
                        Thread.sleep(task.getNumber()*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        for (int i = 0; i < 5; i++) {
            Thread consumer=new Thread(consumerTask);
            consumer.start();
        }
    }
}