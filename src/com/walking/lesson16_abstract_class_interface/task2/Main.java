package com.walking.lesson16_abstract_class_interface.task2;

public class Main {
    public static void main(String[] args) {
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
        Answer answer = new Answer();

        switch (s) {
            case "Hi":  // Если s равно "Hi"
//                Выводим в консоль "Hello"
                //System.out.println("Hello");
                answer.answer("Hello");
//                Вызываем оператор break, чтобы выйти из switch-case
                break;

            case "Bye":
                //System.out.println("Good bye");
                answer.answer("Good bye");
                break;

            case "How are you":
                //System.out.println("How are your doing");
                answer.answer("How are your doing");
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                //System.out.println("Unknown message");
                answer.answer();
        }

    }
}

interface Answers {
    default void answer() {
        System.out.println("Unknown message");
    }
    void answer(String answer);
}
class Answer implements Answers {
    public void answer(String answer) {
        System.out.println(answer);
    }
}