package com.walking.lesson39_queue1.task1;

import com.walking.lesson39_queue1.task1.model.SingleLinkedList;


/**
 * Реализуйте односвязный список (можно использовать реализацию в рамках
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson28_generics1/task4/structure/Stack.java">...</a>).
 * <p>
 * Реализуйте метод, разворачивающий односвязный список
 * (первый элемент должен стать последним, второй – предпоследним и т.д.).
 * <p>
 * Также реализуйте метод, удаляющий все узлы, хэшкод элемента которых - четный.
 */
public class Main {
	public static void main(String[] args) {

		SingleLinkedList<String> list = new SingleLinkedList<>();
		list.add("bvsdsdg");
		list.add("uignmf");
		list.add("yufdn");
		list.add("hgfghf");
		list.add("ewqwewq");
		list.add("zxczxc");
		list.add("qweqwe");
		list.add("asdasd");

		System.out.println(list);
		System.out.println(list.hashAllNodes());
		list.removeEvenHashNodes();
		System.out.println(list.hashAllNodes());
		list.reverse();
		System.out.println(list);

	}
}
