package com.walking.lesson34_date_time.task2.model;

import java.util.Scanner;

public class DateTimeReciever {
	private int hours;
	private int minutes;
	private int seconds;
	private int dayNumber;
	private int month;
	private int year;

	public void inputDateTime() {
		Scanner sc = new Scanner(System.in);
		setYear(sc);
		setMonth(sc);
		setDayNumber(sc);
		setHours(sc);
		setMinutes(sc);
		setSeconds(sc);
		sc.close();
	}

	@Override
	public String toString() {

		return addZero(dayNumber) + "." +
				addZero(month) + "." +
				addZero(year) + " " +
				addZero(hours) + ":" +
				addZero(minutes) + ":" +
				addZero(seconds);
	}


	private void setHours(Scanner input) {
		for (; ; ) {
			System.out.print("Введите количество часов (от 0 до 23): ");
			int inputData = input.nextInt();
			if ((inputData < 0) || (inputData > 23)) {
				System.out.println("Ты чё, тупой? ОТ 0 ДО 23!!!\n");
			}else {
				hours = inputData;
				return;
			}
		}
	}

	private void setMinutes(Scanner input) {
		for (; ; ) {
			System.out.print("Введите количество минут (от 0 до 59): ");
			int inputData = input.nextInt();
			if ((inputData < 0) || (inputData > 59)) {
				System.out.println("В часе не может быть меньше 0 и больше 59 минут, бестолочь!\n");
			} else {
				minutes = inputData;
				return;
			}
		}
	}

	private void setSeconds(Scanner input) {
		System.out.print("Введите количество секунд (от 0 до 59): ");
		int inputData = input.nextInt();
		if ((inputData < 0) || (inputData > 59)) {
			System.out.println("Будем считать, что ты ввёл 0");
			seconds = 0;
		} else {
			seconds = inputData;
		}
	}

	private void setYear(Scanner input) {
		for (; ; ) {
			System.out.print("Введите год (полностью): ");
			int inputData = input.nextInt();
			if ((inputData < 0)) {
				System.out.println("Год не может быть отрицательным значением");
				//бывают до н.э и после н.э, но я ёбнусть это делать,
				// так что пишем год от рождества нашего любимого мессии! Аллах бабах!
			} else {
				year = inputData;
				return;
			}
		}
	}

	private void setMonth(Scanner input) {
		for (; ; ) {
			System.out.print("Введите номер месяца: ");
			int inputData = input.nextInt();
			if ((inputData < 0) || (inputData > 12)) {
				System.out.println("В году 12 месяцев, лол!\n");
			} else {
				month = inputData;
				return;
			}
		}
	}

	private void setDayNumber(Scanner input) {
		for (; ; ) {
			System.out.print("Введите число: ");
			int inputData = input.nextInt();
			if (((month == 1) || (month == 3) || (month == 5) || (month == 7)
					|| (month == 8) || (month == 10) || (month == 12)) &&
					((inputData > 0) && (inputData < 32))) {
				dayNumber = inputData;
				return;
			} else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) &&
					((inputData > 0) && (inputData < 31))) {
				dayNumber = inputData;
				return;
			} else if (leapYear() && (((inputData > 0) && (inputData < 30)))) {
				dayNumber = inputData;
				return;
			} else if (!leapYear() && (((inputData > 0) && (inputData < 29)))) {
				dayNumber = inputData;
				return;
			} else {
				System.out.println("""
						Некорректная дата!
						В Январе, Марте, Мае, Июле, Августе, Октябре и Декабре - 31 день.
						В Апреле, Июне, Сентябре и Ноябре - 30 дней.
						В Феврале - 28 дней, но если год високосный - 29 дней.""");
			}
		}
	}

	private boolean leapYear() {
		return (this.year > 1584 && ((this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0)));
	}

	private String addZero(int num){
		if (num < 10){
			return "0" + num;
		}else {
			return Integer.toString(num);
		}
	}
}

