package com.walking.lesson72_blocking_non_blocking_queue.task2.service;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class MessageService {
    private TransferQueue<String> queue;

    public MessageService(){
        this.queue = new LinkedTransferQueue<String>();
    }

    public void send(String message) throws InterruptedException{
        queue.transfer(message);
    }

    public String receive() throws InterruptedException{
        return queue.take();
    }
}
