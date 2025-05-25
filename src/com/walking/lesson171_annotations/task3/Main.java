package com.walking.lesson171_annotations.task3;

import com.walking.lesson171_annotations.task3.service.ComponentLoaderService;
import com.walking.lesson171_annotations.task3.service.ComponentService;

import java.util.List;

/**
 * Развейте решение, разработанное в
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/for-pr/src/com/walking/lesson170_reflection/task2/Main.java">Задаче 2</a>
 * предыдущей статьи.
 * <p>
 * Реализуйте аннотацию <code>@Component</code>, которая будет маркером загружаемых классов.
 * Также предоставьте возможность загружать все классы, аннотированные <code>@Component</code>,
 * для заданных пакетов. Список сканируемых пакетов должен предоставляться как параметр метода.
 * <p>
 * Результатом подобной доработки должен стать список всех классов, аннотированных <code>@Component</code>,
 * из указанных пакетов. Далее этот список должен передаваться в ранее созданный метод, создающий объект
 * для каждого класса, в соответствии с правилами, описанными в задаче предыдущей статьи.
 */
public class Main {
    public static void main(String[] args) {
        var componentLoaderService = new ComponentLoaderService();
        var componentService = new ComponentService();

        var correctComponentPackages = List.of(
                "com.walking.lesson171_annotations.task3.model1",
                "com.walking.lesson171_annotations.task3.model2"
        );
        var classes = componentLoaderService.load(correctComponentPackages);
        var objects = componentService.createObjects(classes);

        var componentPackagesWithCircularDependency = List.of(
                "com.walking.lesson171_annotations.task3.model1",
                "com.walking.lesson171_annotations.task3.model2",
                "com.walking.lesson171_annotations.task3.model3"
        );
        var classesWithCircularDependency = componentLoaderService.load(componentPackagesWithCircularDependency);
        componentService.createObjects(classesWithCircularDependency); // В ходе обработки произойдет ошибка
    }
}
