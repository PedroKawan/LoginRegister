package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import me.pedrokaua.loginregister.vision.components.TableRender;

public class DataManagerScreen extends Screen {
	private static final long serialVersionUID = 1L;

	JScrollPane scroll;
	JTable table;
	
	public DataManagerScreen() {
		define();
		creatingTable();
		
		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});
	}
	
	private void creatingTable() {
		String[] nameColumns = {"NAMECOMPLETE", "USERNAME", "BITHDATE", "EMAIL", "PASSWORD"};
		String[] user = {"Pedro", "P", "20-10-2004", "AASDFASODKFPOSDK@GMAIL.COM", "123456"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(nameColumns);
		model.setColumnCount(5);
		
		table = new JTable();
		table.setModel(model);
		table.setRowHeight(20);
		table.setDefaultRenderer(Object.class, new TableRender());
		
		table.setGridColor(Color.DARK_GRAY);
		
		scroll = new JScrollPane(table);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.setBounds(20, 340, 660, 200);
		scroll.setBackground(new Color(0, 200, 0, 200));
		for (int i = 0; i < 50; i++) {
			model.addRow(user);
		}
		this.add(scroll);
	}

	@Override
	public String getInfo() {
		return null;
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

	
	public static void main(String[] args) {
		new DataManagerScreen();
	}
}
