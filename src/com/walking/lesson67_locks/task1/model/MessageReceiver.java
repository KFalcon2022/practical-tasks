package com.walking.lesson67_locks.task1.model;

public class MessageReceiver implements Runnable {
    private final MessageHolder messageHolder;
    private final String stopWord = "Finish";

    public MessageReceiver(MessageHolder messageHolder) {
        this.messageHolder = messageHolder;
    }

    @Override
    public void run() {
        boolean isFinished = false;

        while (!isFinished) {
            String message = messageHolder.receive();
            System.out.println("Message: " + message);

            isFinished = message.equals(stopWord);
        }
    }

}
