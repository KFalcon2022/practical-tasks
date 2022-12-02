package com.walking.lesson19_hash.Task2;
/*
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
	    // например 10 C651AK
	    System.out.print("Введите номер в формате RR NNNNNN: ");
	    int searchRegion = SCANNER.nextInt();
	    String searchNumber = SCANNER.next();
		
        boolean found = searchByNumber(cars, searchRegion, searchNumber);
        
        System.out.println("Поиск завершен.");        
	}
	
	public static boolean searchByNumber(Car[] cars, int searchRegion, String searchNumber) {
	    Region region = Validator.validateRegion(searchRegion);
	    String search = region + searchNumber;
		for (Car c : cars) {
		    if (c.equals(search)){
		        System.out.println("Машина найдена по регистрационному номеру");
	            System.out.println(c);
	            return true;
		    }
	    }
	    System.out.println("Ничего не найдено");
	    return false;
	}

}
