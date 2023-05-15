package me.pedrokaua.loginregister.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.pedrokaua.loginregister.exception.DataRegexException;

public class DataRegex {
	
	private Pattern PATTERN_ITENS = Pattern.compile("(.+?)=(.*?);");
	
	List<Map<String,String>> list = new ArrayList<>();
	Map<String,String> mapItens;
	
	public List<Map<String,String>> filter(List<String> lines){
		
		try {
			lines.forEach(line -> {
				line = line.substring(1, line.length());
				Matcher matcher = PATTERN_ITENS.matcher(line);
				mapItens = new HashMap<>();
				
				while (matcher.find()) {
					String attribute = matcher.group(1);
					String value = matcher.group(2);
					mapItens.put(attribute, value);
				}
				
				list.add(mapItens);
			});
		} catch(Exception e) {
			throw new DataRegexException();
		}
		
		
		return list; 
	}
}
