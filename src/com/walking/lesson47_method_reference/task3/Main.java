package com.walking.lesson47_method_reference.task3;

import com.walking.lesson47_method_reference.task3.exception.UnableParsingException;
import com.walking.lesson47_method_reference.task3.model.CarFilter;
import com.walking.lesson47_method_reference.task3.service.CarService;
import com.walking.lesson47_method_reference.task3.service.CarFilterService;
import com.walking.lesson47_method_reference.task3.model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализуйте Задачу 3 из урока 46,
 * описав все реализуемые фильтры через method reference’ы.
 * Рекомендую вынести функциональность формирования фильтров в отдельный сервис,
 * если это не было сделано ранее.
 */
public class Main {
    private static final String COMMAND_OVERVIEW = """
            Для выхода введите exit.
            Для поиска введите search <название_фильтра> <значение_фильтра>.
            -----------------------
            Поддерживаемые фильтры:
            - color <цвет машины> (пример запроса: search color yellow);
            - number <номер машины> (пример запроса: search number RR-111-RR);
            - partOfNumber <часть номера машины> (пример запроса: search partOfNumber 111);
            - yearRange <диапазон годов выпуска> (пример запроса: search yearRange 2015-2016);
            -----------------------
            Допускается использование нескольких фильтров в одном запросе в форме:
            search <название_фильтра1> <значение_фильтра1> ... <название_фильтраN> <значение_фильтраN>;
            Например:
            search color yellow partOfNumber 111 yearRange 2015-2016
            -----------------------
            Введите запрос:
            """;

    public static void main(String[] args) {
        CarService carService = new CarService(initCars());

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isTerminateAfterExecute = false;

            while (!isTerminateAfterExecute) {
                System.out.println(COMMAND_OVERVIEW);
                String input = bufferedReader.readLine();
                String[] arguments = input.split("\\s");

                isTerminateAfterExecute = executeCommand(arguments, carService);
            }

        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    private static boolean executeCommand(String[] arguments, CarService carService) {
        String commandName = arguments[0];

        return switch (commandName) {
            case "exit" -> true;

            case "search" -> {
                if (!isValidArguments(arguments)) {
                    System.out.println("Введено неверное кол-во аргументов");
                } else {
                    String[] filters = Arrays.copyOfRange(arguments, 1, arguments.length);
                    List<CarFilter> carFilters = parseFilters(filters);
                    CarFilterService carFilterService = new CarFilterService(carFilters);
                    List<Car> foundCars = carService.findBy(carFilterService::isSuitAll);
                    printSearchResult(foundCars);
                }

                yield false;
            }

            default -> {
                System.out.println("Неизвестная команда. Работа будет завершена.");

                yield true;
            }
        };
    }

    private static List<Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "red", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "red", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "red", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "red", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "red", true);

        return List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);
    }

    private static boolean isValidArguments(String[] arguments) {
        return arguments.length >= 3 && arguments.length % 2 != 0;
    }

    private static List<CarFilter> parseFilters(String[] namesAndValues) {
        List<CarFilter> carFilters = new ArrayList<>(namesAndValues.length / 2);

        for (int i = 0; i < namesAndValues.length; i++) {
            String filterName = namesAndValues[i];
            String filterValue = namesAndValues[++i];

            if (filterName.equals("yearRange")) {
                validateYearRange(filterValue);
            }

            carFilters.add(new CarFilter(filterName, filterValue));
        }

        return carFilters;
    }

    private static void validateYearRange(String yearRange) {
        String yearRangeRegex = "^\\d{4}-\\d{4}$";

        if (!yearRange.matches(yearRangeRegex)) {
            throw new UnableParsingException("Unable parsing year range:", yearRange);
        }
    }

    private static void printSearchResult(List<?> results) {
        System.out.println("-".repeat(23));
        System.out.println("Результаты поиска:");

        if (results.size() == 0) {
            System.out.println("По данному запросу ничего не обнаружено.");
        }

        for (Object result : results) {
            System.out.println(result);
        }

        System.out.println("-".repeat(23));
    }
}
