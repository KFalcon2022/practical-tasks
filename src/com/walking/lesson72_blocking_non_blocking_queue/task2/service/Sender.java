package com.walking.lesson72_blocking_non_blocking_queue.task2.service;

import java.util.Scanner;

public class Sender implements Runnable {
    private MessageService ms;
    private Scanner sc;

    public Sender(MessageService ms){
        this.ms=ms;
        this.sc=new Scanner(System.in);
    }

    public void run() {
        String message="";
        while (!message.equals("Finish")) {
            message=sc.nextLine();
            try {
                ms.send(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
