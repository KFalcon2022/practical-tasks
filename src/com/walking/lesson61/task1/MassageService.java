package com.walking.lesson61.task1;

import java.util.Scanner;

public class MassageService {

    private final String FINISH = "Finish";
    private boolean run = true;
    private boolean read = true;
    private String massage;
    private final Scanner scanner = new Scanner(System.in);

    public synchronized void printMassage() {

        while (read) {
            massageWait();
        }

        read = true;
        notifyAll();

        System.out.println(massage);
    }

    public synchronized void readMassage() {

        while (!read) {
            massageWait();
        }

        massage = scanner.nextLine();

        if (massage.equals(FINISH)) {
            run = false;
            notifyAll();
            Thread.currentThread().interrupt();
        }

        read = false;
        notifyAll();
    }

    public boolean isRunning() {
        return run;
    }

    private void massageWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread Interrupted");
            throw new RuntimeException();
        }
    }
}
