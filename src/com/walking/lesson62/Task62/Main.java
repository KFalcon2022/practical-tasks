package com.walking.lesson62.Task62;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Chat chat = new Chat();
        Thread t1 = new Thread(new Sender(chat));
        Thread t2 = new Thread(new Receiver(chat));
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {

        }
    }
}

class Sender implements Runnable {
    private Chat chat;

    public Sender(Chat chat) {
        this.chat = chat;
    }

    public void run() {
        while (chat.isRunning()) {
            chat.send();
        }
        System.out.println("sender closed");
    }
}

class Receiver implements Runnable {
    private Chat chat;

    public Receiver(Chat chat) {
        this.chat = chat;
    }

    public void run() {
        while (chat.isRunning()) {
            chat.receive();
        }
        System.out.println("receiver closed");
    }
}

class Chat {
    private boolean running;
    public List<String> messages;
    private final Scanner SCANNER = new Scanner(System.in);
    private final String EXIT_MSG = "Finish!";

    public Chat() {
        this.messages = new LinkedList<>();
        this.running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }

    public void stop() {
        running = false;
    }

    public String pick() {
        if (isEmpty()) {
            return null;
        }
        return messages.remove(0);
    }

    synchronized public void send() {
        while (!isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (isRunning()) {
            messages.add(SCANNER.nextLine());
        }
        notifyAll();
    }

    synchronized public void receive() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        String message = pick();
        System.out.println("message received: '%s'".formatted(message));
        if (message.equals(EXIT_MSG)) {
            stop();
        } else {

        }
        notifyAll();
    }
}