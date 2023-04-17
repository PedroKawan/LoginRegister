package me.pedrokaua.loginregister.vision;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestLoginScreen {

	RegisterScreen screen; 

	@BeforeEach
	void add() {
		screen = new RegisterScreen();
	}
	
	
	@Test
	void testCreatingScreen() {
		assertDoesNotThrow(() -> 
			screen = new RegisterScreen());
	}
	
	@Test
	void testGetInfo() {
		assertEquals(";;;;", screen.getInfo());
	}
	
}
