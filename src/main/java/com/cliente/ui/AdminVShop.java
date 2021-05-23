package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminVShop {

	private JFrame frame;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminVShop window = new AdminVShop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminVShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 282, 228);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("AdminVShop");
		
		comboBox = new JComboBox();
		comboBox.setBounds(32, 46, 213, 23);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Seleccione opción");
		comboBox.addItem("Administrar usuarios");
		comboBox.addItem("Administrar productos");
		comboBox.addItem("Administrar códigos de descuento");
		
		JButton botonAcceder = new JButton("Acceder");
		botonAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedItem().equals("Administrar usuarios")) {
					AdminUsersVShop.main(null);
					frame.dispose();
				}
				
				if (comboBox.getSelectedItem().equals("Administrar productos")) {
					AdminProductsVShop.main(null);
					frame.dispose();
				}
				
				if (comboBox.getSelectedItem().equals("Administrar códigos de descuento")) {
					CodigosVShop.main(null);
					frame.dispose();
				}
				
			}
		});
		botonAcceder.setBounds(32, 111, 213, 23);
		frame.getContentPane().add(botonAcceder);
		
	}
}
