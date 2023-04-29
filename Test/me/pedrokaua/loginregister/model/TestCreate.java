package me.pedrokaua.loginregister.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCreate {
	User user;
	Person person;
	LocalDate birth;
	
	@BeforeEach
	void add() {
		LocalDate date = LocalDate.of(2004, 9, 20);
		user = new User("Pedro Kauã Silva dos Santos", "Pedro Kawan",
				'M', date, "me@example.com", "example123");
		
		person = new Person("Pedro Kauã Silva dos Santos",
				'M', date);
	}
	
	@Test
	void testCreatingUser() {
		
		assertDoesNotThrow(() -> {
			user = new User("Pedro Kauã Silva dos Santos", "Pedro Kawan",
					'M', birth, "me@example.com", "example123");
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
		birth = LocalDate.of(birth.getYear(), 3, 20);
		Person person = new Person("Pedro Kauã Silva dos Santos",
				'M', birth);
		assertEquals(19, person.getAge());
	}
	
	@Test
	void testNotBirthdayDay() {
		birth = LocalDate.of(birth.getYear(), 4, 30);
		Person person = new Person("Pedro Kauã Silva dos Santos",
				'M', birth);
		assertEquals(18, person.getAge());
	}
	
	@Test
	void testHappyBirthdayDay() {
		birth = LocalDate.of(birth.getYear(), 4, 12);
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
