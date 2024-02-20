package com.walking.lesson62_wait_notify.task1.model;

import com.walking.lesson62_wait_notify.task1.service.MessageService;

public class Sender implements Runnable {
    private final Data data;
    private final MessageService messageService = new MessageService();
    private final String stopWord = "Finish";

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        boolean isFinished = false;

        while (!isFinished) {
            if (!data.isSendingReady()) {
                continue;
            }

            String message = messageService.getInputMessage();
            data.send(message);

            isFinished = message.equals(stopWord);
        }
        messageService.close();
    }
}
