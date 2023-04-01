package com.walking.lesson62.Task1;

import java.util.HashMap;

public class CarPark {
    private HashMap<Integer, Car> data;

    public CarPark(){
        this.data = new HashMap<>();
    }

    public void registerCar(int number, String processName){
        synchronized (data) {
            if (data.containsKey(number)) {
                System.out.println("<%s> [register] Car № %d already registered".formatted(processName, number));
                return;
            }
            data.put(number, new Car(number, processName));
            System.out.println("<%s> [register] Car № %d has been registered".formatted(processName, number));
        }
    }

    public void removeCar(int number, String processName){
        synchronized (data){
            if (!data.containsKey(number)) {
                System.out.println("<%s> [remove] Car № %d is not registered".formatted(processName, number));
                return;
            }
            data.remove(number);
            System.out.println("<%s> [remove] Car № %d has been unregistered".formatted(processName, number));
        }
    }

    public void updateCar(int number, int newNumber, String processName){
        synchronized (data){
            if (!data.containsKey(number)) {
                System.out.println("<%s> [update] Car № %d is not registered".formatted(processName, number));
                return;
            }
            Car car = data.get(number);
            car.setNumber(newNumber);
            car.updateOperator(processName);
            System.out.println("<%s> [update] Car № %d has been updated updated with new number %d".formatted(processName, number, newNumber));
        }
    }

    public void explainPark(){
        synchronized (data) {
            System.out.println("---------------------");
            data.values()
                    .stream()
                    .forEach(System.out::println);
            System.out.println("---------------------");
        }
    }
}
