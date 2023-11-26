package com.walking.lesson61.task1;

public class PrintMassageThread extends Thread {
    private final MassageService massageService;

    public PrintMassageThread(MassageService massageService) {
        this.massageService = massageService;
    }

    @Override
    public void run() {
        while (massageService.isRunning()) {
            massageService.printMassage();
        }
    }
}
