package com.walking.lesson67_locks.task3;

import com.walking.lesson67_locks.task3.model.LockingCounter;

import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter max counter's value: ");
        int maxValue = scanner.nextInt();
        scanner.close();

        var counter = new LockingCounter(maxValue);
        var threadGroup = new ThreadGroup("Counter thread group");

        IntStream.range(0, 10)
                .boxed()
                .map(i -> new Thread(threadGroup, getTask(counter)))
                .forEach(Thread::start);
    }

    private static Runnable getTask(LockingCounter counter) {
        return () -> {
            while (true) {
                try {
                    counter.getLock().lock();

//                    Альтернатива - использование lockInterruptibly() вместо lock()
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }

                    var value = counter.getValue();
                    counter.setValue(++value);

                    if (value % 100 == 0) {
                        System.out.printf("Value is %d\n", value);
                    }

                    if (counter.getValue() == counter.getMaxValue()) {
                        System.out.printf("Max value is achieved: %d\n", counter.getValue());
                        Thread.currentThread().getThreadGroup().interrupt();
                        return;
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