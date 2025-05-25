package com.walking.lesson170_reflection.task1;

import com.walking.lesson170_reflection.task1.model.Car;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализуйте метод, которая выводит в консоль метаинформацию о переданном классе:
 *
 * <ul>
 * <li> Полное имя класса;</li>
 * <li> Список полей с указанием их типов и модификаторов;</li>
 * <li> Список конструкторов с указанием их модификаторов доступа и параметров;</li>
 * <li> Список всех методов с указанием модификаторов, возвращаемого типа, имени и параметров.</li>
 * </ul>
 * <p>
 * Опциональное усложнение: выводить не только методы указанного класса, но и доступные методы его предков.
 */
public class Main {
    public static void main(String[] args) {
        printClassInfo(Car.class);
        printClassInfo(Object.class);
        printClassInfo(Main.class);
    }

    public static void printClassInfo(Class<?> clazz) {
        System.out.println(clazz.toGenericString());

        printFields(clazz);
        printConstructor(clazz);
        printMethods(clazz);

        System.out.println();
    }

    private static void printFields(Class<?> clazz) {
//        Опционально - можно доработать, добавив наследуемые публичные поля.
//        По аналогии с тем, как это ниже продемонстрировано для методов
        for (var field : clazz.getDeclaredFields()) {
            // Творческая переработка Field#toGenericString() под желаемый формат отображения
            int modifiers = field.getModifiers();
            Type fieldType = field.getGenericType();

            var modifiersString = modifiers == 0 ? "" : Modifier.toString(modifiers);
            var fieldString = "%s %s %s".formatted(modifiersString, fieldType.getTypeName(), field.getName());

            System.out.println(fieldString);
        }
    }

    private static void printConstructor(Class<?> clazz) {
        var className = clazz.getSimpleName();

        for (var constructor : clazz.getConstructors()) {
            int modifiers = constructor.getModifiers();
            var modifiersString = modifiers == 0 ? "" : Modifier.toString(modifiers);

            var params = Arrays.stream(constructor.getGenericParameterTypes())
                    .map(Type::getTypeName)
                    .collect(Collectors.joining(", "));

            Type[] exceptionTypes = constructor.getGenericExceptionTypes();

            var throwsString = exceptionTypes.length == 0
                    ? ""
                    : Arrays.stream(exceptionTypes)
                    .map(Type::getTypeName)
                    .collect(Collectors.joining(", ", " throws ", ""));

            var constructorString = "%s %s(%s) %s".formatted(
                    modifiersString, className, params, throwsString);

            System.out.println(constructorString);
        }
    }

    private static void printMethods(Class<?> clazz) {
        // Используем Set, чтобы избежать дублирования публичных методов clazz
        // при добавлении публичных методов предков в общую коллекцию
        var methods = Arrays.stream(clazz.getDeclaredMethods())
                .collect(Collectors.toSet());

        methods.addAll(List.of(clazz.getMethods()));

        methods.stream()
                .map(Main::getMethodDescription)
                .forEach(System.out::println);
    }

    private static String getMethodDescription(Method method) {
        int modifiers = method.getModifiers();
        var modifiersString = modifiers == 0 ? "" : Modifier.toString(modifiers);

        var returnTypeString = method.getGenericReturnType().getTypeName();

        var params = Arrays.stream(method.getGenericParameterTypes())
                .map(Type::getTypeName)
                .collect(Collectors.joining(", "));

        Type[] exceptionTypes = method.getGenericExceptionTypes();

        var throwsString = exceptionTypes.length == 0
                ? ""
                : Arrays.stream(exceptionTypes)
                .map(Type::getTypeName)
                .collect(Collectors.joining(", ", "throws ", ""));

        return  "%s %s %s(%s) %s".formatted(modifiersString, returnTypeString, method.getName(), params, throwsString);
    }
}
