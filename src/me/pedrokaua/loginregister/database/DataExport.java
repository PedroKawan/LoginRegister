package me.pedrokaua.loginregister.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class DataExport {
	
	public void export(List<String> users, File dataPath){
		try {
//			if(dataPath.exists()) {
//				dataPath.delete();
//			}
			new File(dataPath.getPath()).createNewFile();
			FileWriter data = new FileWriter(dataPath.getPath());
			
			try(BufferedWriter bw = new BufferedWriter(data)) {
				Iterator<String> iterator = users.iterator();
				
				while(iterator.hasNext()) {
					try {
						bw.write(iterator.next());
						bw.newLine();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				//lambda method
//				users.forEach(user -> {
//					try {
//						bw.write(user);
//						bw.newLine();
//					} catch (Exception e) {
//						System.out.println(e.getMessage());
//					}
//				});
				bw.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

