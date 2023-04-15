package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import me.pedrokaua.loginregister.vision.components.JButtonScreen;
import me.pedrokaua.loginregister.vision.components.JPasswordFieldScreen;
import me.pedrokaua.loginregister.vision.components.TextFieldScreen;

@SuppressWarnings("serial")
public class RegisterScreen extends Screen {
	TextFieldScreen nameComplete, nameUser, date, email;
    JPasswordFieldScreen password, confirm;
    
    JLabel nameCompleteLabel, nameUserLabel, dateLabel, emailLabel, passwordLabel, confirmLabel;
    
    JButton button;
    
    List<TextField> list;
    
    RegisterScreen(){
        define();
        creatingLabel();
        cretingButton();
        creatingTextField();
    }
    
    private void define() {
    	// 'Screen' attributes
        labelLateral.setText("REGISTER");
        this.setTitle("REGISTER SCREEN");
        labelCentral.setText("Register");
        imageLateral =
        		new ImageIcon("C:/Users/PedroKawan/Documents/Projects/PedroKawan/LoginRegister/imagens/computer.png");
    }

    private void cretingButton(){
    	// Button 'Register now'
        button = new JButton();
        button.setText("Register now");
        button.setBounds(170, 475, 120, 30);
        button.setBackground(new Color(100, 100, 100));
        button.setForeground(new Color(255, 255, 255));
        button.setBorder(BorderFactory.createBevelBorder(0));
        button.addMouseListener(new JButtonScreen(){
			@Override
            public void mouseClicked(MouseEvent arg0) {
                getInfo();
            }
        });
        this.add(button);
    }

    private void creatingTextField(){
    	// TextFields
        nameComplete = new TextFieldScreen(this);
        nameComplete.setBounds(90, 120, 300, 30);

        nameUser = new TextFieldScreen(this);
        nameUser.setBounds(90, 180, 300, 30);

        date = new TextFieldScreen(this);
        date.setBounds(90, 240, 300, 30);

        email = new TextFieldScreen(this);
        email.setBounds(90, 300, 300, 30);

        password = new JPasswordFieldScreen(this);
        password.setBounds(90, 360, 300, 30);

        confirm = new JPasswordFieldScreen(this);
        confirm.setBounds(90, 420, 300, 30);


        this.add(date);
        this.add(nameUser);
        this.add(nameComplete);
        this.add(email);
        this.add(password);
        this.add(confirm);
        this.setVisible(false);
        this.setVisible(true);
    }

    private void creatingLabel(){
    	// Labels ('Name' 'Email')
        nameCompleteLabel = new JLabel();
        nameCompleteLabel.setText("Name Complete");
        nameCompleteLabel.setBounds(90, 120 - 25, 100, 20);
        nameCompleteLabel.setForeground(Color.WHITE);

        nameUserLabel = new JLabel();
        nameUserLabel.setText("User Name");
        nameUserLabel.setBounds(90, 180 - 25, 100, 20);
        nameUserLabel.setForeground(Color.WHITE);

        dateLabel = new JLabel();
        dateLabel.setText("Birth Date (year-month-day)");
        dateLabel.setBounds(90, 240 - 25, 200, 20);
        dateLabel.setForeground(Color.WHITE);

        emailLabel = new JLabel();
        emailLabel.setText("Email");
        emailLabel.setBounds(90, 300 - 25, 100, 20);
        emailLabel.setForeground(Color.WHITE);

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(90, 360 - 25, 100, 20);
        passwordLabel.setForeground(Color.WHITE);

        confirmLabel = new JLabel();
        confirmLabel.setText("Confirm password");
        confirmLabel.setBounds(90, 420 - 25, 120, 20);
        confirmLabel.setForeground(Color.WHITE);

        this.add(dateLabel);
        this.add(nameUserLabel);
        this.add(nameCompleteLabel);
        this.add(emailLabel);
        this.add(passwordLabel);
        this.add(confirmLabel);
    }

    @SuppressWarnings("deprecation")
	@Override
    public void getInfo() {
    	//Info to DataBase
    	StringBuilder sb = new StringBuilder();
		sb.append(nameComplete.getText());
		sb.append(";");
		sb.append(nameUser.getText());
		sb.append(";");
		sb.append(date.getText());
		sb.append(";");
		sb.append(email.getText());
		sb.append(";");
		sb.append(password.getText());
		
		createFile(sb.toString());
    }
    
    public void verifyFields() {}
    
    @Override
    public void createFile(String info) {
    	System.out.println(info);
    }
    
    public static void main(String[] args){
		new RegisterScreen();
	}
}
