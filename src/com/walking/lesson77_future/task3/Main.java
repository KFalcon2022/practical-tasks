package com.walking.lesson77_future.task3;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

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
        Scanner scanner=new Scanner(System.in);
        CompletableFuture.supplyAsync(()->{
            String inputString=scanner.nextLine();
            System.out.println("Получил строку: "+inputString+" В потоке "
            +Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return inputString;
        }).thenApplyAsync((inputString)->{
            String reverseString=new StringBuilder(inputString).reverse().toString();
            System.out.println("Перевернул строку: "+reverseString+" В потоке "
            +Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return reverseString;
        }).thenAccept(System.out::println).join();
        scanner.close();
    }
}