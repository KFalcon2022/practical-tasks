package com.walking.lesson20_exceptions.task1_catchException.data_source;

import com.walking.lesson20_exceptions.task1_catchException.model.File;

public class DataSource {
	
	private File[] files = new File[12];
	private int index = 0;
	
	public File[] getFiles() {
		return files;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	//Представим тут другие полезные
}
