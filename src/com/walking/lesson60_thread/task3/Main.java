package com.walking.lesson60_thread.task3;

/**
 * Уже на текущем этапе мы можем распараллелить какие-то действия с помощью многопоточности.
 * Но иногда требуется выполнить определенную операцию в другом потоке и получить ее результат.
 * Поскольку Runnable не позволяет вернуть что-либо из метода – реализуйте класс/классы,
 * которые позволят получать некий результат операции, выполненной в другом потоке.
 * <p>
 * Рекомендую использовать интерфейс Callable для описания операции.
 * Его метод имеет возвращаемое значение.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var callableThread = new CallableThread<>(() -> Thread.currentThread().getName());
        callableThread.start();
        System.out.println(callableThread.getResult());

        callableThread = new CallableThread<>(() -> Thread.currentThread().getName());
        System.out.println(callableThread.startAndGet());
    }
}