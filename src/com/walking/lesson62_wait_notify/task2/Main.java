package com.walking.lesson62_wait_notify.task2;

import com.walking.lesson62_wait_notify.task2.model.UserListener;
import com.walking.lesson62_wait_notify.task2.model.Customer;
import com.walking.lesson62_wait_notify.task2.model.Depot;
import com.walking.lesson62_wait_notify.task2.model.Provider;
import com.walking.lesson62_wait_notify.task2.util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        Random random = new Random();
        Logger logger = new Logger();
        Depot depot = new Depot(logger);

        List<Thread> providers = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            Thread provider = new Thread(new Provider(depot, () -> random.nextInt(20, 40)), "provider " + (i + 1));
            providers.add(provider);
        }

        List<Thread> customers = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            Thread customer = new Thread(new Customer(depot, () -> random.nextInt(20, 30)), "customer " + (i + 1));
            customers.add(customer);
        }

        Scanner scanner = new Scanner(System.in);

        UserListener userListener = new UserListener(scanner::nextLine, logger, depot);
        userListener.addThread(providers);
        userListener.addThread(customers);

        Thread listenerThread = new Thread(userListener, "userListener");

        listenerThread.start();

        for (Thread provider : providers) {
            provider.start();
        }

        for (Thread customer : customers) {
            customer.start();
        }
    }
}