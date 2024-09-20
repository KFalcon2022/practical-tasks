package com.walking.lesson32_files_1.task3;


import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.repository.CarRepository;
import com.walking.lesson32_files_1.task3.service.CarService;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());
        CarRepository carRepository = new CarRepository();
        carRepository.saveCars(carService.getCars());

        carService.addCar(new Car("Test Mark", "Test Color", 2003, 333333));

        carService.updateCar(new Car("Test Mark", "Black", 2003, 333333));

        carService.deleteCar(new Car("BMW", "Синий", 2002, 674922));

        carRepository.saveCars(carService.getCars());

    }

    private static Car[] initCars() {
        return new Car[] {
                new Car("Audi", "Черный", 2001, 674921),
                new Car("BMW", "Синий", 2002, 674922),
                new Car("Renault", "Зеленый", 2003, 674923),
                new Car("Lada", "Крвсный", 2004, 674924),
                new Car("Volvo", "Серый", 2005, 674925),
                new Car("Ria", "Белый", 2006, 674926),
                new Car("Mazda", "Желтый", 2007, 674927),
                new Car("Suzuki", "Крвсный", 2008, 674928),
                new Car("Lada", "Синий", 2009, 674929),
        };
    }
}
