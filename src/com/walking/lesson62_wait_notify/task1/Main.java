package com.walking.lesson62_wait_notify.task1;

import com.walking.lesson62_wait_notify.task1.service.MessageService;
import com.walking.lesson62_wait_notify.task1.service.Receiver;
import com.walking.lesson62_wait_notify.task1.service.Sender;

/**
 * Реализуйте имитацию отправки и получения сообщений.
 * Один поток должен принимать сообщение, введенное с клавиатуры,
 * другой поток должен выводить это сообщение в консоль.
 * Выполнение программы должно завершиться при вводе пользователем «Finish».
 */
public class Main {
    public static void main(String[] args) {
        MessageService ms=new MessageService(System.in, System.out);
        Thread sender=new Thread(new Sender(ms));
        Thread receiver=new Thread(new Receiver(ms));
        receiver.start();
        sender.start();
    }
}