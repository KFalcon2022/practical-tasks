package com.walking.lesson20_exceptions.task1_throwsException;

import com.walking.lesson20_exceptions.task1_catchException.data_source.DataSource;
import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.FileType;
import com.walking.lesson20_exceptions.task1_catchException.services.FileService;
import com.walking.lesson20_exceptions.task1_catchException.services.FileServiceImpl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		DataSource dataSource = new DataSource();
		FileService fileService = new FileServiceImpl(dataSource);
		initData(fileService);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Введите имя файла: ");
		String fileName = scanner.nextLine();
		
		scanner.close();
		
		File foundFile = fileService.findFile(fileName);
		System.out.println(foundFile);
		
	}
	private static void initData(FileService fileService) {
		File file1 = new File("file1", 15487, FileType.TEXT);
		File file2 = new File("file2", 456874456, FileType.JPEG);
		File file3 = new File("file3", 15456412487L, FileType.TEXT);
		File file4 = new File("file4", 154123187, FileType.AUDIO);
		File file5 = new File("file5", 15123487, FileType.VIDEO);
		File file6 = new File("file6", 1545466487, FileType.JPEG);
		File file7 = new File("file7", 1155, FileType.AUDIO);
		File file8 = new File("file8", 154568776487L, FileType.AUDIO);
		File file9 = new File("file9", 787546877487L, FileType.VIDEO);
		fileService.addFiles(file1, file2, file3, file4, file5, file6, file7, file8, file9);
	}
}
