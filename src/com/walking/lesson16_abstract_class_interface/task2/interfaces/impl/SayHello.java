package com.walking.lesson16_abstract_class_interface.task2.interfaces.impl;

import com.walking.lesson16_abstract_class_interface.task2.interfaces.Answer;

public class SayHello implements Answer {
	
	@Override
	public void say() {
		System.out.println("Hello");
	}
}
