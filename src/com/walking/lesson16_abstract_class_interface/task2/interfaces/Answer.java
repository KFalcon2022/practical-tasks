package com.walking.lesson16_abstract_class_interface.task2.interfaces;

public interface Answer {
	
	default void  say() {
		System.out.println("Unknown message");
	};
	
}