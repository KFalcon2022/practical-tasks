package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.model.Car;

import java.util.Map;

public class CarService {
    private final Map<String, Car> carMap;

    public CarService(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    public Car findCar(Car car) {
//        Алгоритм поиска может быть более продвинутым по вашему желанию.
//        В рамках задачи для нас главное научиться использованию методов Object, поэтому здесь максимально
//        простая реализация алгоритма - перебор неотсортированного массива
        for (Map.Entry<String, Car> map: carMap.entrySet()) {
//            Учитывая, что хэшкоды рассчитаны заранее, проверить их быстрее, чем сравнить по equals.
//            При этом если хэшкоды не равны - объекты точно не будут равны по equals() исходя из
//            контракта equals() и hashcode()
            if (map.getValue().hashCode() == car.hashCode() && map.getValue().equals(car)) {
                return map.getValue();
            }
        }

        return null;
    }
}
