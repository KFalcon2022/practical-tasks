package com.walking.lesson16_abstract_class_interface.task2.printer;

public interface AnswerCreator {
    void getAnswer();

     static void createAnswer(String question) {
        AnswerCreator answer;

        switch (question) {
            case "Hi":
                answer = new Hi();
                answer.getAnswer();
                break;
            case "How are you":
                answer = new HowAreYou();
                answer.getAnswer();
                break;
            case "Bye":
                answer = new Bye();
                answer.getAnswer();
                break;
            default:
                System.out.println("Unknown message");

        }
         // и так же вопрос: А стоит ли метод createAnswer выводить в отдельный интерфейс,
         // или же стоило его оставить в MAIN?
    }
}
