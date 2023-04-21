package Lesson28.Task4;

import Lesson28.Task3.ArrayGen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.add("haha"));
        System.out.println(stack.add("baba"));
        System.out.println(stack.add("mama"));
        System.out.println(stack.add("toto"));
        System.out.println(stack.getLength());
        System.out.println(stack.printStack());
    }
}