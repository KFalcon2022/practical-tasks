package com.walking.lesson62_wait_notify.task2;

import com.walking.lesson62_wait_notify.task2.model.ProductBuyer;
import com.walking.lesson62_wait_notify.task2.model.ProductSupplier;
import com.walking.lesson62_wait_notify.task2.model.WholesaleBase;
import com.walking.lesson62_wait_notify.task2.service.IntRandomGenerator;
import com.walking.lesson62_wait_notify.task2.service.ProductBuyerService;
import com.walking.lesson62_wait_notify.task2.service.ProductSupplierService;
import com.walking.lesson62_wait_notify.task2.service.WholesaleBaseHolder;

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
        var wholesaleBase = new WholesaleBase(100, 0.25d);
        var wholesaleBaseHolder = new WholesaleBaseHolder(wholesaleBase);

        var buyerService = new ProductBuyerService(new IntRandomGenerator(9, 35), wholesaleBaseHolder);
        var supplierService = new ProductSupplierService(new IntRandomGenerator(10, 40), wholesaleBaseHolder);

//        Первичная инициализация данных убрана для лаконичности.
//        Поэтому при запуске каждый из покупателей и поставщиков
//        стартует с 0 в количестве покупаемых/поставляемых товаров
        var buyerThread1 = new Thread(getBuyerLogic(new ProductBuyer("1"), buyerService));
        var buyerThread2 = new Thread(getBuyerLogic(new ProductBuyer("2"), buyerService));
        var buyerThread3 = new Thread(getBuyerLogic(new ProductBuyer("3"), buyerService));

        var supplierThread1 = new Thread(getSupplierLogic(new ProductSupplier("1"), supplierService));
        var supplierThread2 = new Thread(getSupplierLogic(new ProductSupplier("2"), supplierService));
        var supplierThread3 = new Thread(getSupplierLogic(new ProductSupplier("3"), supplierService));

        buyerThread1.start();
        buyerThread2.start();
        buyerThread3.start();
        supplierThread1.start();
        supplierThread2.start();
        supplierThread3.start();

        waitFinishSignal();

        buyerThread1.interrupt();
        buyerThread2.interrupt();
        buyerThread3.interrupt();
        supplierThread1.interrupt();
        supplierThread2.interrupt();
        supplierThread3.interrupt();
    }

    private static Runnable getBuyerLogic(ProductBuyer buyer, ProductBuyerService buyerService) {
        return () -> {
            while (!Thread.interrupted()) {
                try {
                    buyerService.buy(buyer);
                    // Задержка только для возможности корректной остановки программы через ввод "Finish"
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
    }

    private static Runnable getSupplierLogic(ProductSupplier supplier, ProductSupplierService supplierService) {
        return () -> {
            while (!Thread.interrupted()) {
                try {
                    supplierService.supply(supplier);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
    }

    private static void waitFinishSignal() {
        var scanner = new Scanner(System.in);

        while (!"Finish".equals(scanner.nextLine())) {
            System.out.println("Incorrect input");
        }

        scanner.close();
    }
}