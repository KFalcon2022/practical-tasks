package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson38_comparing.task2.models.Car;

public class SearchService {
    public static boolean isNumberMatchAll(Car car, String inText){
        return car.getPlateNumber().equals(inText);
    }
    public static boolean isNumberMatchSubstring(Car car, String inText){
        return car.getPlateNumber().contains(inText);
    }
    public static boolean isCarModelMatch(Car car, String inText){
        return car.getCarSpecification().getModelName().equals(inText);
    }
    public static boolean isNumberMatchBetween(Car car, String inText){
        int index=inText.indexOf('-');
        int start = Integer.parseInt(inText.substring(0,index));
        int end = Integer.parseInt(inText.substring(index+1));
        int numberDigits = Integer.parseInt(car.getPlateNumber().substring(1,4));
        return numberDigits>start&&numberDigits<end;
    }
}
