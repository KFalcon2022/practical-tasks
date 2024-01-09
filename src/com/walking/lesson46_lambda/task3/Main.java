package com.walking.lesson46_lambda.task3;


import com.walking.lesson38_comparing.task2.models.*;
import com.walking.lesson46_lambda.task3.exception.SearchFailedException;
import com.walking.lesson46_lambda.task3.model.RequestType;
import com.walking.lesson46_lambda.task3.service.CarService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Реализуйте Задачу из урока 21:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object">...</a>
 * с использованием списка (или другой коллекции на ваш выбор).
 * Дайте возможность искать машины по гибкому фильтру –
 * возвращайте коллекцию машин, подходящих под конкретный фильтр (можете расширить на свой вкус):
 * · Номер совпадает с введенным пользователем;
 * · Номер содержит подстроку, указанную пользователем;
 * · Цвет совпадает с указанным пользователем; (замена на название модели)
 * · Год выпуска машины находится в диапазоне, указанном пользователем. (замена на цифры номера находятся в диапазоне)
 * <p>
 * При этом CarService должен содержать лишь один публичный метод поиска.
 * Можете использовать Predicate или собственный функциональный интерфейс.
 * <p>
 * Также реализуйте интерактивное меню в рамках консоли,
 * позволяющее производить несколько поисков в рамках одного запуска программы.
 * Предусмотрите возможность завершения программы с помощью пользовательского ввода.
 */
public class Main {
    private static final HashSet<String> vinTable = new HashSet<>();
    public static void main(String[] args) {
        ArrayList<Car> cars = createCarsArray();
        Scanner scannerIn = new Scanner(System.in);
        runApp(scannerIn, cars);
        scannerIn.close();
    }
    private static String randomVin(){
        StringBuilder resultVin = new StringBuilder("ZFA");
        Random rnd = new Random();
        for (int i=0;i<14;i++){
            resultVin.append(rnd.nextInt(11));
        }
        if (vinTable.contains(resultVin.toString()))
            resultVin = new StringBuilder(randomVin());
        else vinTable.add(resultVin.toString());

        return resultVin.toString();
    }
    private static ArrayList<Car> createCarsArray(){
        ArrayList<Car> cars = new ArrayList<>();
        CarSpecification teslaX = new CarSpecification("Tesla","X",3.5, VehicleType.Sedan);
        CarSpecification rollceRoyceFantom = new CarSpecification("Rollce Royce","Fantom",5.0,VehicleType.Sedan);
        CarSpecification kiaCeed = new CarSpecification("KIA","Cee'd",9.5,VehicleType.Hatchback);
        cars.add(new Car(teslaX,randomVin(),"X117EN799"));
        cars.add(new Car(rollceRoyceFantom,randomVin(),"H726KT799"));
        cars.add(new Car(kiaCeed,randomVin(),"C111KK77"));
        cars.add(new Car(teslaX,randomVin(),"X117EN799"));

        return cars;
    }
    private static void runApp(Scanner scanner, ArrayList<Car> cars){
        int inputIndex=getSearchIndex(scanner);
        if (inputIndex==0) return;

        System.out.print("Enter text: ");
        scanner.nextLine();
        String text = scanner.nextLine();
        ArrayList<Car> searchedCars = new ArrayList<>();
        try{
            searchedCars=CarService.search(text, cars,inputIndex);
        }
        catch (SearchFailedException e){
            System.out.println(e.getMessage());
            runApp(scanner, cars);
        }

        System.out.println("\n");
        System.out.println("Search result: "+searchedCars.size()+"\n");
        searchedCars.forEach(System.out::println);

        runApp(scanner, cars);
    }
    private static int getSearchIndex(Scanner scanner){
        System.out.println("Please, choose the number of search:");
        for (RequestType element:RequestType.values()){
            System.out.printf("%d. %s\n",element.getIndex(),element);
        }
        System.out.print("\nEnter your choice: ");
        return scanner.nextInt();
    }
}
