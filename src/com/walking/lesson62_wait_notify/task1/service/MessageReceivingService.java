package com.walking.lesson62_wait_notify.task1.service;

public class MessageReceivingService {
    private final MessageHolder messageHolder;

    public MessageReceivingService(MessageHolder messageHolder) {
        this.messageHolder = messageHolder;
    }

    public String receive() {
        synchronized (messageHolder) {
            while (messageHolder.isReceived() || messageHolder.getMessage() == null) {
                try {
                    messageHolder.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            String message = messageHolder.getMessage();
            System.out.printf("Received message: '%s'%n", message);

            messageHolder.setReceived();
            messageHolder.notifyAll();

            return message;
        }
    }
}
