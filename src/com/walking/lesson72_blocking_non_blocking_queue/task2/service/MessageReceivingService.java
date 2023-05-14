package com.walking.lesson72_blocking_non_blocking_queue.task2.service;

import java.util.concurrent.BlockingQueue;

public class MessageReceivingService {
    private final BlockingQueue<String> messageHolder;

    public MessageReceivingService(BlockingQueue<String> messageHolder) {
        this.messageHolder = messageHolder;
    }

    public String receive() throws InterruptedException {
        String message = messageHolder.take();
        System.out.printf("Received message: '%s'%n", message);

        return message;
    }
}
