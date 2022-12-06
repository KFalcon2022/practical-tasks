package com.walking.lesson20_exceptions.task1_catchException.services;

import com.walking.lesson20_exceptions.task1_catchException.data_source.DataSource;
import com.walking.lesson20_exceptions.task1_catchException.model.File;

import java.io.FileNotFoundException;

public class FileServiceImpl implements FileService {
	
	private final DataSource dataSource;
	
	public FileServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public File findFile(String name) throws FileNotFoundException {
		
		for (File file : dataSource.getFiles()) {
			if (file !=null && name.equals(file.getName())) {
				return file;
			}
		}
		throw new FileNotFoundException();
	}
	
	@Override
	public void addFile(File file) {
		dataSource.getFiles()[dataSource.getIndex()] = file;
		dataSource.setIndex(dataSource.getIndex() + 1);
	}
	
	@Override
	public void addFiles(File... files) {
		File[] dataSourceFiles = dataSource.getFiles();
		for (File file : files) {
			dataSourceFiles[dataSource.getIndex()] = file;
			dataSource.setIndex(dataSource.getIndex() + 1);
		}
	}
}
