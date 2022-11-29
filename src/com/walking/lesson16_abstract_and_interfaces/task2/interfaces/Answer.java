package com.walking.lesson16_abstract_and_interfaces.task2.interfaces;

public interface Answer {
	
	default void  say() {
		System.out.println("Unknown message");
	};
	
}
