package com.walking.lesson0_tests.lockerAwait;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Buyer buyer1 = new Buyer(store);
        Buyer buyer2 = new Buyer(store);
        Buyer buyer3 = new Buyer(store);
        Supplier supplier1 = new Supplier(store);
        Supplier supplier2 = new Supplier(store);
        Supplier supplier3 = new Supplier(store);

        new Thread(supplier1).start();
        new Thread(buyer1).start();
    }
}

class Buyer implements Runnable {
    private Store store;

    public final Random random = new Random();

    public Buyer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            store.buy(random.nextInt(1, 4));
        }
    }
}

class Supplier implements Runnable {
    private Store store;

    public final Random random = new Random();

    public Supplier(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            store.put(random.nextInt(1, 6));
        }
    }
}

class Store {
    private int storage = 0;

    private final ReentrantLock locker;
    private final Condition notFull;
    private final Condition notEmpty;

    public Store() {
        locker = new ReentrantLock();
        notFull = locker.newCondition();
        notEmpty = locker.newCondition();
    }

    public void put(int qty) {
        try {
            locker.lock();

            while (storage >= 10) {
                notFull.await();
            }
            storage += qty;
            System.out.println("Поставщик поставил товар: " + qty);
            System.out.println("Остаток товара: " + storage);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }

    public void buy(int qty) {
        try {
            locker.lock();

            while (storage <= 3) {
                notEmpty.await();
            }
            storage -= qty;
            System.out.println("Покупатель купил товар: " + qty);
            System.out.println("Остаток товара: " + storage);
            notFull.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }
}
