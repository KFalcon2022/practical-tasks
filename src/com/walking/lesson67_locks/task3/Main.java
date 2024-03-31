package com.walking.lesson67_locks.task3;

import com.walking.lesson67_locks.task3.model.Counter;
import com.walking.lesson67_locks.task3.service.CounterService;

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
        Counter counter = new Counter();
        CounterService counterService = new CounterService(counter);

        for (int i = 0; i < 10; i++){
            new Thread(getIncreasingTask(counterService, 10000)).start();
        }

    }

    private static Runnable getIncreasingTask(CounterService counterService, long limit) {
        return () -> counterService.increaseToNumber(limit);

    }
}