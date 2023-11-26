package com.walking.lesson20_exceptions.task1_throwsException;
import com.walking.lesson20_exceptions.task1_throwsException.model.File;

import java.io.FileNotFoundException;

public final class FindFile {

	public static File findFile(File[] files, String name) throws FileNotFoundException {
		File findedFile = null;
			for (File file : files) {
				if (file.getName().equals(name)) {
					findedFile = file;
					break;
				}

			}

			if (findedFile == null){
				throw new FileNotFoundException("File not found!");
			}

			return findedFile;
	}
}
