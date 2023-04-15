package me.pedrokaua.loginregister.vision;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

public class JPasswordFieldScreen extends JPasswordField{

    JPasswordFieldScreen(RegisterScreen screen){
        this.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 14));
        this.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent arg0) {
                screen.getInfos();
            }
        });
    }


    
}