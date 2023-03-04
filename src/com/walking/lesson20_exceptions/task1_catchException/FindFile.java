package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;

import java.io.FileNotFoundException;

public final class FindFile {

	public static File findFile(File[] files, String name){
		File findedFile = null;
		try {
			for (File file : files) {
				if (file.getName().equals(name)) {
					findedFile = file;
					break;
				}
			}

			if (findedFile == null) {
				throw new FileNotFoundException();
			}

			return findedFile;
		}catch (FileNotFoundException e){
			System.err.println("File not found!");
			throw new RuntimeException();
		}
	}
}
