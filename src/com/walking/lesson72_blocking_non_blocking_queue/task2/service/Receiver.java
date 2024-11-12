package com.walking.lesson72_blocking_non_blocking_queue.task2.service;

public class Receiver implements Runnable {
    private MessageService ms;

    public Receiver(MessageService ms){
        this.ms=ms;
    }

    public void run() {
        String message="";
        while (!message.equals("Finish")) {
            try {
                message=ms.receive();
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
