package com.walking.lesson67_locks.task1.model;

import com.walking.lesson67_locks.task1.service.MessageService;

public class MessageSender implements Runnable {
    private final MessageHolder messageHolder;
    private final MessageService messageService;
    private final String stopWord = "Finish";

    public MessageSender(MessageHolder messageHolder) {
        this.messageHolder = messageHolder;
        messageService = new MessageService();
    }

    @Override
    public void run() {
        boolean isFinished = false;

        while (!isFinished) {
            if (!messageHolder.isSendingReady()) {
                continue;
            }

            //Для вывода сообщения до запроса нового
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String message = messageService.getInput();
            messageHolder.send(message);

            isFinished = message.equals(stopWord);
        }
        messageService.close();
    }
}
