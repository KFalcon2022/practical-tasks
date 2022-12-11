package com.walking.lesson21.Task1;
/*
Опциональное усложнение: номер машины может быть не уникальным.
*/
import com.walking.lesson21.Task1.model.DataBase;
import com.walking.lesson21.Task1.model.Validator;

import java.util.Scanner;

public class Main
{
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final Validator VALIDATOR = new Validator(SCANNER);
	private static final String MSG_SEARCH = "--------\nВведите тип поиска\n(1 - По номеру, 2 - По имени владельца, 3 - По модели):";
	private static final String MSG_EMPTY = "";
	private static final String MSG_RESULT = "Результаты поиска:\n";
	private static final String MSG_ERROR = "Неверный тип поиска:\n";
	private static final String MSG_TYPE1 = "Введите номер в формате RR NNNNNN (10 C651AK): ";
	private static final String MSG_TYPE2 = "Введите имя и фамилию владельца: ";
	private static final String MSG_TYPE3 = "Введите модель машины: ";

	public static void main(String[] args) {

		System.out.println("Давайте поищем машину");
	    DataBase db = new DataBase();
		String queryResult;

		switch (VALIDATOR.requireInt(MSG_SEARCH)) {
			case 1:
				int region = VALIDATOR.requireInt(MSG_TYPE1); // например 10 C651AK
				String number = VALIDATOR.requireString(MSG_EMPTY);
				queryResult = db.queryByNumber(region, number);
				break;

			case 2:
				String ownerName = VALIDATOR.requireString(MSG_TYPE2); // например Вася Пупкин
				String ownerSurname = VALIDATOR.requireString(MSG_EMPTY);
				queryResult = db.queryByOwner(ownerName, ownerSurname);
				break;

			case 3:
				String brand = VALIDATOR.requireString(MSG_TYPE3);
				String model = VALIDATOR.requireString(MSG_EMPTY);
				queryResult = db.queryByBrandModel(brand, model);
				break;

			default:
				queryResult = MSG_ERROR;

		}

		System.out.println(MSG_RESULT);
		System.out.println(queryResult);
		SCANNER.close();
	}
}

/*
Тестовые данные для удобства:
 Ford Focus, 10 C651AK, Вася Пупкин
 Toyota Corolla, 11 G430EA, Петя Смирнов
 */