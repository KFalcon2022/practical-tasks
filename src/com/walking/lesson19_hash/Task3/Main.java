package com.walking.lesson19_hash.Task3;
/*
Опциональное усложнение: номер машины может быть не уникальным.
*/
import com.walking.lesson19_hash.Task3.model.DataBase;
import com.walking.lesson19_hash.Task3.model.Validator;

public class Main
{

	public static void main(String[] args) {

		System.out.println("Давайте поищем машину");
	    DataBase db = new DataBase();

	    int searchRegion = Validator.requireInt("Введите номер в формате RR NNNNNN: "); // например 10 C651AK
	    String searchNumber = Validator.requireString("");

		String found = db.query(searchRegion, searchNumber);
		System.out.println("Результаты поиска:\n");
        System.out.println(found);
	}

}
