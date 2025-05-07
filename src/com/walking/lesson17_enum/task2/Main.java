package com.walking.lesson17_enum.task2;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * через enum. Пусть Cow, Dog и Cat будут значениями enum'а Animal.
 */
public class Main {
    public static void main(String[] args) {
        ANIMALS[] animal = ANIMALS.values(); // создаем массив элементов Enum с помощью метода values
        
        for (ANIMALS a : animal) { // запускаем цикл для вывода на экран элементов 
            System.out.println(a);
        }
    }
}
