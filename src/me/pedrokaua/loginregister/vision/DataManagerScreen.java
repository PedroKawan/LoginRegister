package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.GradientPaint;

public class DataManagerScreen extends Screen {
	private static final long serialVersionUID = 1L;

	public DataManagerScreen() {
		define();
	}
	
	@Override
	public String getInfo() {
		return null;
	}

	@Override
	public void verifyFields() {
		
	}

	@Override
	public boolean createFile(String info) {
		return false;
	}
	
	@Override
	public void define() {
	    this.setTitle("DATABASE SCREEN");
	    
		this.remove(labelCentral);
		panelLateral.setBounds(700, 0, 200, 600);
		
		labelLateral.setBounds(700, labelLateral.getY(), 190, 20);
		labelLateral.setText("DATABASE");
		
		panelLabelLateral.setBounds(700, panelLabelLateral.getY(),
				200, panelLabelLateral.getHeight());
		imagePositionX = 28;
		
		panelLateralGradient 
			= new GradientPaint(-50, -50, new Color(30, 30, 30), 200, 600, new Color(1, 222, 20));
	}

	
	public static void main(String[] args) {
		new DataManagerScreen();
	}
}
