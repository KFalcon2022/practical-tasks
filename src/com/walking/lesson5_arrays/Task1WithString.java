package src.com.walking.lesson5_arrays;

/**
 * Создать массив char, заполненный буквами своего имени в верном порядке.
 * Используя этот массив, вывести свое имя в консоль.
 * Предварительно собрать значения массива в переменную типа String.
 */
public class Task1WithString {
    public static void main(String[] args) {
        char[] nameChars = {'Н', 'и', 'к', 'и', 'т', 'а'};

        String name = "";
        for (char nameChar : nameChars) {
            name += nameChar;
        }
        System.out.println(name);
    }
}
