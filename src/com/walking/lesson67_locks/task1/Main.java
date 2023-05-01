package com.walking.lesson67_locks.task1;

import com.walking.lesson67_locks.task1.service.MessageHolder;
import com.walking.lesson67_locks.task1.service.MessageReceivingService;
import com.walking.lesson67_locks.task1.service.MessageSendingService;

import java.util.Scanner;

/**
 * Реализуйте
 * <a href="https://telegra.ph/Metody-Object-dlya-mnogopotochnosti-04-01#%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0-1:">Задачу 1 из урока 62 с использованием механизма Condition</a>
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