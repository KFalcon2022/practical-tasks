package com.walking.lesson30_regex.task2.model;

public class FullName {
	private String firstName;   //Имя
	private String lastName;    //Фамилия
	private String surname;     //Отчество


	public FullName(String firstName, String lastName, String surname) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.surname = surname;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}




}


/*//correct
Римский-Корсаков Николай Андреевич
Чайковский Пётр Ильич


//incorrect
Римский-корсаков Николай Андреевич
чайковский пётр ильич

 */