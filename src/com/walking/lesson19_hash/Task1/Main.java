package com.walking.lesson19_hash.Task1;

/*
Реализуйте класс «Машина». Поля допустимо выбрать на свое усмотрение, но необходимо, чтобы по ним можно было однозначно идентифицировать каждую машину. Скажем, в рамках базы ГАИ.
Создайте массив машин. Реализуйте максимально эффективную проверку на вхождение машины в ваш массив. Данные для проверки необходимо запрашивать с клавиатуры.
Если машина найдена — выведите ее строковое представление в консоль.
Опциональное усложнение: номер машины может быть не уникальным.
*/
import java.util.Scanner;

public class Main
{
    public static final Scanner SCANNER = new Scanner(System.in);
    
	public static void main(String[] args) {
	    Car[] cars = {
	        new Car(CarModel.FORD_FOCUS, "C651AK", Region.KARELIA, "Вася"),
	        new Car(CarModel.TOYOTA_COROLLA, "G430EA", Region.KOMI, "Петя"),
	        new Car(CarModel.LADA_SEDAN, "D493WF", Region.ASTRAHAN, "Катя"),
	        new Car(CarModel.TOYOTA_COROLLA, "V159QF", Region.MOSOBL50, "Маша"),
	        new Car(CarModel.KIA_RIO, "V464AS", Region.PSKOV, "Саша"),
	        new Car(CarModel.KIA_RIO, "Z649FE", Region.KALUGA, "Лупа"),
	        new Car(CarModel.PEUGEOUT_BOXER, "M159RG", Region.YANAO, "Пупа"),
	        new Car(CarModel.PEUGEOUT_BOXER, "H357LL", Region.SARATOV64, "Лёлек"),
	        new Car(CarModel.TOYOTA_COROLLA, "O000OO", Region.KURSK, "Болек"),
	        new Car(CarModel.MERCEDES_BENZ, "Z777RU", Region.MOSCOW77, "Вова"),
	        new Car(CarModel.RENAULT_LOGAN, "Q464HG", Region.TOMSK, "Яна")
	    };

	    System.out.println("Давайте поищем машину");
	    System.out.print("Введите строку поиска: ");
	    String search = SCANNER.next();
		
		// Попробуем точный поиск по номеру машины
        boolean found = searchByNumber(cars, search);
        
        // Уточняющий поиска
        if (!found) {
            System.out.println("По номеру ничего не найдено, давайте поищем проще");
            int result = searchByFields(cars, search);
            System.out.printf("Найдено машин: %d\n", result);
        }
        
        System.out.println("Поиск завершен.");        
	}
	
	public static boolean searchByNumber(Car[] cars, String search) {
		for (Car c : cars) {
		    if (c.equals(search)){
		        System.out.println("Машина найдена по регистрационному номеру");
	            System.out.println(c);
	            return true;
		    }
	    }
	    return false;
	}
	
	public static int searchByFields(Car[] cars, String search) {
	    int result = 0;
		for (Car c : cars) {
		    if (c.fieldSearch(search)){
	            System.out.println(c);
	            result++;
		    }
	    }
	    return result;
	}
}
