package com.walking.lesson20_exceptions.task1_throwsException.services;

import com.walking.lesson20_exceptions.task1_throwsException.model.File;

import java.io.FileNotFoundException;

public interface FileService {
	
	File findFile(String name) throws FileNotFoundException;
	
	void addFile(File file); //вообще бросаем ексепшен если не можем добавить файл ибо нет места, но это потом
	
	void addFiles(File... files);
}
