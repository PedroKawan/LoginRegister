package me.pedrokaua.loginregister.vision.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import me.pedrokaua.loginregister.vision.Screen;

public class JButtonScreen extends JButton implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	Screen screen;
	
	public JButtonScreen(Screen screen) {
		this.screen = screen;
	}
	
    public void mouseClicked(MouseEvent arg0) {
    	boolean run = screen.getInfo();
    	if (run) {
    		screen.dispose();
//    		screen.database.clear();
    		screen.entered();
    	} else {
    		JOptionPane.showMessageDialog(screen, "Incorrect argumentisin!");
    	}
    }
    public void mouseEntered(MouseEvent arg0) {
    	this.setForeground(new Color(100, 200, 255));
    }
    public void mouseExited(MouseEvent arg0) {
    	this.setForeground(Color.WHITE);
    }
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}

}
