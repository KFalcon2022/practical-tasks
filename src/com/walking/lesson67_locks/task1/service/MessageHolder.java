package com.walking.lesson67_locks.task1.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// В контексте пересылки одного сообщения класс получается упрощенным.
// Будем считать, что его задача - хранить текущее сообщение и статус "Получено/Не получено".
// Вызов сеттера будет расцениваться как сброс "полученности" сообщения - ведь новое сообщение не получено
public class MessageHolder {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private String message;
    private boolean received = true;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        this.received = false;
    }

    public boolean isReceived() {
        return received;
    }

    //    Сеттер без параметра. В ручном режиме ожидаем только установку статуса "Прочитано".
    public void setReceived() {
        this.received = true;
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }
}
