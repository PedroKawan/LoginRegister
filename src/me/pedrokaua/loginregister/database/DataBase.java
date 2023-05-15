package me.pedrokaua.loginregister.database;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.pedrokaua.loginregister.model.User;

public class DataBase {
	
	public static DataBase instance = new DataBase();
	
	private File dataFile =
				new File("src/me/pedrokaua/loginregister/database/data.txt");
	
	private List<User> users = new ArrayList<>();
	private List<Map<String,String>> usersListAttributes;
	
	private DataBase(){
		ArrayList<String> list = (ArrayList<String>) DataBaseUtilities
				.getReaderInstance().reader(dataFile);
		
		usersListAttributes = new ArrayList<>(DataBaseUtilities
				.getRegexInstance().filter(list));
		
		usersListAttributes.forEach(l -> 
			addUser(userFormatCompiler(l)));
	}

	
	public void addUser(User user) {
		if(!(users.contains(user))) {
			users.add(user);
		} else {
			
		}
	}
	
	public void clear() {
		exportData();
		users.clear();
		usersListAttributes.clear();
	}
	public void refresh() {
		exportData();
		users.clear();
		importData();
	}
	
	public void importData() {
		ArrayList<String> list = (ArrayList<String>) DataBaseUtilities
				.getReaderInstance().reader(dataFile);
		
		usersListAttributes = new ArrayList<>(DataBaseUtilities
				.getRegexInstance().filter(list));
		
		usersListAttributes.forEach(l -> 
			users.add(userFormatCompiler(l)));
	}
	
	public void exportData() {
		ArrayList<String> list = new ArrayList<>();
		
		users.forEach(u -> list.add(dataFormatCompiler(u)));
		
		DataBaseUtilities.getExportInstance()
		.export(list, dataFile);
	}
	
	public void setDataFile(String path) {
		dataFile = new File(path);
	}
	
	public void setDataFile(File pathFile) {
		dataFile = pathFile;
	}

	public File getDataFile() {
		return dataFile;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public static DataBase getInstance() {
		return instance;
	}
	
	public List<Map<String, String>> getUsersAttributes() {
		return usersListAttributes;
	}
	
	public static String dataFormatCompiler(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("namecomplete=");
		sb.append(user.getName() + ";");
		sb.append("username=");
		sb.append(user.getUserName() + ";");
		sb.append("gender=");
		sb.append(user.getGender() + ";");
		
		sb.append("birthdate=");
		sb.append(user.getBirth().toString());
		sb.append(";");
		
		sb.append("email=");
		sb.append(user.getEmail() + ";");
		sb.append("password=");
		sb.append(user.getPassword() + ";");
		sb.append("}");
		return sb.toString();
	}
	
	public static User userFormatCompiler(Map<String, String> list) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate birthdate = LocalDate.parse(list.get("birthdate"), f);
		
		String namecomplete = list.get("namecomplete");
		String username = list.get("username");
		char gender = list.get("gender").charAt(0);
		String email = list.get("email");
		String password = list.get("password");
		
		User user = new User(
				namecomplete,
				username,
				gender,
				birthdate,
				email,
				password
				);
		
		return user;
	}

}
