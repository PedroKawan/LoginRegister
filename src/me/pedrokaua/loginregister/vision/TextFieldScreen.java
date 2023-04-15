package me.pedrokaua.loginregister.vision;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextFieldScreen extends TextField implements MouseListener{

    TextFieldScreen(RegisterScreen screen){
        this.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                screen.getInfos();
            }

        });
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        this.setText("");
    }
    
    public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
    
}
