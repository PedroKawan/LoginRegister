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

public abstract class Screen extends JFrame{
	private static final long serialVersionUID = 1L;
	protected ImageIcon imageLateral
		= new ImageIcon("C:/Users/PedroKawan/Documents/Projects/PedroKawan/LoginRegister/imagens/user.png");
	
	protected JPanel panelLateral;	
	protected JPanel panelCentral;
	
	protected JLabel labelLateral;
	protected JLabel labelCentral;
	protected JLabel signature;

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
		//Panel Lateral with contrast.
		panelLateral = new JPanel(){
		private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics arg0) {
				Graphics2D g2d = (Graphics2D) arg0;
				GradientPaint gradient 
					= new GradientPaint(0, 0, new Color(240, 0, 240), 800, 500, new Color(255, 0, 0));
				g2d.setPaint(gradient);
				g2d.fillRect(0, 0, 300, 600);
				
				g2d.drawImage(imageLateral .getImage(), 85, 200, null);
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

		//PT-BR signature
		signature = new JLabel();
		signature.setText("Created by: Pedro Kauã Silva dos Santos");
		signature.setForeground(new Color(255, 255, 255, 127));
		signature.setBounds(0, 540, 400, 20);

		this.add(labelCentral);
		this.add(labelLateral);
		this.add(signature);	
	}
	
	public abstract void getInfo();

	public abstract void verifyFields();
	
	public abstract void createFile(String info);
}
