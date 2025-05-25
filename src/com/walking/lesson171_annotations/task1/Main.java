package com.walking.lesson171_annotations.task1;

import java.util.List;

/**
 * Реализуйте метод, который принимает на вход список объектов <code>Class</code>
 * и записывает в консоль имена помеченных аннотацией <code>@Deprecated</code>.
 */
public class Main {
    public static void main(String[] args) {
        printDeprecatedClassNames(List.of(DeprecatedTestClass.class, String.class, List.class));
    }

    private static void printDeprecatedClassNames(List<Class<?>> classes) {
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Deprecated.class))
                .map(Class::getName)
                .forEach(System.out::println);
    }
}
