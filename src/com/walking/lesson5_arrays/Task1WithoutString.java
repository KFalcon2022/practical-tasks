package src.com.walking.lesson5_arrays;

/**
 * Создать массив char, заполненный буквами своего имени в верном порядке.
 * Используя этот массив, вывести свое имя в консоль.
 * Не использовать переменную типа String.
 */
public class Task1WithoutString {
    public static void main(String[] args) {
        char[] nameChars = {'Н', 'и', 'к', 'и', 'т', 'а'};

        for (char nameChar : nameChars) {
            System.out.print(nameChar);
        }
    }
}
