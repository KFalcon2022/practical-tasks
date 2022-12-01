package com.walking.lesson17_enum.Task1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через switch-case
 */

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
                switch (s) {
                    case "Hi":  // Если s равно "Hi"
//                Выводим в консоль "Hello"
                        System.out.println(Message.HI.getMessage());
//                Вызываем оператор break, чтобы выйти из switch-case
                        break;

                    case "Bye":
                       System.out.println(Message.BYE.getMessage());
                        break;

                    case "How are you":
                        System.out.println(Message.HOW_ARE_YOU.getMessage());
                        break;

                    default:  // Если значение s не совпадает ни с одним кейсом
                        System.out.println(Message.DEFAULT.getMessage());
                }
            }
        }

        enum Message{
            HI("Hello"), BYE("Good bye"), HOW_ARE_YOU("How are your doing"),DEFAULT("Unknown message");
            private String message;
            Message(String message){
                this.message=message;
            }
            public String getMessage(){
                return message;
            }
        }

