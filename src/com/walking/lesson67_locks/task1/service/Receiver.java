package com.walking.lesson67_locks.task1.service;

public class Receiver implements Runnable {
    private MessageService ms;

    public Receiver(MessageService ms){
        this.ms=ms;
    }

    public void run() {
        String message="";
        while (!message.equals("Finish")) {
            message=ms.receive();
        }
    }
    
}
