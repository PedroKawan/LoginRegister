package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.GradientPaint;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataManagerScreen extends Screen {
	private static final long serialVersionUID = 1L;

	public DataManagerScreen() {
		define();
		creatingTable();
		this.refresh();
	}

	
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

	
	private void creatingTable() {
		//Creating table info
		String[] identifiers = {"NameComplete", "UseName", "Gender", "BirthDate", "Email", "Password"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(identifiers);
		
		JTable table = new JTable(model);
		table.setDefaultRenderer(Object.class, new RenderofTable());
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(20, 340, 660, 200);
		pane.setBackground(new Color(0, 150, 0));
		this.add(pane);
		
		for (int i = 0; i < 40; i++) {
			model.addRow(identifiers);
		}
	}
	
	@Override
	public String getInfo() {
		return null;
	}
	public static void main(String[] args) {
		new DataManagerScreen();
	}
}
