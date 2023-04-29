package me.pedrokaua.loginregister.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import me.pedrokaua.loginregister.exception.DataFileNotFoundException;

public class DataReader {
	
	
	public List<String> reader(File file){
		List<String> lines = new ArrayList<>();
		try {
			FileReader data = new FileReader(file);
			
			try(BufferedReader br = new BufferedReader(data)) {
				String lineData = br.readLine();
				while(lineData != null) {
					if(!lines.contains(lineData)) {
						lines.add(lineData);
					}
					lineData = br.readLine();
				}
				br.close();
				return lines;
				
			} catch(Exception e) {
				throw new RuntimeException("BufferedReader error");
			}
			
		} catch(Exception e) {
			throw new DataFileNotFoundException();
		}
		
	}

	
}
