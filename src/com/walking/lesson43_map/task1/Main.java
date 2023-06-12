package com.walking.lesson43_map.task1;

import com.walking.lesson43_map.task1.excption.RegexValidationException;
import java.util.*;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого из уникальных слов
 * во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 * <p>
 */

public class Main {
	public static final String WORDS_REGEX = "[a-z-\\s]+";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter words: ");
		String words = scanner.nextLine()
				.trim()
				.toLowerCase();

		scanner.close();

		if (!words.matches(WORDS_REGEX)) {
			throw new RegexValidationException(words, WORDS_REGEX);
		}

		String[] wordArray = words.split("\\s+");
		Map <String, Integer>  map = new HashMap<>();

		for (String word: wordArray) {
			if (!map.containsKey(word)){
				map.put(word, 1);
			}else {
				map.put(word, map.get(word) + 1);
			}
		}

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for (Object obj : set) {
			System.out.println(obj);
		}
	}
}
