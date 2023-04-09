package com.walking.lesson33_files_2.task1;

import com.walking.lesson33_files_2.task1.model.Car;
import java.io.*;

public class WriterCarsToFile {
	Car[] cars;
	public WriterCarsToFile(Car[] cars) {
	this.cars = cars;
	}

	public void writeToFileUsingFileWriter() throws IOException {
		try (FileWriter writer = new FileWriter("./resources/carCatalog_33.1-1.txt", false))
		{
			writer.write(textForWrite());
			System.out.println("The file has been written.");
			writer.flush();
		}
	}

	public void writeToFileUsingBufferedOutputStream() throws IOException {
		try (FileOutputStream out = new FileOutputStream("./resources/carCatalog_33.1-2.txt");
				BufferedOutputStream bos = new BufferedOutputStream(out))
		{
			byte[] buffer = textForWrite().getBytes();
			bos.write(buffer, 0, buffer.length);
			System.out.println("The file has been written.");
		}
	}

	public void writeToFileUsingBufferedWriter() throws IOException{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/carCatalog_33.1-3.txt")))
		{
			bw.write(textForWrite());
		}
	}

	private String textForWrite(){
		StringBuilder text = new StringBuilder();
		for (Car car : cars) {
			text.append(car.stringForFile()).append("\n");
		}
		return text.toString();
	}
}
