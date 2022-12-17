package com.walking.lesson31.Task1;
/*
Опциональное усложнение: номер машины может быть не уникальным.
*/
import com.walking.lesson31.Task1.model.DataBase;
import com.walking.lesson31.Task1.model.Validator;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final Validator VALIDATOR = new Validator(SCANNER);
	public static final String DB_FILE = "./resources/car_database.bin";
	private static final String MSG_SEARCH = "--------\nВведите тип поиска\n(1 - По номеру, 2 - По имени владельца, 3 - По модели, 9 - добавить машину):";
	private static final String MSG_EMPTY = "";
	private static final String MSG_RESULT = "Результаты поиска:\n";
	private static final String MSG_ERROR = "Неверный тип поиска:\n";
	private static final String MSG_TYPE1 = "Введите номер в формате RR NNNNNN (10 C651AK): ";
	private static final String MSG_TYPE2 = "Введите имя и фамилию владельца: ";
	private static final String MSG_TYPE3 = "Введите модель машины: ";

	public static void main(String[] args) {

	    DataBase db = new DataBase(DB_FILE);
		System.out.println("Загружена база данных. Машин - " + db.getSize());

		String queryResult = "";
		System.out.println("Давайте поищем машину");

		switch (VALIDATOR.requireInt(MSG_SEARCH)) {
			case 1: {
				int region = VALIDATOR.requireInt(MSG_TYPE1); // например 10 C651AK
				String number = VALIDATOR.requireString(MSG_EMPTY);
				queryResult = db.queryByNumber(region, number);
				break;
			}

			case 2: {
				String ownerName = VALIDATOR.requireString(MSG_TYPE2); // например Вася Пупкин
				String ownerSurname = VALIDATOR.requireString(MSG_EMPTY);
				queryResult = db.queryByOwner(ownerName, ownerSurname);
				break;
			}

			case 3: {
				String brand = VALIDATOR.requireString(MSG_TYPE3);
				String model = VALIDATOR.requireString(MSG_EMPTY);
				queryResult = db.queryByBrandModel(brand, model);
				break;
			}

			case 9: {
				int region = VALIDATOR.requireInt(MSG_TYPE1);
				String number = VALIDATOR.requireString(MSG_EMPTY);
				String brand = VALIDATOR.requireString(MSG_TYPE3);
				String model = VALIDATOR.requireString(MSG_EMPTY);
				String ownerName = VALIDATOR.requireString(MSG_TYPE2);
				String ownerSurname = VALIDATOR.requireString(MSG_EMPTY);
				db.add(region, number, brand, model, ownerName, ownerSurname);
				break;
			}

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