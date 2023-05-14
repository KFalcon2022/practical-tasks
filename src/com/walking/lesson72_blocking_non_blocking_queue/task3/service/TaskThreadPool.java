package com.walking.lesson72_blocking_non_blocking_queue.task3.service;

import com.walking.lesson72_blocking_non_blocking_queue.task3.model.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

// Имплементация Executor не обязательна (знакомство с ним в Уроке 74),
// но почему бы и нет?
public class TaskThreadPool implements Executor {
    private final BlockingQueue<Task> tasks = new LinkedBlockingQueue<>();

    private final Runnable threadLogic = () -> {
        try {
//            За счет бесконечного цикла программа не будет завершаться - потоки будут ожидать новых тасок.
//            Как решается данная проблема - рассмотрим в уроках, связанных с пулами потоков.
//            Спойлер: потоки-демоны (в ForkJoinPool) или Future
            while (true) {
                tasks.take().run();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    public TaskThreadPool() {
        IntStream.range(0, 4)
                .boxed()
                .map(i -> new Thread(threadLogic))
                .forEach(Thread::start);
    }


    @Override
    public void execute(Runnable command) {
//        Не обязательная валидация. Но если название пула содержит "Task" -
//        логично принимать именно таски.
//        Если убрать ограничение - стоит и очередь параметризовать Runnable
        if (!(command instanceof Task)) {
            throw new RuntimeException(
                    "Incorrect task subtype: %s".formatted(command.getClass().getSimpleName()));
        }

        try {
            tasks.put((Task) command);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
