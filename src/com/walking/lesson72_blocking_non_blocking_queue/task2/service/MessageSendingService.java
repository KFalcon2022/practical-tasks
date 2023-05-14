package com.walking.lesson72_blocking_non_blocking_queue.task2.service;

import java.util.concurrent.BlockingQueue;

public class MessageSendingService {
    private final BlockingQueue<String> messageHolder;

    public MessageSendingService(BlockingQueue<String> messageHolder) {
        this.messageHolder = messageHolder;
    }

    public void send(String message) throws InterruptedException {
        messageHolder.put(message);
    }

}
