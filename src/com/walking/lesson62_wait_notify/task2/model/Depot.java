package com.walking.lesson62_wait_notify.task2.model;

import com.walking.lesson62_wait_notify.task2.util.Logger;

public class Depot {
    public final static int MAX_STOCK_VALUE = 100;
    public final static int STOP_PURCHASE_STOCK_VALUE = 0;
    public final static int STOP_SUPPLY_STOCK_VALUE = 100;
    public final static int START_SUPPLY_STOCK_VALUE = 25;

    private final Logger logger;

    private boolean isRequiredSupply = true;
    private int stock;

    public Depot(Logger logger) {
        this.logger = logger;
    }

    public int getStock() {
        return stock;
    }

    public synchronized int trySupply(int count) {
        while (!isRequiredSupply) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread()
                      .interrupt();
            }
        }

        logger.log("Остаток товаров - %d. %s пытается поставить %d товаров.".formatted(stock, Thread.currentThread()
                                                                                                    .getName(), count));

        stock += count;
        int surplus = 0;

        inspectCapacity();

        if (stock > MAX_STOCK_VALUE) {
            surplus = stock - MAX_STOCK_VALUE;
            stock = MAX_STOCK_VALUE;

            logger.log("Склад заполнен. Избыток товаров возвращен поставщику - %s.".formatted(surplus));
        }

        notifyAll();

        return surplus;
    }

    public synchronized int tryPurchase(int count) {
        if (stock == STOP_PURCHASE_STOCK_VALUE) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread()
                      .interrupt();
            }
        }

        logger.log("Остаток товаров - %d. %s пытается купить %d товаров.".formatted(stock, Thread.currentThread()
                                                                                                 .getName(), count));

        int balance = stock - count;
        int shortage = 0;

        if (balance >= STOP_PURCHASE_STOCK_VALUE) {
            stock = balance;

            inspectCapacity();
        } else {
            shortage = count;

            logger.log("Склад пуст. Не хватило товаров для продажи - %s.".formatted(shortage));
        }

        notifyAll();

        return shortage;
    }

    private void inspectCapacity() {
        if (stock <= START_SUPPLY_STOCK_VALUE && !isRequiredSupply) {
            isRequiredSupply = true;
        } else if (stock >= STOP_SUPPLY_STOCK_VALUE && isRequiredSupply) {
            isRequiredSupply = false;
        }
    }
}
