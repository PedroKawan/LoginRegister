package me.pedrokaua.loginregister.vision;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLoginScreen {
	
	LoginScreen screen;

	@BeforeEach
	void add() {
		screen = new LoginScreen();
	}
	
	@Test
	void testCreatingScreen() {
		assertDoesNotThrow(() -> screen = new LoginScreen());
	}
	
	@Test
	void testGetInfos() {
		assertEquals("{;}", screen.getInfo());
	}

}
