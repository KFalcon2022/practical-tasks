package com.walking.lesson62_wait_notify.task1;

import com.walking.lesson62_wait_notify.task1.service.MessageHolder;
import com.walking.lesson62_wait_notify.task1.service.MessageReceivingService;
import com.walking.lesson62_wait_notify.task1.service.MessageSendingService;

import java.util.Scanner;

/**
 * Реализуйте имитацию отправки и получения сообщений.
 * Один поток должен принимать сообщение, введенное с клавиатуры,
 * другой поток должен выводить это сообщение в консоль.
 * Выполнение программы должно завершиться при вводе пользователем «Finish».
 */
public class Main {
    public static final String FINISH_MESSAGE = "Finish";

    public static void main(String[] args) throws InterruptedException {
        var messageHolder = new MessageHolder();
        var messageSendingService = new MessageSendingService(messageHolder);
        var messageReceivingService = new MessageReceivingService(messageHolder);

        var scanner = new Scanner(System.in);

        var senderLogic = getSenderLogic(messageSendingService, scanner);
        var senderThread = new Thread(senderLogic);
        senderThread.start();

        var receiverLogic = getReceiverLogic(messageReceivingService);
        var receiverThread = new Thread(receiverLogic);
        receiverThread.start();

        senderThread.join();
        receiverThread.join();
        scanner.close();
    }

    //    Для удобства чтения, логика потоков отправителя и получателя оставлена в Main
    private static Runnable getSenderLogic(MessageSendingService messageTransferService, Scanner scanner) {
        return () -> {
            boolean isFinished = false;
            while (!isFinished) {
                if (!messageTransferService.isSendingReady()) {
                    continue;
                }

                System.out.println("Enter message:");
                var message = scanner.nextLine();
                messageTransferService.send(message);

                isFinished = FINISH_MESSAGE.equals(message);
            }
        };
    }

    private static Runnable getReceiverLogic(MessageReceivingService receivingService) {
        return () -> {
            boolean isFinished = false;
            while (!isFinished) {
                var message = receivingService.receive();

                isFinished = FINISH_MESSAGE.equals(message);
            }
        };
    }
}