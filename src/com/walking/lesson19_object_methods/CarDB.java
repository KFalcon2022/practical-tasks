package com.walking.lesson19_object_methods;

import java.util.Random;

public class CarDB {
    private Car[] carArray;
    private final int carCount;
    private Random random = new Random();

    CarDB(int carCount) {
        this.carCount = carCount;
        generate();
    }

    private void generate(){
        carArray = new Car[carCount];
        Car car;

        String carColor;
        String engineNumber;
        String regNumber;
        String mileage;
        int i = 0;
        while (i < carCount) {
            carColor = makeColor();
            engineNumber = makeEngineNumber();
            regNumber = makeRegNumber();
            mileage = makeMileage();
            car = new Car(regNumber, engineNumber, carColor, mileage);
            if (carCheck(car) == null) {
                carArray[i] = car;
                i++;
            }
        }

    }

    private String makeColor(){
        int randInt = random.nextInt();
        int colorID = randInt >= 0 ? randInt % Colors.values().length : -1 * randInt % Colors.values().length;
        return Colors.getNameViaID(colorID);
    }

    private String makeRegNumber(){
        String result = "";
        result += getRandomLetter();
        result += getRandomLetter();
        result += getRandomNumber();
        result += getRandomNumber();
        result += getRandomNumber();
        result += getRandomLetter();
        return result;
    }

    private String makeEngineNumber(){
        String result = "";
        for (int i = 0; i < 10; i++) {
            result += getRandomNumber();
        }
        return result;
    }

    private String makeMileage(){
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += getRandomNumber();
        }
        return result;
    }

    private char getRandomLetter(){
        int randInt = random.nextInt();
        int charID = randInt >= 0 ? randInt % 26 + 65 : -1 * randInt % 26 + 65;
        return (char)(charID);
    }

    private char getRandomNumber(){
        int randInt = random.nextInt();
        int charID = randInt >= 0 ? randInt % 10 + 48 : -1 * randInt % 10 + 48;
        return (char)(charID);
    }

    public Car[] getCarArray(){
        return carArray;
    }

    public Car carCheck(Car c) {
        for (Car car : carArray) {
            if (car == null) return null;
            if (car.hashCode() == c.hashCode()) {
                if (car.equals(c)) {
                    return car;
                }
            }
        }
        return null;
    }
}
