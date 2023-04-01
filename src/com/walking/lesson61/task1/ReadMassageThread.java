package com.walking.lesson61.task1;

public class ReadMassageThread extends Thread {

    private final MassageService massageService;

    public ReadMassageThread(MassageService massageService) {
        this.massageService = massageService;
    }

    @Override
    public void run() {
        while(massageService.isRunning()) {
            massageService.readMassage();
        }
    }
}
