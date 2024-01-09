package com.walking.lesson46_lambda.task3.service;


import com.walking.lesson38_comparing.task2.models.Car;
import com.walking.lesson46_lambda.task3.exception.SearchFailedException;
import com.walking.lesson46_lambda.task3.interfaces.CarSearchFilter;
import com.walking.lesson46_lambda.task3.model.RequestType;

import java.util.ArrayList;


public class CarService {
    private static String inText;
    private static ArrayList<Car> cars;

    public static ArrayList<Car> search(String inputText, ArrayList<Car> inputCars, int inputChoice){
        inText=inputText;
        cars=inputCars;
        RequestType requestType = RequestType.getValue(inputChoice);

        switch (requestType){
            case SEARCH_BY_CAR_MODEL -> {
                return fillList(SearchService::isCarModelMatch);
            }
            case SEARCH_BY_NUMBER_ALL -> {
                return fillList(SearchService::isNumberMatchAll);
            }
            case SEARCH_BY_NUMBER_BETWEEN -> {
                return fillList(SearchService::isNumberMatchBetween);
            }
            case SEARCH_BY_NUMBER_SUBSTRING -> {
                return fillList(SearchService::isNumberMatchSubstring);
            }
        }
        throw new SearchFailedException("Input value: "+ requestType);
    }
    private static ArrayList<Car> fillList (CarSearchFilter filter){
        ArrayList<Car> tempArray=new ArrayList<>();
        cars.forEach(car-> {
            if (filter.filter(car, inText)) tempArray.add(car);
        });
        if (tempArray.isEmpty()) throw new SearchFailedException(inText);

        return tempArray;
    }
}
