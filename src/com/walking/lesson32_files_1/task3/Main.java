package com.walking.lesson32_files_1.task3;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Audi","9834", 2017, "Black", true);
        CarRepository repository = new CarRepository();
        CarService carService = new CarService(initCars());
        carService.addCar(car1);
        repository.saveCars(carService.getCars());
        carService.remove(new Car("BMW", "8765",2007 , "grey", true));
repository.saveCars(carService.getCars());
repository.readFile();

    }

    private static Car[] initCars() {

        Car car1 = new Car("BMW", "8765",2007 , "grey", true);
        Car car2 = new Car("Toyota", "6532", 1994, "White", false);
        Car car3 = new Car("Toyota", "1278", 2024, "Black", true);

        return new Car[]{car1, car2, car3};
    }
}
