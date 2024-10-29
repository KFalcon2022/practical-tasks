package com.walking.lesson62_wait_notify.task2;

import java.util.Scanner;

import com.walking.lesson62_wait_notify.task2.service.Customer;
import com.walking.lesson62_wait_notify.task2.service.Storage;
import com.walking.lesson62_wait_notify.task2.service.Supplier;

/**
 * Реализуйте имитацию оптовой базы с тремя поставщиками и тремя покупателями.
 * Максимальное число хранимых товаров определите на свой вкус.
 * <p>
 * Покупатели должны выкупать случайно сгенерированное число товаров при каждом посещении.
 * Если товаров недостаточно – при следующем посещении они
 * должны попытаться купить на 1 единицу товара меньше.
 * Если это число достигает нуля – должно быть сгенерировано новое число.
 * Если база опустела (на ней не осталось товаров) –
 * покупатели должны прекратить ее посещение до новых поставок.
 * <p>
 * Покупатели должны поставлять случайно сгенерированное число товаров при каждом посещении.
 * Если на базе не хватает места для всех товаров поставщика –
 * он должен поставить максимально возможное количество,
 * остальную поставку отложить до следующего посещения.
 * Если число товаров для поставки достигло нуля – должно быть сгенерировано новое число.
 * Если база заполнилась на 100% - поставщики должны прекратить попытки поставок до момента,
 * пока заполняемость базы не достигнет 25%.
 * <p>
 * Логируйте действия поставщиков в консоли.
 * Программа должна завершиться при вводе пользователем «Finish» с клавиатуры.
 * Другие пользовательские вводы не предусмотрены.
 * <p>
 * Рекомендую ограничить максимальное значение у Покупателей меньшим лимитом,
 * чем у Поставщиков.
 * В таком случае выполнение программы будет более наглядным.
 */
public class Main {
    public static void main(String[] args) {
        Storage storage=new Storage(100);
        Supplier s1=new Supplier(90, storage);
        Supplier s2=new Supplier(80, storage);
        Supplier s3=new Supplier(90, storage);
        Customer c1=new Customer(15, storage);
        Customer c2=new Customer(15, storage);
        Customer c3=new Customer(15, storage);
        c3.start();
        c2.start();
        c1.start();
        s1.start();
        s2.start();
        s3.start();
        waitFinishSignal();
        c3.interrupt();
        c2.interrupt();
        c1.interrupt();
        s1.interrupt();
        s2.interrupt();
        s3.interrupt();
    }
    private static void waitFinishSignal() {
        var scanner = new Scanner(System.in);

        while (!"Finish".equals(scanner.nextLine())) {
            System.out.println("Incorrect input");
        }

        scanner.close();
    }
}