package com.walking.lesson28_generics1.task3.model;

import com.walking.lesson28_generics1.task3.exceptions.ValueNotFoundException;

import java.io.FileNotFoundException;

public class FindingValueInArray<T>{
	private final T[] arr;
	private final T searchVal;

	public FindingValueInArray(T[] arr, T searchVal) {
		this.arr = arr;
		this.searchVal = searchVal;
	}

	public T[] getArr() {
		return arr;
	}

	public T getSearchVal() {
		return searchVal;
	}

	public T findVal (T[] arr, T val) throws ValueNotFoundException {
		for (T value : arr) {
			if (value == val) {
				return value;
			}

		}
		throw new ValueNotFoundException("Value not found!");
	}

}
