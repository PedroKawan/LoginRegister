package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import me.pedrokaua.loginregister.vision.components.JButtonScreen;
import me.pedrokaua.loginregister.vision.components.JPasswordFieldScreen;
import me.pedrokaua.loginregister.vision.components.LabelConnect;
import me.pedrokaua.loginregister.vision.components.TextFieldScreen;

public class LoginScreen extends Screen{
	private static final long serialVersionUID = 1L;

	TextFieldScreen email;
	JPasswordFieldScreen password;

	JLabel emailLabel, passwordLabel;
	LabelConnect connectionScreens;
	
	JButtonScreen button;
	
	RegisterScreen registerScreen;
	
	public LoginScreen(){
		define();
		creatingTextField();
		creatingLabel();
		creatingButton();
		creatingConnectScreen();
		
		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});
	}
	

	protected void define() {
    	// 'Screen' attributes
        labelLateral.setText("LOGIN");
        this.setTitle("LOGIN SCREEN");
        labelCentral.setText("Hello user!");
        labelCentral.setLocation(60, labelCentral.getY());
        try {
        	imageLateral =
        			new ImageIcon("src/me/pedrokaua/loginregister/imagens/login.png");
        } catch(Exception e) {
        	System.out.println("add image path");
        }
        panelLateralGradient 
        	= new GradientPaint(0, 0, new Color(100, 200, 255), 300, 600, new Color(10, 10, 200));
    }

	private void creatingTextField() {
		email = new TextFieldScreen(this);
        email.setBounds(140, 160, 300, 30);
        
        password = new JPasswordFieldScreen(this);
        password.setBounds(140, 260, 300, 30);
        
        this.add(email);
        this.add(password);
	}
	
	
	void creatingLabel() {
    	// Labels ('Email' 'Password')
        emailLabel = new JLabel();
        emailLabel.setText("Email");
        emailLabel.setBounds(140, email.getY() - 25, 100, 20);
        emailLabel.setForeground(Color.WHITE);
        
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(140, password.getY() - 25, 100, 20);
        passwordLabel.setForeground(Color.WHITE);
        
		this.add(emailLabel);
	    this.add(passwordLabel);
    }
	
	private void creatingConnectScreen() {
		//Connect 'register and login' screens with label
		connectionScreens = new LabelConnect(this, registerScreen);
        connectionScreens.setText("Register now!");
        connectionScreens.setBounds(340, 334, 100, 20);
        connectionScreens.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        connectionScreens.setForeground(Color.WHITE);
        connectionScreens.addMouseListener(connectionScreens);
        
		this.add(connectionScreens);
	}

	
	void creatingButton(){
    	// Button 'Register now'
        button = new JButtonScreen(this);
        button.setText("Sign in");
        button.setBounds(140, 330, 120, 30);
        button.setBackground(new Color(100, 100, 100));
        button.setForeground(new Color(255, 255, 255));
        button.setBorder(BorderFactory.createBevelBorder(0));
        button.addMouseListener(button);
        this.add(button);
    }
	
	
	@SuppressWarnings("deprecation")
	@Override
	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(email.getText());
		sb.append(";");
		sb.append(password.getText());		
		sb.append("}");
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new LoginScreen();
	}
	
}
