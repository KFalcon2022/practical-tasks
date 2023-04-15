package com.walking.lesson62_wait_notify.task1.service;

// В контексте пересылки одного сообщения класс получается упрощенным.
// Будем считать, что его задача - хранить текущее сообщение и статус "Получено/Не получено".
// Вызов сеттера будет расцениваться как сброс "полученности" сообщения - ведь новое сообщение не получено
public class MessageHolder {
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
}
