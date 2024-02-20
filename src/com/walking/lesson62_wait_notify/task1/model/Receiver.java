package com.walking.lesson62_wait_notify.task1.model;

public class Receiver implements Runnable {
    private final Data data;
    private final String stopWord = "Finish";

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        boolean isFinished = false;

        while (!isFinished){
            String receivedMessage = data.receive();
            isFinished = receivedMessage.equals(stopWord);

            System.out.println("\n" + receivedMessage);
        }
    }
}
