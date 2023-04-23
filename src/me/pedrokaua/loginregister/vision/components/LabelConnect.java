package me.pedrokaua.loginregister.vision.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import me.pedrokaua.loginregister.vision.LoginScreen;
import me.pedrokaua.loginregister.vision.RegisterScreen;
import me.pedrokaua.loginregister.vision.Screen;

public class LabelConnect extends JLabel implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	Screen screenCurrent;
	Screen screen;
	
	public LabelConnect(Screen screenCurrent,Screen screen){	
		this.screenCurrent = screenCurrent;
		this.screen = screen;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		screenCurrent.dispose();
		if (screenCurrent instanceof LoginScreen) {
			screen = new RegisterScreen();
		} else {
			screen = new LoginScreen();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setForeground(Color.CYAN);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setForeground(Color.WHITE);
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
