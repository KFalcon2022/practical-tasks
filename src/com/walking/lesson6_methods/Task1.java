package com.walking.lesson6_methods;

/**
 * Декомпозировать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson3/Task2SwitchCase.java">...</a>
 * Вынести в отдельный метод использование switch-case.
 * Также вынести в отдельный метод использование System.out.println
 */
public class Task1 {
    public static void main(String[] args) {

        int a = 5;
        int b = 10;

        int c = a;
        a = b;
        b = c;

        System.out.println("Значение а: " + a + ". Значение b: " + b);



    }
}
