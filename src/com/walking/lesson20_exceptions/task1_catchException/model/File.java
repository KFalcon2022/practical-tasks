package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
	
	private String name;
	private long size;
	private FileType fileType;
	
	public File(String name, long size, FileType fileType) {
		this.name = name;
		this.size = size;
		this.fileType = fileType;
	}
	
	@Override
	public String toString() {
		return "File{" +
				"name='" + name + '\'' +
				", size=" + size +
				", fileType=" + fileType +
				'}';
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getSize() {
		return size;
	}
	
	public void setSize(long size) {
		this.size = size;
	}
	
	public FileType getFileType() {
		return fileType;
	}
	
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
}
