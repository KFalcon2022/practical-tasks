package com.walking.lesson1_varaibles;

/**
 * Используя одну переменную типа char вывести свое имя в консоль.
 */
public class Task2SingleChar {
    public static void main(String[] args) {
//        Объявляем переменную типа char и инициализируем ее первой буквой имени
        char ch = 'Е';
//        Выводим значение переменной ch в консоль
        System.out.print(ch);

//        Присваиваем переменной ch следующую букву имени
//        Повторяем действия до тех пор, пока буквы в имени не кончатся
        ch = 'г';
        System.out.print(ch);

        ch = 'о';
        System.out.print(ch);

        ch = 'р';
        System.out.print(ch);
    }
}
