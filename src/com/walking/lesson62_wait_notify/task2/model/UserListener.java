package com.walking.lesson62_wait_notify.task2.model;

import com.walking.lesson62_wait_notify.task2.util.Logger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class UserListener implements Runnable {
    private final Supplier<String> stringSupplier;
    private final List<Thread> threadList = new ArrayList<>();
    private final Logger logger;
    private final Depot depot;

    public UserListener(Supplier<String> stringSupplier, Logger logger, Depot depot) {
        this.stringSupplier = stringSupplier;
        this.logger = logger;
        this.depot = depot;
    }

    public void addThread(List<Thread> threads) {
        threadList.addAll(threads);
    }

    @Override
    public void run() {
        while (!Thread.currentThread()
                      .isInterrupted()) {
            try {
                Thread.sleep(Duration.ofSeconds(1));

                if ("finish".equalsIgnoreCase(stringSupplier.get())) {
                    break;
                }
                ;
            } catch (InterruptedException e) {
                Thread.currentThread()
                      .interrupt();
            }
        }

        logger.log("Завешение работы по запросу пользователя.");

        for (Thread thread : threadList) {
            logger.log("Поток %s остановлен".formatted(thread));
            thread.interrupt();
        }

        logger.log("Остаток товаров на складе - %d".formatted(depot.getStock()));
    }
}
