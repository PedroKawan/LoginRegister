package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen extends JFrame{
	private static final long serialVersionUID = 1L;
	ImageIcon userImage = new ImageIcon("C:\\Users\\RIANDRA\\Documents\\Programmer\\LoginRegister\\src\\me\\pedrokaua\\loginregister\\imagens\\user.png");
	JPanel panelLateral;	
	JPanel panelCentral;
	
	JLabel labelLateral;
	JLabel labelCentral;
	JLabel assinaturabr;

	public Screen(){
		creatingScreen();
		creatingLabel();
		creatingPanel();
	}

	private void creatingScreen() {
		this.setSize(900, 600);
		this.setTitle("SCREEN-SCREEN");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(30, 30, 30));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
	}

	private void creatingPanel(){
		//Panel Lateral with contrasct.
		panelLateral = new JPanel(){
			@Override
			public void paint(Graphics arg0) {
				Graphics2D g2d = (Graphics2D) arg0;
				GradientPaint gradient 
					= new GradientPaint(0, 0, new Color(240, 0, 240), 800, 500, new Color(255, 0, 0));
				g2d.setPaint(gradient);
				g2d.fillRect(0, 0, 300, 600);
				
				g2d.drawImage(userImage.getImage(), 85, 200, null);
			}
		};
		panelLateral.setSize(300, 600);
		panelLateral.setLocation(600, 0);
		panelLateral.setBackground(new Color(240, 0, 240));

		//Panel of Label -> Lateral
		JPanel panelLabelLateral = new JPanel();
		panelLabelLateral.setBounds(600, 350, 300, 24);
		panelLabelLateral.setBackground(new Color(220, 220, 220, 100));
		this.add(panelLabelLateral);
		this.add(panelLateral);	
	}

	private void creatingLabel(){
		labelLateral = new JLabel();
		labelLateral.setBounds(600, 352, 295, 20);
		labelLateral.setHorizontalAlignment(JLabel.CENTER);
		labelLateral.setFont(new Font("Arial", Font.BOLD, 20));
		labelLateral.setText("SCREEN");
		labelLateral.setForeground(Color.BLACK);

		labelCentral = new JLabel();
		labelCentral.setBounds(50, 40, 100, 24);
		labelCentral.setHorizontalAlignment(JLabel.CENTER);
		labelCentral.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		labelCentral.setText("label");
		labelCentral.setForeground(Color.WHITE);

		//PT-BR assinaruta
		assinaturabr = new JLabel();
		assinaturabr.setText("Created by: Pedro Kauã Silva dos Santos");
		assinaturabr.setForeground(new Color(255, 255, 255, 127));
		assinaturabr.setBounds(0, 540, 400, 20);

		this.add(labelCentral);
		this.add(labelLateral);
		this.add(assinaturabr);	
	}
	
	public void getInfos(){
		System.out.println("allinfos");
	}
}
