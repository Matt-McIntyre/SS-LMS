package com.ss.lms.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataFileIO {

	private Map<String, String> dirs;
	private static DataFileIO instance = null;

	private DataFileIO() {
		this.dirs = new HashMap<String, String>();
		dirs.put("AuthFile", "resources/datafiles/authors.txt");
		dirs.put("PubFile", "resources/datafiles/publishers.txt");
		dirs.put("BookFile", "resources/datafiles/books.txt");		
	}
	
	public static DataFileIO getInstance() {
		if (instance == null) {
			instance = new DataFileIO();
		}
		return instance;
	}

	public List<String> load(String type) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dirs.get(type)))) {
			return bufferedReader.lines().collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.<String> emptyList();			
		} 
	}

	public void save(List<String> records, String type) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(records.stream().reduce("", (output, record) -> output + record + System.lineSeparator()));
		try (FileWriter fileWriter = new FileWriter(new File(dirs.get(type)))) {
			fileWriter.write(stringBuffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
