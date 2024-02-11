package com.walking.lesson60_thread.task3;

import com.walking.lesson60_thread.task3.service.ResultFromOtherThreadService;

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
        ResultFromOtherThreadService<String> resultFromOtherThread = new ResultFromOtherThreadService<>(Main::someMethod);
        System.out.println("Main thread");
        System.out.println(resultFromOtherThread.getOperationResult());
        System.out.println("Main thread");
    }
    private static String someMethod(){
        return "Hello world";
    }
}