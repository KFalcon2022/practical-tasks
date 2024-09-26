package com.walking.lesson47_method_reference.task_3;

/*
 * Реализуйте Задачу 3 из урока 46 (),
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис, если это не было сделано ранее.
 */

import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final CarService CAR_SERVICE = new CarService(getMockCars());
    private static final FilterService FILTER_SERVICE = new FilterService();

    public static void main(String[] args) {
        System.out.println("\t===== Let's go find a car =====");
        loop();
        System.out.println("\t===== Good bye =====");
    }

    private static Car[] getMockCars() {
        return new Car[]{
                new Car("Honda", "Civic", 2008, 56456456),
                new Car("Toyota", "Hilux", 2017, 248466145),
                new Car("Ford", "F-150", 2010, 44564361),
                new Car("Volkswagen", "Golf", 2000, 44187896),
                new Car("Chevrolet", "Impala", 1980, 56456456)
        };
    }

    private static void loop() {
        boolean isExecuting = true;

        while (isExecuting) {
            printTokensInfo();
            String token = getInput(" token");

            if (token.equalsIgnoreCase("q")) {
                isExecuting = false;
                continue;
            }

            Filter filter = FILTER_SERVICE.getAll().get(token);
            if (filter == null) {
                System.out.println("Wrong token! Try again\n");
                continue;
            }

            printPromptInfo(token);
            String target = getInput("target");
            // some logic of validate correct input (e.g. add regex field to the Filter-class and comparing it)

            System.out.println("\t===== Found this =====");
            CAR_SERVICE.findCars(filter, target).forEach(System.out::println);
            System.out.println("\t======================");
        }
    }

    private static String getInput(String msg) {
        System.out.printf("[%s] <== ", msg);
        return SC.nextLine();
    }

    private static void printPromptInfo(String token) {
        System.out.printf("Input %s as <%s>%n",
                FILTER_SERVICE.getAll().get(token).info(),
                FILTER_SERVICE.getAll().get(token).prompt()
        );
    }

    private static void printTokensInfo() {
        System.out.println("Input type of search as one of:");
        FILTER_SERVICE.getAll().forEach((t, f) -> System.out.printf("[%s] - %s%n", t, f.info()));
        System.out.println("or\n[q] - for quit search");
    }
}
