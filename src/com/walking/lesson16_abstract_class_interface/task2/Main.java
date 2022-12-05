package com.walking.lesson16_abstract_class_interface.task2;
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
                        Printable printable = new Message("Hello");
                        printable.print();
//                Вызываем оператор break, чтобы выйти из switch-case
                        break;

                    case "Bye":
                        printable = new Message("Good bye");
                        printable.print();
                        break;

                    case "How are you":
                        printable = new Message("How are your doing");
                        printable.print();
                        break;

                    default:  // Если значение s не совпадает ни с одним кейсом
                        printable = new Message("Unknown message");
                        printable.print();
                }
            }
    interface Printable{

        void print();
    }

static class Message implements Printable {

      private String message;
      Message(String message){
          this.message = message;
      }

    @Override
    public void print() {
        System.out.println(message);
    }
}

        }

