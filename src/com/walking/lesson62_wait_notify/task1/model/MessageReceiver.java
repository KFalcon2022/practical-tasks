package com.walking.lesson62_wait_notify.task1.model;

import java.util.function.Consumer;

public class MessageReceiver implements Runnable {
    private final Message message;
    private final Consumer<String> stringConsumer;

    public MessageReceiver(Message message, Consumer<String> stringConsumer) {
        this.message = message;
        this.stringConsumer = stringConsumer;
    }

    @Override
    public void run() {
        String receivedMessage = message.receive();

        while (!"finish".equalsIgnoreCase(receivedMessage)) {
            stringConsumer.accept(receivedMessage);

            receivedMessage = message.receive();
        }
    }
}
