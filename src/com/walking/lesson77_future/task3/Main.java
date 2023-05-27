package com.walking.lesson77_future.task3;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Реализуйте цепочку асинхронных операций: получите сообщение с клавиатуры,
 * «разверните» его, затем выведите в консоль.
 * Для имитации «тяжелых» операций сопровождайте каждую из них
 * усыплением потока на заданный промежуток времени.
 * <p>
 * Посмотрите, в каком потоке будет выполнена каждая из операций.
 */
public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        CompletableFuture.supplyAsync(getUserInputTask(scanner))
                .handleAsync((str, ex) -> getReverseStringTask(str).get())
                .thenAcceptAsync(Main::print)
                .join();

        scanner.close();
    }

    private static Supplier<String> getUserInputTask(Scanner scanner) {
        return () -> {
            System.out.println("Enter string: ");
            var input = scanner.nextLine();

            sleepNoEx();
            System.out.println(Thread.currentThread().getName());

            return input;
        };
    }

    private static Supplier<String> getReverseStringTask(String string) {
        return () -> {
            sleepNoEx();
            System.out.println(Thread.currentThread().getName());

            return new StringBuilder(string)
                    .reverse()
                    .toString();
        };
    }

    private static void print(String string) {
        sleepNoEx();
        System.out.println(Thread.currentThread().getName());

        System.out.printf("Result: '%s'", string);
    }

    private static void sleepNoEx() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}