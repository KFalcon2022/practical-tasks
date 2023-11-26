package com.walking.lesson17_enum.task1;

import java.util.Scanner;
/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * через enum. В т.ч. реализуйте в enum'е поиск значения по фразе,
 * введенной пользователем. Напоминаю, что enum'ы могут содержать поля.
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Enter string: ");
        Scanner sc = new Scanner(System.in);
        String userInputLine = sc.nextLine().toLowerCase();
        System.out.println(Answer(userInputLine));

    }

    private static String Answer(String userInputLine){
        switch (userInputLine) {
            case "hi","hi.","hi!":
                return Answers.HI.getAnswer();
            case "bye", "bye.", "bye!":
                return Answers.BYE.getAnswer();
            case "how are you", "how are you?","how are you!","how are you.":
                return Answers.HOW_ARE_YOU.getAnswer();
            default:
                return Answers.UNKNOWN_INPUT.getAnswer();

        }
    }
}


