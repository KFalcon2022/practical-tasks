package com.walking.lesson67_locks.task1.service;

public class MessageSendingService {
    private final MessageHolder messageHolder;

    public MessageSendingService(MessageHolder messageHolder) {
        this.messageHolder = messageHolder;
    }

    // Чтобы не возникало ситуаций, когда поток пытается начать логику отправки нового сообщения
    // (например, запрашивает его с клавиатуры) до того, как прочитано старое
    public boolean isSendingReady() {
        return messageHolder.isReceived() || messageHolder.getMessage() == null;
    }

    public void send(String message) {
        try {
            messageHolder.getLock().lock();

            while (!messageHolder.isReceived()) {
                messageHolder.getCondition().await();
            }

            messageHolder.setMessage(message);
            messageHolder.getCondition().signalAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            messageHolder.getLock().unlock();
        }
    }

}
