package src.com.walking.lesson5_arrays;

/**
 * Вычислить из записать в массив первые 10 простых чисел.
 * Простое число – положительное целое число,
 * которое делится без остатка лишь на себя и на 1.
 * 1 не является простым числом.
 * Вывести в консоль сумму всех элементов полученного массива.
 */
public class Task3 {
    public static void main(String[] args) {
        int[] simpleIntegers = new int[10];
        int integer = 2;

        for (int i = 0; i < simpleIntegers.length; i++) {
            boolean mod = false;
            for (int j = 2; j < integer; j++) {
                if (integer % j == 0) {
                    mod = true;
                    break;
                }
            }
            if (mod) {
                integer++;
                i--;
            } else {
                simpleIntegers[i] = integer;
                integer++;
            }
        }

        for (int simpleInteger : simpleIntegers) {
            System.out.println(simpleInteger + " ");
        }
    }
}
