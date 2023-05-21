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

public class Main {
	public static void main(String[] args) {
		BinarySearchTree testTree = new BinarySearchTree();
		testTree.add(20);
		testTree.add(7);
		testTree.add(35);
		testTree.add(4);
		testTree.add(9);
		testTree.add(31);
		testTree.add(40);
		testTree.add(6);
		testTree.add(28);
		testTree.add(38);
		testTree.add(52);

		testTree.deepAllPrint();
		System.out.println("_______________________");
		testTree.breadthAllPrint();



		


	}



}

