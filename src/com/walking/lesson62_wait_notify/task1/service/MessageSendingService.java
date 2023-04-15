package com.walking.lesson62_wait_notify.task1.service;

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
        synchronized (messageHolder) {
            while (!messageHolder.isReceived()) {
                try {
                    messageHolder.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            messageHolder.setMessage(message);
            messageHolder.notifyAll();
        }
    }

}
