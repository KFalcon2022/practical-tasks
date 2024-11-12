package com.walking.lesson72_blocking_non_blocking_queue.task2;

import com.walking.lesson72_blocking_non_blocking_queue.task2.service.MessageService;
import com.walking.lesson72_blocking_non_blocking_queue.task2.service.Receiver;
import com.walking.lesson72_blocking_non_blocking_queue.task2.service.Sender;

/**
 * Реализуйте Задачу 1 из урока 62 без использования wait() и notify()/notifyAll().
 * @see com.walking.lesson62_wait_notify.task1.Main
 */
/**
 * Реализуйте имитацию отправки и получения сообщений.
 * Один поток должен принимать сообщение, введенное с клавиатуры,
 * другой поток должен выводить это сообщение в консоль.
 * Выполнение программы должно завершиться при вводе пользователем «Finish».
 */
public class Main {
    public static void main(String[] args) {
        MessageService ms=new MessageService();
        Thread sender=new Thread(new Sender(ms));
        Thread receiver=new Thread(new Receiver(ms));
        receiver.start();
        sender.start();
    }
}