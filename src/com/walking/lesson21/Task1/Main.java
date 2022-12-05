package com.walking.lesson21.Task1;
/*
Опциональное усложнение: номер машины может быть не уникальным.
*/
import com.walking.lesson21.Task1.model.DataBase;
import com.walking.lesson21.Task1.model.Validator;

public class Main
{
	private static final String MSG_SEARCH = "--------\nВведите тип поиска\n(1 - По номеру, 2 - По имени владельца, 3 - По модели):";
	private static final String MSG_EMPTY = "";
	private static final String MSG_RESULT = "Результаты поиска:\n";
	private static final String MSG_ERROR = "Неверный тип поиска:\n";
	private static final String MSG_TYPE1 = "Введите номер в формате RR NNNNNN (10 C651AK): ";
	private static final String MSG_TYPE2 = "Введите имя и фамилию владельца (или часть): ";
	private static final String MSG_TYPE3 = "Введите модель машины (или часть): ";

	public static void main(String[] args) {

		System.out.println("Давайте поищем машину");
	    DataBase db = new DataBase();
		String queryResult;

		switch (Validator.requireInt(MSG_SEARCH)) {
			case 1:
				int searchRegion = Validator.requireInt(MSG_TYPE1); // например 10 C651AK
				String searchNumber = Validator.requireString(MSG_EMPTY);
				queryResult = db.queryByNumber(searchRegion, searchNumber);
				break;

			case 2:
				String searchOwner = Validator.requireString(MSG_TYPE2);
				queryResult = db.queryByOwner(searchOwner);
				break;

			case 3:
				String searchModel = Validator.requireString(MSG_TYPE3);
				queryResult = db.queryByModel(searchModel);
				break;

			default:
				queryResult = MSG_ERROR;

		}

		System.out.println(MSG_RESULT);
        System.out.println(queryResult);
	}

}
