package Lesson29.Task1;

import Lesson28.Task4.Stack;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WildcardGenericExample<String> wildcardGenericExample = new WildcardGenericExample<>("haha");
        WildcardGenericExample<String> wildcardGenericExample1 = new WildcardGenericExample<>();
        System.out.println(getObject(wildcardGenericExample, "null"));
        System.out.println(getObject(wildcardGenericExample1, "null"));
    }
    public static <T> T getObject(WildcardGenericExample <T> wildcardGenericExample, T defaultObject) {
        if (wildcardGenericExample.getObject() == null) {
            return defaultObject;
        }
        else return wildcardGenericExample.getObject();
    }
}