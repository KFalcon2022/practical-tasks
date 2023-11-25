package src.com.walking.lesson6_methods;

import java.util.Scanner;

/**
 * Декомпозировать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson3/Task2SwitchCase.java">...</a>
 * Вынести в отдельный метод использование switch-case.
 * Также вынести в отдельный метод использование System.out.println
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = scanner.nextLine();

        scanner.close();

        doGreetings(s);
    }

    static void doGreetings(String s) {
        switch (s) {
            case "Hi":
                say("Hello");
                break;
            case "Bye":
                say("Good bye");
                break;
            case "How are you":
                say("How are your doing");
                break;
            default:
                say("Unknown message");
        }
    }

    static void say(String message) {
        System.out.println(message);
    }
}
