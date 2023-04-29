package me.pedrokaua.loginregister.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
	
	private String name;
	private int age;
	private char gender;
	private LocalDate birth;
	
	public Person(String name, char gender, LocalDate birth) {
		this.setName(name);
		this.setGender(gender);
		this.setBirth(birth);
		birth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.defineAge(birth);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void defineAge(LocalDate birth) {
		LocalDate date = LocalDate.now();
		//Birthday verification
		int newAge = date.getDayOfMonth() - birth.getDayOfMonth();
		boolean monthSmaller = date.getMonthValue() < birth.getMonthValue();
		boolean monthEquals = date.getMonthValue() == birth.getMonthValue();
		boolean daySmaller = date.getDayOfMonth() < birth.getDayOfMonth();
		
		
		if(monthSmaller) {
			newAge--;
		} else if(monthEquals) {
			if (daySmaller) {
				newAge--;
			}
		}
		
		this.setAge(newAge);
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	public boolean happyBirthday() {
		LocalDate date = LocalDate.now();
		
		
		boolean monthBirthday = birth.getMonthValue() == date.getMonthValue();
		boolean dayBirthday = birth.getDayOfMonth() == date.getDayOfMonth();
		
		if(monthBirthday && dayBirthday) {
			this.setAge(this.getAge() + 1);
			return true;
		}
		
		return false;
	}
}
