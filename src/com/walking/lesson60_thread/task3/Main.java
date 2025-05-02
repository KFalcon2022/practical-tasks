package com.walking.lesson60_thread.task3;

import com.walking.lesson60_thread.task3.model.FunctionExecutor;

import java.util.Random;

/**
 * Уже на текущем этапе мы можем распараллелить какие-то действия с помощью многопоточности.
 * Но иногда требуется выполнить определенную операцию в другом потоке и получить ее результат.
 * Поскольку Runnable не позволяет вернуть что-либо из метода – реализуйте класс/классы,
 * которые позволят получать некий результат операции, выполненной в другом потоке.
 * <p>
 * Рекомендую использовать интерфейс Callable для описания операции.
 * Его метод имеет возвращаемое значение.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        FunctionExecutor<String, Integer> lengthCalculator = new FunctionExecutor<>("Test_string", String::length);

        System.out.println(lengthCalculator.call());

        FunctionExecutor<String, String> toUpperCase = new FunctionExecutor<>("Test_string", String::toUpperCase);

        System.out.println(toUpperCase.call());

        FunctionExecutor<Integer, String> oddOrEvenPrinter = new FunctionExecutor<>(new Random().nextInt(10),
                i -> i % 2 == 0 ? "%s is even".formatted(i) : "%s is odd".formatted(i));

        System.out.println(oddOrEvenPrinter.call());
    }
}