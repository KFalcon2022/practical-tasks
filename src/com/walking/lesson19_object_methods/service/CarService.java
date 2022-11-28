package com.walking.lesson19_object_methods.service;

import com.walking.lesson19_object_methods.model.Car;

public class CarService {
    private final Car[] cars;

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car findCar(Car car) {
//        Алгоритм поиска может быть более продвинутым по вашему желанию.
//        В рамках задачи для нас главное научиться использованию методов Object, поэтому здесь максимально
//        простая реализация алгоритма - перебор неотсортированного массива
        for (Car c : cars) {
//            Учитывая, что хэшкоды рассчитаны заранее, проверить их быстрее, чем сравнить по equals.
//            При этом если хэшкоды не равны - объекты точно не будут равны по equals() исходя из
//            контракта equals() и hashcode()
            if (c.hashCode() == car.hashCode() && c.equals(car)) {
                return c;
            }
        }

        return null;
    }
}
