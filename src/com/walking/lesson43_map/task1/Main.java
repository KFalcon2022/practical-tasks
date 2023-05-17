package com.walking.lesson43_map.task1;

import java.util.Objects;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого из уникальных слов
 * во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 * <p>
 * "0"||"1"||"2"||"3"||"4"||"5"||"6"||"7"||"8"||"9"
 */
public class Main {
	public static void main(String[] args) {
		String str = " adad 123 kldfk";
		System.out.println(myAtoi(str));

	}

	public static int myAtoi(String s) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				str.append(s.charAt(i));
			}
		}
		String[] strArr = new String[str.length()];
		switch (strArr[0]){
			case "-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9":

		}


		return 0;
	}

/*		if (!str.isEmpty()){
			StringBuilder strResult = new StringBuilder();
			switch (str.charAt(0)) {
				case '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
					for (int i = 0; i < str.length(); i++) {
						switch (s.charAt(i)) {
							case '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> strResult.append(s.charAt(i));
						}
					}
				}
				default -> {
					return 0;
				}
			}
			return Integer.parseInt(strResult.toString());
		}else {
			return 0;
		}*/
}
