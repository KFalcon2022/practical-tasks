package src.com.walking.lesson1_varaibles;

/**
 * На месте комментария написать код, который присвоит переменной a значение переменной b и наоборот.
 * Подсказка: можно использовать третью переменную.
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