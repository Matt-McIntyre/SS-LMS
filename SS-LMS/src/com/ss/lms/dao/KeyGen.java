package com.ss.lms.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class KeyGen {

	private static KeyGen instance = null;
	private final String dir = "resources/datafiles/keyGen.txt";
	private Integer nextKey;

	private KeyGen() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dir))) {
			nextKey = Integer.parseInt(bufferedReader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static KeyGen getInstance() {
		if (instance == null) {
			instance = new KeyGen();
		}
		return instance;
	}

	public Integer getKey() {
		nextKey++;
		try (FileWriter fileWriter = new FileWriter(new File(dir))) {
			fileWriter.write(nextKey.toString());
			return nextKey;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
