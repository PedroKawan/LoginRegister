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

@SuppressWarnings("serial")
public class RegisterScreen extends Screen {
	TextFieldScreen nameComplete, nameUser, date, email;
    JPasswordFieldScreen password, confirm;
    
    JLabel nameCompleteLabel, nameUserLabel, dateLabel, emailLabel, passwordLabel, confirmLabel;
    LabelConnect connectionScreens;
    
    JButtonScreen button;
    
    LoginScreen loginScreen;
    
    public RegisterScreen(){
        define();
        creatingLabel();
        cretingButton();
        creatingTextField();
        creatingConnectScreen();
        
        SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});
    }
    
    protected void define() {
    	// 'Screen' attributes
        labelLateral.setText("REGISTER");
        this.setTitle("REGISTER SCREEN");
        labelCentral.setText("Welcome");
        try {
        	imageLateral =
        			new ImageIcon("src/me/pedrokaua/loginregister/imagens/register.png");
        } catch(Exception e) {
        	System.out.println("add image path");
        }
        panelLateralGradient 
    		= new GradientPaint(0, 0, new Color(255, 10, 100), 300, 600, new Color(150, 20, 150));
    }
    
    void creatingTextField(){
    	// TextFields
        nameComplete = new TextFieldScreen(this);
        nameComplete.setBounds(140, 120, 300, 30);

        nameUser = new TextFieldScreen(this);
        nameUser.setBounds(140, 180, 300, 30);

        date = new TextFieldScreen(this);
        date.setBounds(140, 240, 300, 30);

        email = new TextFieldScreen(this);
        email.setBounds(140, 300, 300, 30);

        password = new JPasswordFieldScreen(this);
        password.setBounds(140, 360, 300, 30);

        confirm = new JPasswordFieldScreen(this);
        confirm.setBounds(140, 420, 300, 30);


        this.add(date);
        this.add(nameUser);
        this.add(nameComplete);
        this.add(email);
        this.add(password);
        this.add(confirm);
    }

    void creatingLabel(){
    	// Labels ('Name' 'Email')
        nameCompleteLabel = new JLabel();
        nameCompleteLabel.setText("Name Complete");
        nameCompleteLabel.setBounds(140, 120 - 25, 100, 20);
        nameCompleteLabel.setForeground(Color.WHITE);

        nameUserLabel = new JLabel();
        nameUserLabel.setText("User Name");
        nameUserLabel.setBounds(140, 180 - 25, 100, 20);
        nameUserLabel.setForeground(Color.WHITE);

        dateLabel = new JLabel();
        dateLabel.setText("Birth Date (year-month-day)");
        dateLabel.setBounds(140, 240 - 25, 200, 20);
        dateLabel.setForeground(Color.WHITE);

        emailLabel = new JLabel();
        emailLabel.setText("Email");
        emailLabel.setBounds(140, 300 - 25, 100, 20);
        emailLabel.setForeground(Color.WHITE);

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(140, 360 - 25, 100, 20);
        passwordLabel.setForeground(Color.WHITE);

        confirmLabel = new JLabel();
        confirmLabel.setText("Confirm password");
        confirmLabel.setBounds(140, 420 - 25, 120, 20);
        confirmLabel.setForeground(Color.WHITE);

        this.add(dateLabel);
        this.add(nameUserLabel);
        this.add(nameCompleteLabel);
        this.add(emailLabel);
        this.add(passwordLabel);
        this.add(confirmLabel);
    }
    
    
    private void creatingConnectScreen() {
    	//Connect 'register and login' screens with label
    	connectionScreens = new LabelConnect(this, loginScreen);
    	connectionScreens.setText("Login now!");
    	connectionScreens.setBounds(365, 478, 100, 20);
    	connectionScreens.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
    	connectionScreens.setForeground(Color.WHITE);
    	connectionScreens.addMouseListener(connectionScreens);
    	
    	this.add(connectionScreens);
    }
    

    void cretingButton(){
    	// Button 'Register now'
        button = new JButtonScreen(this);
        button.setText("Register");
        button.setBounds(140, 475, 120, 30);
        button.setBackground(new Color(100, 100, 100));
        button.setForeground(new Color(255, 255, 255));
        button.setBorder(BorderFactory.createBevelBorder(0));
        button.addMouseListener(button);
        this.add(button);
    }


    @SuppressWarnings("deprecation")
	@Override
    public String getInfo() {
    	//Info to DataBase
    	StringBuilder sb = new StringBuilder();
    	sb.append("{");
		sb.append(nameComplete.getText());
		sb.append(";");
		sb.append(nameUser.getText());
		sb.append(";");
		sb.append(date.getText());
		sb.append(";");
		sb.append(email.getText());
		sb.append(";");
		sb.append(password.getText());
		sb.append("}");
		System.out.println(sb.toString());
		return sb.toString();
    }

    
}
