package com.walking.lesson61.task1;

public class Main {
    public static void main(String[] args) {

        MassageService massageService = new MassageService();

        PrintMassageThread printMassageThread = new PrintMassageThread(massageService);
        ReadMassageThread readMassageThread = new ReadMassageThread(massageService);

        readMassageThread.start();
        printMassageThread.start();

    }
}
