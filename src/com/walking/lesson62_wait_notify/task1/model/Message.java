package com.walking.lesson62_wait_notify.task1.model;

public class Message {
    private String message;
    private boolean isReceived = false;

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public synchronized String receive() {
        while (!isReceived) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread()
                      .interrupt();
            }
        }

        isReceived = false;
        String receivedMessage = message;

        notifyAll();

        return receivedMessage;
    }

    public synchronized void send(String message) {
        while (isReceived) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread()
                      .interrupt();
            }
        }

        this.message = message;
        isReceived = true;

        notifyAll();
    }
}
