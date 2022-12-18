package com.walking.lesson31.Task1;

import com.walking.lesson31.Task1.model.DataBase;
import com.walking.lesson31.Task1.model.Validator;
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
		System.out.println("Загружена база данных. Количество машин: " + db.getSize());

		String queryResult = "";
		boolean searching = true;

		while (searching) {
			switch (VALIDATOR.requireInt(MSG_SEARCH)) {
				case 1: {
					int region = VALIDATOR.requireInt(MSG_TYPE1); // например "10 C651AK"
					String number = VALIDATOR.requireWord(MSG_EMPTY);
					queryResult = db.queryByNumber(region, number);
					break;
				}

				case 2: {
					String owner = VALIDATOR.requireString(MSG_TYPE2); // например "Пупкин Василий Васильевич"
					queryResult = db.queryByOwner(owner);
					break;
				}

				case 3: {
					String brand = VALIDATOR.requireWord(MSG_TYPE3);
					String model = VALIDATOR.requireWord(MSG_EMPTY);
					queryResult = db.queryByBrandModel(brand, model);
					break;
				}

				case 9: {
					int region = VALIDATOR.requireInt(MSG_TYPE1);
					String number = VALIDATOR.requireWord(MSG_EMPTY);
					String brand = VALIDATOR.requireWord(MSG_TYPE3);
					String model = VALIDATOR.requireWord(MSG_EMPTY);
					String owner = VALIDATOR.requireString(MSG_TYPE2);
					db.add(region, number, brand, model, owner);
					break;
				}

				default:
					queryResult = MSG_ERROR;
					searching = false;
			}

			System.out.println(MSG_RESULT);
			System.out.println(queryResult);
		}

		SCANNER.close();
	}
}

/*
Тестовые данные для удобства:
 Ford Focus, 10 C651AK, Вася Пупкин
 Toyota Corolla, 11 G430EA, Петя Смирнов
 */