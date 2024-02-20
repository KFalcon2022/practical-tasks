package com.walking.lesson62_wait_notify.task1;

import com.walking.lesson62_wait_notify.task1.model.Data;
import com.walking.lesson62_wait_notify.task1.model.Receiver;
import com.walking.lesson62_wait_notify.task1.model.Sender;

/**
 * Реализуйте имитацию отправки и получения сообщений.
 * Один поток должен принимать сообщение, введенное с клавиатуры,
 * другой поток должен выводить это сообщение в консоль.
 * Выполнение программы должно завершиться при вводе пользователем «Finish».
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();

        Thread senderThread = new Thread(new Sender(data));
        Thread receiverThread = new Thread(new Receiver(data));

        senderThread.start();
        receiverThread.start();

        senderThread.join();
        receiverThread.join();



    }
}