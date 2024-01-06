package com.walking.lesson46_lambda.task3.interfaces;

import com.walking.lesson38_comparing.task2.models.Car;

public interface CarSearchFilter {
    boolean filter(Car car, String inText);
}
