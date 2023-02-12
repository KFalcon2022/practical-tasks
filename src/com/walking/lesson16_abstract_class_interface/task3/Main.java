package com.walking.lesson16_abstract_class_interface.task3;

import com.walking.lesson16_abstract_class_interface.task3.*;
import com.walking.lesson16_abstract_class_interface.task3.model.Cat;
import com.walking.lesson16_abstract_class_interface.task3.model.Cow;
import com.walking.lesson16_abstract_class_interface.task3.model.Dog;

import java.util.Scanner;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрана
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter animal name: ");
        Scanner sc = new Scanner(System.in);
        String questionType = sc.nextLine().toLowerCase();
        System.out.println(question(questionType));

    }

    private static String question(String questionType){
        switch (questionType){
            case "dog":
                return new Dog().sound();
            case "cat":
                return new Cat().sound();
            case "Cow":
                return new Cow().sound();
            default:
                return "I dont know this animal!";

        }
    }
}
