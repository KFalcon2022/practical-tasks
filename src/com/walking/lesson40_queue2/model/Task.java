package com.walking.lesson40_queue2.model;

public class Task{
	private final String NAME;
	private final int VALUE;
	private final char OPER;

	public Task(String name, int value, char oper) {
		this.NAME = name;
		this.VALUE = value;
		this.OPER = oper;
	}

	public String getNAME() {
		return NAME;
	}

	public int getVALUE() {
		return VALUE;
	}

	public char getOPER() {
		return OPER;
	}
}
