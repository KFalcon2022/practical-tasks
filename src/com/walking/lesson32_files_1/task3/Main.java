package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task3.model.Car;
import com.walking.lesson32_files_1.task3.service.CarRepository;

/**
 * Реализуйте возможность добавления, удаления и изменения информации о машинах,
 * используя Задачи 1 и 2.
 * Работу с файлом предлагаю вынести в класс CarRepository,
 * но вы можете сделать иную реализацию на свое усмотрение.
 */
public class Main {
    public static final String CAR_CATALOG_TXT_DIRECTORY = "./resource/files/lesson32_files_1/task3/carCatalog.txt";

    public static void main(String[] args) {
        Car[] cars = initCars();

        CarRepository carCatalogWriter = new CarRepository(CAR_CATALOG_TXT_DIRECTORY);
        carCatalogWriter.writeCarCatalog(cars);


        Car newCar = new Car("FFFF", 1995, "green");
        CarRepository addNewCar = new CarRepository(CAR_CATALOG_TXT_DIRECTORY);
        addNewCar.addNewCar(newCar);


        CarRepository changeCarInformation = new CarRepository(CAR_CATALOG_TXT_DIRECTORY);
        changeCarInformation.changeCar(new Car("RR-666-RR",2018, "yellow")
                ,new Car("FF-777-FF", 2018, "green"));

        CarRepository carCatalogReader = new CarRepository(CAR_CATALOG_TXT_DIRECTORY);
        String carsDatabase = carCatalogReader.readCarCatalog();
        System.out.println(carsDatabase);
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow");
        Car car2 = new Car("RR-222-RR", 2016, "yellow");
        Car car4 = new Car("RR-444-RR", 2018, "yellow");
        Car car5 = new Car("RR-555-RR", 2018, "yellow");
        Car car6 = new Car("RR-666-RR", 2018, "yellow");
        Car car7 = new Car("RR-777-RR", 2018, "yellow");
        Car car3 = new Car("RR-333-RR", 2017, "yellow");
        Car car8 = new Car("RR-888-RR", 2018, "yellow");
        Car car9 = new Car("RR-999-RR", 2018, "yellow");
        Car car10 = new Car("RR-000-RR", 2018, "yellow");

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
