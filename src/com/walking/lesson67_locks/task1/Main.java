package com.walking.lesson67_locks.task1;

import com.walking.lesson67_locks.task1.service.MessageService;
import com.walking.lesson67_locks.task1.service.Receiver;
import com.walking.lesson67_locks.task1.service.Sender;

/**
 * Реализуйте
 * <a href="https://telegra.ph/Metody-Object-dlya-mnogopotochnosti-04-01#%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0-1:">Задачу 1 из урока 62 с использованием механизма Condition</a>
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