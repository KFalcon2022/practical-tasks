package com.walking.lesson1_varaibles;

/**
 * Используя несколько переменных типа char вывести свое имя в консоль.
 */
public class Task2MultipleChar {
    public static void main(String[] args) {
//        Объявляем переменную типа char и инициализируем ее буквой имени
        char ch1 = 'Е';
//        Выводим значение переменной ch1 в консоль
        System.out.print(ch1);

//        Повторяем действия до тех пор, пока буквы в имени не кончатся
        char ch2 = 'г';
        System.out.print(ch2);

        char ch3 = 'о';
        System.out.print(ch3);

        char ch4 = 'р';
        System.out.print(ch4);
    }

    /*
     * Примечание: также можно было выводить не символы, а строки вида "" + ch1 + ch2..., например:
     * System.out.print("" + ch1 + ch2 + ch3 + ch4);
     *
     * Однако на данном этапе конкатенация строк не была пройдена
     * */
}
