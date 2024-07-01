package com.walking.lesson42_tree.task1;

import com.walking.lesson42_tree.task1.model.Task;
import com.walking.lesson42_tree.task1.structure.BinarySearchTree;
import com.walking.lesson42_tree.task1.structure.BinarySearchTree_v2;

import java.util.Comparator;
import java.util.List;

/**
 * Реализуйте бинарное дерево поиска. Учтите возможность использования дерева как для Comparable-сущностей,
 * так и для сортировки на основе компаратора.
 * <p>
 * Реализуйте в рамках дерева методы, производящие обход в глубину (любой из трех рассмотренных в статье) и ширину.
 * Результатом работы этих методов должно быть перечисление элементов дерева в консоли в порядке их обхода.
 * <p>
 * Обратите внимание: в этой задаче не идет речи об автобалансировке дерева.
 * <p>
 * Опциональное условие(*): реализуйте метод балансировки дерева по высоте.
 * В рамках текущей задачи принимается реализация любой степени наивности,
 * если она дает корректный результат.
 */
public class Main {
    public static void main(String[] args) {
        Comparator<Task> taskNameComparator = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        BinarySearchTree<Task> binarySearchTree = new BinarySearchTree<>();

        List<Task> tasks = getMiddleList();

        for (Task task : tasks) {
            binarySearchTree.put(task);
        }

        printTreeOverview(binarySearchTree);

        Task foundTask = binarySearchTree.get(tasks.get(0));
        System.out.println("Найдена задача: " + foundTask);

        Task removedTask = binarySearchTree.remove(tasks.get(0));
        System.out.println("Извлечена задача:" + removedTask);

        printTreeOverview(binarySearchTree);

        binarySearchTree.balance();

        printTreeOverview(binarySearchTree);

        foundTask = binarySearchTree.get(tasks.get(0));
        System.out.println("Найдена задача: " + foundTask);
    }

    public static List<Task> getAscendingList() {
        Task task0 = new Task("05");
        Task task1 = new Task("10");
        Task task2 = new Task("15");
        Task task3 = new Task("19");
        Task task4 = new Task("20");
        Task task5 = new Task("21");
        Task task6 = new Task("25");
        Task task7 = new Task("30");
        Task task8 = new Task("35");

        return List.of(task0, task1, task2, task3, task4, task5, task6, task7, task8);
    }

    public static List<Task> getMiddleList() {
        Task task0 = new Task("20");
        Task task1 = new Task("15");
        Task task2 = new Task("10");
        Task task3 = new Task("05");
        Task task4 = new Task("19");
        Task task5 = new Task("30");
        Task task6 = new Task("25");
        Task task7 = new Task("21");
        Task task8 = new Task("35");

        return List.of(task0, task1, task2, task3, task4, task5, task6, task7, task8);
    }

    public static void print(List<?> list) {
        for (Object object : list) {
            System.out.print(object);
        }

        System.out.println();
    }

    public static void printTreeOverview(BinarySearchTree<?> tree) {
        System.out.println(".".repeat(80));

        System.out.println("Корень дерева: " + tree.getRoot());

        System.out.println("Содержимое дерева в порядке возрастания ширины (BFS):");
        tree.breadthFirstSearchTraversal();
        System.out.println();

        System.out.println("Содержимое дерева в порядке возрастания значений (DFS:inOrder):");
        List<?> ascendingOrder = tree.getAscendingOrder();
        print(ascendingOrder);

        System.out.println("min = " + tree.getMin());
        System.out.println("max = " + tree.getMax());

        System.out.println(".".repeat(80));
    }
}