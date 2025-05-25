package com.walking.lesson171_annotations.task3.service;

import com.walking.lesson171_annotations.task3.annotation.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentLoaderService {
    public List<Class<?>> load(List<String> packages) {
        return packages.stream()
                .map(this::loadClassesByPackage)
                .flatMap(List::stream)
                .filter(clazz -> clazz.isAnnotationPresent(Component.class))
                .toList();
    }

    //    Довольно наивный способ загрузки классов по пакету. Если бы файлы .class находились внутри JAR -
    //    именно этот подход не сработал бы и потребовалось более сложное решение
    public List<Class<?>> loadClassesByPackage(String packageName) {
        var resourcePath = packageName.replaceAll("[.]", "/");

        var classLoader = Thread.currentThread()
                .getContextClassLoader();

        try (InputStream stream = classLoader.getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.lines()
                    // Фактически, происходит чтение директории, соответствующей обрабатываемому пакету.
                    // А директория как таковая содержит имена файлов, которые к ней относятся
                    .filter(line -> line.endsWith(".class"))
                    .map(line -> getClass(line, packageName))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Class<?> getClass(String classFileName, String packageName) {
        // classFileName будет содержать строку вида "A.class". То есть имя файла вместе с расширением
        var classSimpleName = classFileName.replaceAll("\\.class", "");
        var className = "%s.%s".formatted(packageName, classSimpleName);

        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
