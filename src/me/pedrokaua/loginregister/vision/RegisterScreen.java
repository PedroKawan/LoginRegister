package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import me.pedrokaua.loginregister.database.DataBase;
import me.pedrokaua.loginregister.model.User;
import me.pedrokaua.loginregister.vision.components.JButtonScreen;
import me.pedrokaua.loginregister.vision.components.JPasswordFieldScreen;
import me.pedrokaua.loginregister.vision.components.LabelConnect;
import me.pedrokaua.loginregister.vision.components.TextFieldScreen;

@SuppressWarnings("serial")
public class RegisterScreen extends Screen {
	TextFieldScreen nameComplete, nameUser, date, email;
    JPasswordFieldScreen password, confirm;
    
    JLabel nameCompleteLabel, nameUserLabel, dateLabel, emailLabel, passwordLabel, confirmLabel;
    List<TextFieldScreen> listFields;
    
    LabelConnect connectionScreens;
    
    JButtonScreen button;
    LoginScreen loginScreen;
    
    
    boolean isMan = true;
    boolean isWoman = false;
    
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
			= new GradientPaint(0, 0, new Color(10, 10, 255), 300, 600, new Color(150, 20, 255));
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

       	listFields = Arrays.asList(nameComplete, nameUser, email);
    	listFields.forEach(f -> f.addMouseListener(f));
        
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
        dateLabel.setText("Birth Date (2000-05-03)");
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
    	connectionScreens = new LabelConnect(this, "login");
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
        
        JButton buttonMen = new JButton();
        JButton buttonWomen = new JButton();
        
        buttonMen.setText("Man");
        buttonMen.setBounds(240, 10, 50, 30);
        buttonMen.setBackground(new Color(100, 100, 255));
        buttonMen.setForeground(new Color(255, 255, 255));
        buttonMen.setBorder(BorderFactory.createEmptyBorder());
        buttonMen.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		isMan = true;
        		isWoman = false;
        	    buttonMen.setBorder(BorderFactory.createEtchedBorder(1));
        	    buttonWomen.setBorder(BorderFactory.createEmptyBorder());
        		panelRepaint();
        	}
        });
        this.add(buttonMen);
        
        buttonWomen.setText("Woman");
        buttonWomen.setBounds(310, 10, 50, 30);
        buttonWomen.setBackground(new Color(255, 100, 100));
        buttonWomen.setForeground(new Color(255, 255, 255));
        buttonWomen.setBorder(BorderFactory.createEmptyBorder());
        buttonWomen.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		isMan = false;
        		isWoman = true;
        		buttonMen.setBorder(BorderFactory.createEmptyBorder());
        	    buttonWomen.setBorder(BorderFactory.createEtchedBorder(1));
        		panelRepaint();
        	}

        });
        this.add(buttonWomen);
    }

    private void panelRepaint() {
		if (isMan) {
			 panelLateralGradient 
	    		= new GradientPaint(0, 0, new Color(10, 10, 255), 300, 600, new Color(150, 20, 255));
			refresh();
		} else {
			 panelLateralGradient 
	    		= new GradientPaint(0, 0, new Color(255, 10, 100), 300, 600, new Color(150, 20, 150));
			 refresh();
		}
		
	}
    
    @SuppressWarnings("deprecation")
	@Override
    public boolean getInfo() {
    	//Info to DataBase
    	try {
//		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate bir = LocalDate.parse(date.getText());
		
		String nam = nameComplete.getText();
		String use = nameUser.getText();
		Character gen = isMan? 'M': 'W';
		String ema = email.getText();
		String pas = password.getText();
		String con = confirm.getText();
		
		boolean attributesVoid = 
				verifyVoid(nameComplete)
				&& verifyVoid(nameUser)
				&& verifyEmail(email.toString())
				&& verifyPassword(pas, con);
		
		if (attributesVoid == false) {
			return false;
		}
		
		User user = new User(
				nam,
				use,
				gen,
				bir,
				ema,
				pas
			);
			DataBase.getInstance().addUser(user);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    

	boolean verifyEmail(String email){
		Pattern pattern1 = Pattern.compile("@");
		Pattern pattern2 = Pattern.compile(".com");
		Matcher matcher1 = pattern1.matcher(email);
		Matcher matcher2 = pattern2.matcher(email);
		
		boolean verify1 = matcher1.find();
		boolean verify2 = matcher2.find();
		boolean verifyVoid  = email.equals("") || email == null;
		
    	if (!(verify1 && verify2) || verifyVoid) { 
    		this.email.setBackground(Color.RED);
    		return false;
    	}
    	return true;
    }
    
    boolean verifyPassword(String password, String confirm){
    	if (!password.equals(confirm) 
    			|| password == null
    				|| password.equals("")) { 
    		this.passwordLabel.setForeground(Color.RED);
    		this.confirmLabel.setForeground(Color.RED);
    		return false;
    	}
    	return true;
    }
    
    boolean verifyVoid(TextFieldScreen field){
    	if (field.getText() == null 
    			|| field.getText().equals("")) {
    		field.setBackground(Color.RED);
    		return false;
    	}
    	return true;
    }
    
}
