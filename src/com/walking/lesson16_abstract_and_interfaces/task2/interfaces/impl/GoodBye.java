package com.walking.lesson16_abstract_and_interfaces.task2.interfaces.impl;

import com.walking.lesson16_abstract_and_interfaces.task2.interfaces.Answer;

public class GoodBye implements Answer {
	
	@Override
	public void say() {
		System.out.println("Good bye");
	}
}
