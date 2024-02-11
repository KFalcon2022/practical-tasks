package com.walking.lesson42_tree.task1;


import com.walking.lesson42_tree.task1.model.BinarySearchTree;

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

//Балансировка не реализована

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.add(3);
        tree.add(1);
        tree.add(10);
        tree.add(4);
        tree.add(6);
        tree.add(11);
        System.out.println("Size: "+tree.getSize());
        tree.bypassStraight();
        System.out.println("-----------");
        tree.bypassCentre();
        System.out.println("-----------");
        tree.bypassReverse();
        System.out.println("-----------");
        tree.bypassHorizontal();
        System.out.println("\nHeight: "+tree.getHeight());

//        BinarySearchTree<Person> treePerson = new BinarySearchTree<>();
//        treePerson.add(new Person ("Tom",44));
//        treePerson.add(new Person ("Kir",44));
//        treePerson.add(new Person ("Leus",50));
//        treePerson.add(new Person ("Masha",10));
//        treePerson.add(new Person ("Kora",32));
//        treePerson.bypassStraight();
//        System.out.println("-----------");
//        treePerson.bypassCentre();
//        System.out.println("-----------");
//        treePerson.bypassReverse();
//        System.out.println("-----------");
//        treePerson.bypassHorizontal();
    }
    //Класс для проверки работоспособности дерева с Comparable классами
    private static class Person implements Comparable<Person>{
        private String name;
        private int age;
        public Person (String name, int age){
            this.name=name;
            this.age=age;
        }
        public int getAge(){
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Person o) {
            return age-o.getAge();
        }
        @Override
        public String toString(){
            return name;
        }
    }
}
