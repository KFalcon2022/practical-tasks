package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.task1.model.RollebleStack;

/**
 * Реализуйте односвязный список (можно использовать реализацию в рамках
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson28_generics1/task4/structure/Stack.java">...</a>).
 * <p>
 * Реализуйте метод, разворачивающий односвязный список
 * (первый элемент должен стать последним, второй – предпоследним и т.д.).
 * <p>
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
    public static void main(String[] args) {
        RollebleStack<String> stack=new RollebleStack<>();
        stack.push("Реализуйте");
        stack.push("односвязный");
        stack.push("список");
        stack.push("можно");
        stack.push("использовать");
        stack.push("реализацию");
        stack.push("в");
        stack.push("рамках");
        for (int i = 0; i < 8; i++) {
            stack.pop();
        }
        stack.push("Реализуйте");
        stack.push("односвязный");
        stack.push("список");
        stack.push("можно");
        stack.push("использовать");
        stack.push("реализацию");
        stack.push("в");
        stack.push("рамках");
        System.out.println(stack.getValueByIndex(4));
        System.out.println(stack.toString());
        stack.delEvenHash();
        System.out.println(stack.toString());
        stack.roll();
        System.out.println(stack.toString());
    }
}
