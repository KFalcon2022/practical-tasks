package com.walking.lesson72_blocking_non_blocking_queue.task3;

import com.walking.lesson72_blocking_non_blocking_queue.task3.model.Task;
import com.walking.lesson72_blocking_non_blocking_queue.task3.service.IntRandomGenerator;
import com.walking.lesson72_blocking_non_blocking_queue.task3.service.TaskService;

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
 *
 * @see com.walking.lesson72_blocking_non_blocking_queue.task1.Main
 */
public class Main {
    public static void main(String[] args) {
        var taskService = new TaskService();
        var randomGenerator = new IntRandomGenerator(1, 3);

        new Thread(getTaskSupplierLogic(taskService, randomGenerator))
                .start();
    }

    private static Runnable getTaskSupplierLogic(TaskService taskService, IntRandomGenerator randomGenerator) {
        return () -> {
            try {
                // Ограничение необязательно. Вполне можно было бы запустить бесконечный цикл
                for (int i = 0; i < 10; i++) {
                    taskService.add(new Task(randomGenerator.generate()));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}