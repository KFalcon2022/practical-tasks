package com.walking.lesson34_date_time.task1;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException, ParseException {
		String strDate = "20.12.2022 20:16:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

		System.out.println(localDateTime(strDate, formatter).format(formatter));

	}

	private static LocalDateTime localDateTime(String str, DateTimeFormatter formatter) throws ParseException {
		return LocalDateTime.parse(str, formatter);
	}
}
