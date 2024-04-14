package com.walking.lesson32_files_1.task3.service;

import com.walking.lesson32_files_1.task3.model.Car;
import java.util.Arrays;

//считаем, что через CarService в Car[] запрещено добавлять дубликаты и null-объекты
//хотя массив в целом плохо подходит для задуманных операций

public class CarService {
    private Car[] originalCars;

    public CarService(Car[] originalCars) {
        this.originalCars = originalCars;
    }

    public Car[] getOriginalCars() {
        return originalCars;
    }

    public boolean add(Car target) {
        if (target == null) {
            return false;
        }

        if (originalCars == null) {
            originalCars = new Car[]{target};
            return true;
        }

        for (Car car : originalCars) {
            if (target.equals(car)) {
                return false;
            }
        }

        originalCars = Arrays.copyOf(originalCars, originalCars.length + 1);
        originalCars[originalCars.length - 1] = target;
        return true;
    }

    public void delete(Car target) {
        int foundCarIndex = findIndex(target);

        if (foundCarIndex != -1) {
            Car[] result = new Car[originalCars.length - 1];

            System.arraycopy(originalCars, 0, result, 0, foundCarIndex);

            int restIndex = foundCarIndex + 1;
            int rest = originalCars.length - restIndex;

            if (rest > 0) {
                System.arraycopy(originalCars, restIndex, result, foundCarIndex, rest);
            }

            originalCars = result;
        }
    }

    public Car find(Car target) {
        if (originalCars == null || target == null) {
            return null;
        }

        for (Car car : originalCars) {
            if(target.equals(car)) {
                return car;
            }
        }

        return null;
    }

    private int findIndex(Car target) {
        if (originalCars == null || target == null) {
            return -1;
        }

        for (int i = 0; i < originalCars.length; i++) {
            if (target.equals(originalCars[i])) {
                return i;
            }
        }

        return -1;
    }
}
