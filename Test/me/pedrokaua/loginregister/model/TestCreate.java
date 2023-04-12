package me.pedrokaua.loginregister.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCreate {
	User user;
	Person person;
	Calendar birth = Calendar.getInstance();
	
	@BeforeEach
	void add() {
		birth.set(Calendar.YEAR, 2004);
		birth.set(Calendar.MONTH, Calendar.SEPTEMBER);
		birth.set(Calendar.DATE, 20);
		
		user = new User("Pedro Kauã Silva dos Santos",
				"Pedro Kawan", "me@example.com", "example123",
				'M', birth);
		
		person = new Person("Pedro Kauã Silva dos Santos",
				'M', birth);
	}
	
	@Test
	void testCreatingUser() {
		
		assertDoesNotThrow(() -> {
			user = new User("Pedro Kauã Silva dos Santos",
				"Pedro Kawan", "me@example.com", "example123",
				'M', birth);
		});
	}
	
	@Test
	void testGettersUser() {
		assertDoesNotThrow(() -> {
			user.getUserName();
			user.getEmail();
			user.getPassword();
		});
	}
	
	@Test
	void testCreatingPerson() {
		
		assertDoesNotThrow(() -> {
			person = new Person("Pedro Kauã Silva dos Santos", 'M', birth);
		});
	}
	
	@Test
	void testAge() {
		assertEquals(18, person.getAge());
	}
	
	
	@Test
	void testGettersPerson() {
		assertDoesNotThrow(() -> {
			person.getName();
			person.getAge();
			person.getGender();
			person.getBirth();
		});
	}
	@Test
	void testBirthdayMoth() {
		birth.set(Calendar.MONTH, 3);
		Person person = new Person("Pedro Kauã Silva dos Santos",
				'M', birth);
		assertEquals(19, person.getAge());
	}
	
	@Test
	void testNotBirthdayDay() {
		birth.set(Calendar.MONTH, 4);
		birth.set(Calendar.DATE, 30);
		Person person = new Person("Pedro Kauã Silva dos Santos",
				'M', birth);
		assertEquals(18, person.getAge());
	}
	
	@Test
	void testHappyBirthdayDay() {
		birth.set(Calendar.MONTH, 4);
		birth.set(Calendar.DATE, 12);
		Person person = new Person("Pedro Kauã Silva dos Santos",
				'M', birth);
		assertEquals(19, person.getAge());
	}
	
	@Test
	void testBirthdayMethod() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2023);
		calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
		calendar.set(Calendar.DATE, 20);
		
		assertFalse(person.happyBirthday());
	}
}
