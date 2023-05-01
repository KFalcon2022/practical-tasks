package com.walking.lesson67_locks.task1.service;

public class MessageReceivingService {
    private final MessageHolder messageHolder;

    public MessageReceivingService(MessageHolder messageHolder) {
        this.messageHolder = messageHolder;
    }

    public String receive() {
        try {
            messageHolder.getLock().lock();

            while (messageHolder.isReceived() || messageHolder.getMessage() == null) {
                messageHolder.getCondition().await();
            }

            String message = messageHolder.getMessage();
            System.out.printf("Received message: '%s'%n", message);

            messageHolder.setReceived();
            messageHolder.getCondition().signalAll();

            return message;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            messageHolder.getLock().unlock();
        }
    }
}
