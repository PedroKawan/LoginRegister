package me.pedrokaua.loginregister.vision.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

import me.pedrokaua.loginregister.vision.RegisterScreen;

public class JPasswordFieldScreen extends JPasswordField{
	private static final long serialVersionUID = 1L;

	public JPasswordFieldScreen(RegisterScreen screen){
        this.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 14));
        this.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent arg0) {
                screen.getInfo();
            }
        });
    }


    
}