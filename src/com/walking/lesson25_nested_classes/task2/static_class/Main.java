package com.walking.lesson25_nested_classes.task2.static_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя статические вложенные классы.
 */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new Animal.Cat());
        System.out.println(new Animal().quickSound("cow"));
    }
}