package com.walking.lesson67_locks.task1;

import com.walking.lesson67_locks.task1.model.MessageHolder;
import com.walking.lesson67_locks.task1.model.MessageReceiver;
import com.walking.lesson67_locks.task1.model.MessageSender;

/**
 * Реализуйте
 * <a href="https://telegra.ph/Metody-Object-dlya-mnogopotochnosti-04-01#%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0-1:">Задачу 1 из урока 62 с использованием механизма Condition</a>
 */
public class Main {
    public static void main(String[] args) {
        MessageHolder messageHolder = new MessageHolder();
        MessageReceiver messageReceiver = new MessageReceiver(messageHolder);
        MessageSender messageSender = new MessageSender(messageHolder);

        Thread senderThread = new Thread(messageSender);
        Thread receiverThread = new Thread(messageReceiver);

        receiverThread.start();
        senderThread.start();
    }
}