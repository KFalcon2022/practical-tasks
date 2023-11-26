package com.walking.lesson28_generics1.task2.model;

import java.util.Objects;

public class Generic <T> {
	private T obj;

	public Generic(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public boolean nullCheck (T obj){
		return obj != null;
	}
}
