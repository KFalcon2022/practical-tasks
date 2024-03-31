package com.walking.lesson67_locks.task1.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageHolder {
    private final Lock locker;
    private final Condition isSentCondition;
    private final Condition isReceivedCondition;

    private String message;
    private boolean isMessageSent;

    public MessageHolder() {
        this.locker = new ReentrantLock();
        this.isSentCondition = locker.newCondition();
        this.isReceivedCondition = locker.newCondition();
    }

    public void send(String message) {
        try {
            locker.lock();

            while (isMessageSent) {
                isSentCondition.await();
            }
            this.message = message;
            System.out.println("Message received!");
            isMessageSent = true;
            isReceivedCondition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }

    public String receive() {
        try {
            locker.lock();

            while (!isMessageSent || message == null) {
                isReceivedCondition.await();
            }
            isMessageSent = false;
            isSentCondition.signalAll();
            return message;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }

    public boolean isSendingReady() {
        return !isMessageSent || message == null;
    }
}
