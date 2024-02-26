package com.walking.lesson62_wait_notify.task2;

import com.walking.lesson62_wait_notify.task2.model.Buyer;
import com.walking.lesson62_wait_notify.task2.model.Supplier;
import com.walking.lesson62_wait_notify.task2.model.Warehouse;

import java.util.*;

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
    public static void main(String[] args) throws InterruptedException {
        Warehouse warehouse = new Warehouse();

        Set<Buyer> buyers = new HashSet<>();
        Set<Supplier> suppliers = new HashSet<>();
        Set<Thread> buyersThread = new HashSet<>();
        Set<Thread> sellersThread = new HashSet<>();

        buyers.add(new Buyer(warehouse, "Romashka"));
        buyers.add(new Buyer(warehouse, "Pecheneg"));
        buyers.add(new Buyer(warehouse, "Igor"));

        suppliers.add(new Supplier(warehouse, "X5"));
        suppliers.add(new Supplier(warehouse, "Ochakovo"));
        suppliers.add(new Supplier(warehouse, "3 Korochki"));

        buyersThread = createThread(buyers);
        sellersThread = createThread(suppliers);

        buyersThread.forEach(Thread::start);
        sellersThread.forEach(Thread::start);

        waitFinishSignal();

        buyersThread.forEach(Thread::interrupt);
        sellersThread.forEach(Thread::interrupt);

    }

    private static Set<Thread> createThread(Set<? extends Runnable> companiesSet) {
        Set<Thread> threads = new HashSet<>();

        companiesSet.forEach(company -> threads.add(new Thread(company)));

        return threads;
    }

    public static void waitFinishSignal() {
        var scanner = new Scanner(System.in);

        while (!"Finish".equals(scanner.nextLine())) {
            System.out.println("Incorrect input.");
        }

        scanner.close();
    }
}