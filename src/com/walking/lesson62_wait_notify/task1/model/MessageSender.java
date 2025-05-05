package com.walking.lesson62_wait_notify.task1.model;

import java.util.function.Supplier;

public class MessageSender implements Runnable {
    private final Message message;
    private final Supplier<String> stringSupplier;

    public MessageSender(Message message, Supplier<String> stringSupplier) {
        this.message = message;
        this.stringSupplier = stringSupplier;
    }

    @Override
    public void run() {
        while (!"finish".equalsIgnoreCase(message.getMessage())) {
            message.send(stringSupplier.get());
        }
    }
}
