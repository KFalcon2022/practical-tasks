package com.walking.lesson62_wait_notify.task1;

import com.walking.lesson62_wait_notify.task1.model.Message;
import com.walking.lesson62_wait_notify.task1.model.MessageReceiver;
import com.walking.lesson62_wait_notify.task1.model.MessageSender;

import java.util.Scanner;

/**
 * Реализуйте имитацию отправки и получения сообщений.
 * Один поток должен принимать сообщение, введенное с клавиатуры,
 * другой поток должен выводить это сообщение в консоль.
 * Выполнение программы должно завершиться при вводе пользователем «Finish».
 */
public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        Scanner scanner = new Scanner(System.in);
        Thread sender = new Thread(new MessageSender(message, scanner::nextLine), "messageSender");
        Thread receiver = new Thread(new MessageReceiver(message, System.out::println));

        System.out.println("Вводите сообщения для отправки. Для завершения работы введите \"finish\".");

        sender.start();
        receiver.start();
    }
}