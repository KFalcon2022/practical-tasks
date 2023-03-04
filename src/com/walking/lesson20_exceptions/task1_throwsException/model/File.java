package com.walking.lesson20_exceptions.task1_throwsException.model;

public class File {
	private String name;
	private Integer size;
	private InfoType infoType;

	public File(String name, Integer size, InfoType infoType) {
		this.name = name;
		this.size = size;
		this.infoType = infoType;
	}

	public String getName() {
		return name;
	}

	public Integer getSize() {
		return size;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	@Override
	public String toString (){
		return "File: " + getName() + "\nSize: " + getSize() + "\nType: " + getInfoType();
	}
}
