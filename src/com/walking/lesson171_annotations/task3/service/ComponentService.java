package com.walking.lesson171_annotations.task3.service;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComponentService {
    public Map<Class<?>, Object> createObjects(List<Class<?>> classes) {
        var objects = new HashMap<Class<?>, Object>();

        for (var clazz : classes) {
            getInstance(clazz, objects, new HashSet<>());
        }

        return objects;
    }

    /**
     * Метод получения или создания объекта для конкретного класса. При необходимости также создает объекты
     * для параметров конструктора целевого класса.
     *
     * @param triggeredBy Служит для защиты от циклических зависимостей. Содержит в себе информацию о классах,
     *                    создание объектов которых привело к вызову метода для данного объекта <code>class</code>.
     */
    private Object getInstance(Class<?> clazz, Map<Class<?>, Object> objects, Set<Class<?>> triggeredBy) {
        var foundObject = objects.get(clazz);

        if (foundObject != null) {
            return foundObject;
        }

        // Убеждаемся, что создание объекта не было вызвано рекурсивно предыдущей попыткой создать объект того же типа
        if (triggeredBy.contains(clazz)) {
            throw new RuntimeException("Circular dependency is not allowed");
        }

        // Актуализируем triggeredBy для следующих рекурсивных вызовов
        triggeredBy.add(clazz);

        var constructor = getTargetConstructor(clazz);
        var parameters = getConstructorParameters(constructor, objects, triggeredBy);

        return objects.compute(clazz, (k, value) -> getClassInstanceNoEx(constructor, parameters));
    }

    private Constructor<?> getTargetConstructor(Class<?> clazz) {
        var constructors = clazz.getDeclaredConstructors();

        if (constructors.length != 1) {
            throw new RuntimeException("Expected exactly one constructor");
        }

        return constructors[0];
    }

    private List<?> getConstructorParameters(Constructor<?> constructor, Map<Class<?>, Object> objects,
                                                    Set<Class<?>> triggeredBy) {
        if (constructor.getParameters().length == 0) {
            return List.of();
        }

        return Arrays.stream(constructor.getParameterTypes())
                .map(paramClass -> getInstance(paramClass, objects, triggeredBy))
                .toList();
    }

    private Object getClassInstanceNoEx(Constructor<?> constructor, List<?> params) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(params.toArray());
        } catch (Exception e) {
            var declaringClassName = constructor.getDeclaringClass()
                    .getName();

            throw new RuntimeException("Unable to create instance of %s".formatted(declaringClassName), e);
        }
    }
}
