package com.walking.lesson33_files_2.task2;

import java.io.*;

public class ReaderCarsFromFile {
	String path;
	public ReaderCarsFromFile(String path) {
		this.path = path;
	}

	public String readFileUsingFileReader() throws IOException {
		StringBuilder text = new StringBuilder();

		try(FileReader reader = new FileReader(path)){
			int c;
			while ((c = reader.read())!=-1){
				text.append(((char) c));
			}
		}
		return text.toString();
	}

	public String readFileUsingBufferedInputStream() throws IOException{
		StringBuilder text = new StringBuilder();
		byte[] buffer = readFileUsingFileReader().getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(buffer);

		try(BufferedInputStream bis = new BufferedInputStream(in)){
			int c;
			while ((c = bis.read())!=-1){
				text.append(((char) c));
			}
		}
		return text.toString();
	}

	public String readFileUsingBufferedReader() throws IOException{
		StringBuilder text = new StringBuilder();

		try(BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			int c;
			while ((c = br.read())!=-1){
				text.append(((char) c));
			}
		}
		return text.toString();
	}
}
