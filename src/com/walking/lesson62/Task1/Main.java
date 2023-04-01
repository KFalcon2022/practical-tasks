package com.walking.lesson62.Task1;

import java.time.Duration;
import java.util.Random;

public class Main {
    public static final int THREADS = 15;
    public static final int CARS = 15;

    public static void main(String[] args) {
        CarPark park = new CarPark();

        for (int pid = 0; pid < THREADS; pid++) {

            Thread parkThread = new Thread(() -> {
                try {
                    String threadName = Thread.currentThread().getName();
                    for (int i = 0; i < CARS; i++) {
                        int randomNumber = new Random().nextInt(CARS);
                        int randomOperation = new Random().nextInt(3);

                        switch (randomOperation) {
                            case 0:
                                park.registerCar(randomNumber, threadName);
                                break;

                            case 1:
                                park.removeCar(randomNumber, threadName);
                                break;

                            case 2:
                                int randomUpdatedNumber = new Random().nextInt(CARS);
                                park.updateCar(randomNumber, randomUpdatedNumber, threadName);
                                break;
                        }

                        Thread.currentThread().sleep(5);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread error");
                }
            }, "Thread " + pid);

            parkThread.start();
        }

        try {
            for (int i = 0; i < 3; i++) {
                // До кучи должно трижды вывести листинг текущего парка машин посреди потоков всё ещё работающих с ним
                Thread.sleep(Duration.ofMillis(30));
                park.explainPark();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread error");
        }
    }
}
