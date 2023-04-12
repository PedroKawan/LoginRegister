package me.pedrokaua.loginregister.model;

import java.util.Calendar;

public class Person {
	
	private String name;
	private int age;
	private char gender;
	private Calendar birth;
	
	public Person(String name, char gender, Calendar birth) {
		this.setName(name);
		this.setGender(gender);
		this.setBirth(birth);
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
	
	public void defineAge(Calendar birth) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.MONTH, date.get(Calendar.MONTH) + 1);
		//Birthday verification
		int newAge = date.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		boolean monthSmaller = date.get(Calendar.MONTH) < birth.get(Calendar.MONTH);
		boolean monthEquals = date.get(Calendar.MONTH) == birth.get(Calendar.MONTH);
		boolean daySmaller = date.get(Calendar.DATE) < birth.get(Calendar.DATE);
		
		
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
	public Calendar getBirth() {
		return birth;
	}
	public void setBirth(Calendar birth) {
		this.birth = birth;
	}
	
	public boolean happyBirthday() {
		Calendar date = Calendar.getInstance();
		
		boolean monthBirthday = birth.get(Calendar.MONTH) == date.get(Calendar.MONTH);
		boolean dayBirthday = birth.get(Calendar.DATE) == date.get(Calendar.DATE);
		
		if(monthBirthday && dayBirthday) {
			this.setAge(this.getAge() + 1);
			return true;
		}
		
		return false;
	}
}
