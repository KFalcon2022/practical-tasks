package com.walking.lesson72_blocking_non_blocking_queue.task2;

import com.walking.lesson72_blocking_non_blocking_queue.task2.service.MessageReceivingService;
import com.walking.lesson72_blocking_non_blocking_queue.task2.service.MessageSendingService;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Реализуйте Задачу 1 из урока 62 без использования wait() и notify()/notifyAll().
 *
 * @see com.walking.lesson62_wait_notify.task1.Main
 */
public class Main {
    public static final String FINISH_MESSAGE = "Finish";

    public static void main(String[] args) throws InterruptedException {
        var messageHolder = new SynchronousQueue<String>();
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
//                Задача направлена на использование SynchronousQueue.
//                С ней у нас нет возможности проверить, доступен ли ввод
//                и не выводить сообщение ниже преждевременно, потому что isEmpty() этой очереди всегда true.
//                Мы могли бы добавить обертку над ней, в которой сделать флаг прочтения сообщения
//                или использовать другую блокирующую очередь с работающим isEmpty(), но это неинтересно
                System.out.println("Enter message:");
                var message = scanner.nextLine();

                try {
                    messageTransferService.send(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                isFinished = FINISH_MESSAGE.equals(message);
            }
        };
    }

    private static Runnable getReceiverLogic(MessageReceivingService receivingService) {
        return () -> {
            boolean isFinished = false;
            while (!isFinished) {
                String message;

                try {
                    message = receivingService.receive();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                isFinished = FINISH_MESSAGE.equals(message);
            }
        };
    }
}