package com.walking.lesson19_object_methods;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        int carsCount = in.nextInt();
        in.nextLine();
        CarDB carDB = new CarDB(carsCount);
        for (Car car : carDB.getCarArray()) {
            System.out.println(car.gerCarInfo());
        }


        String searchData = in.nextLine();
        String carInfo = findCar(carDB, searchData);
        System.out.println(carInfo);

        in.close();
    }

    public static String findCar(CarDB carDB, String searchData) {
        String[] splitData = searchData.split(" ");
        Car result = carDB.carCheck(new Car(splitData[0], splitData[1], splitData[2]));
        if (result != null) return result.gerCarInfo();
        return "not found";
    }
}
