package com.walking.lesson67_locks.task3;

import com.walking.lesson67_locks.task3.model.Counter;

import java.util.stream.IntStream;

/**
 * Реализуйте программу, увеличивающую значение счетчика на 1
 * несколькими параллельными потоками одновременно вплоть до числа, указанного пользователем.
 * Каждый раз, когда число превышает значение, кратное 100,
 * одним из потоков в консоль должно выводиться соответствующее сообщение.
 * <p>
 * Использование атомик-типов недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(10000);

        var increase = increaseValue(counter);
        var threadGroup = new ThreadGroup("Thread group");

        IntStream.range(0, 10)
                .boxed()
                .map(x -> new Thread(threadGroup, increase))
                .forEach(Thread::start);

    }

    public static Runnable increaseValue(Counter counter) {
        return () -> {
            int value;
            while (!counter.isExcess()) {
                try {
                    counter.getLock().lock();
                    counter.increase();
                    value = counter.getX();

                    if (value % 100 == 0) {
                        System.out.println("Value " + value + " Thread " + Thread.currentThread().getName());
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    counter.getLock().unlock();
                }
            }
        };
    }
}