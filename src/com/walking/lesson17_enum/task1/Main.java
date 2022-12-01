package com.walking.lesson17_enum.task1;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через switch-case
 */
public class Main {
    public static void main(String[] args) {
//        Создаем сканер для чтения с клавиатуры
        Scanner scanner = new Scanner(System.in);

//        Выводим сообщение "Enter string: " в консоль.
//        Данное сообщение не является обязательным, лишь информирует пользователя,
//        какое действие от него ожидается
        System.out.print("Enter string: ");
//        Объявляем переменную s типа String и записываем в нее значение, введенное с клавиатуры
        String s = scanner.nextLine();

//        Сканер более не используется, ее необходимо закрыть.
//        Зачем - разберемся, когда будем изучать I/O Streams
        scanner.close();

//        Используем конструкцию switch-case для переменной s
/*        switch (s) {
            case "Hi":  // Если s равно "Hi"
//                Выводим в консоль "Hello"
                System.out.println(Answer.HI.getAnswer());
//                Вызываем оператор break, чтобы выйти из switch-case
                break;

            case "Bye":
                System.out.println(Answer.BYE.getAnswer());
                break;

            case "How are you":
                System.out.println(Answer.HOW_ARE_YOU.getAnswer());
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                System.out.println(Answer.ERROR.getAnswer());
        }*/

        if (Question.HI.getAnswer().equals(s)) {
            System.out.println(Answer.HI.ANSWER);
        } else if (Question.BYE.getAnswer().equals(s)) {
            System.out.println(Answer.BYE.getAnswer());
        } else if (Question.HOW_ARE_YOU.getAnswer().equals(s)) {
            System.out.println(Answer.HOW_ARE_YOU.getAnswer());
        } else System.out.println(Answer.ERROR.ANSWER);

    }
}

enum Answer {
    HI("Hello"),
    BYE("Good bye"),
    HOW_ARE_YOU("How are your doing"),
    ERROR("Unknown message");
    final String ANSWER;

    Answer(String answer) {
        this.ANSWER = answer;
    }

    public String getAnswer() {
        return ANSWER;
    }
}

enum Question {
    HI("Hi"),
    BYE("Bye"),
    HOW_ARE_YOU("How are your");
    public String question;

    Question(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return question;
    }
}