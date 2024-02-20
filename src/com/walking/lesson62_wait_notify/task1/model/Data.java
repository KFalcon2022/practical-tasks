package com.walking.lesson62_wait_notify.task1.model;

public class Data {
    private String message;
    private boolean isMessageSent;

    public synchronized void send(String message) {
        while (isMessageSent) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.message = message;
        System.out.println("\nMessage is sent!");
        isMessageSent = true;

        notifyAll();
    }

    public synchronized String receive() {
        while (isSendingReady()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        String returnMessage = message;
        System.out.println("\nMessage is received!");

        isMessageSent = false;
        notifyAll();

        return returnMessage;
    }

    public boolean isSendingReady() {
        return !isMessageSent || message == null;
    }
}
