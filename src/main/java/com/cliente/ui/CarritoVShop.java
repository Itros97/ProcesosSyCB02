package com.cliente.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class CarritoVShop {

	private JFrame frame;
	private JTable tablacarrito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarritoVShop window = new CarritoVShop();
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
	public CarritoVShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CarritoVShop");
		
		tablacarrito = new JTable();
		tablacarrito.setBounds(10, 11, 414, 217);
		frame.getContentPane().add(tablacarrito);
		
		JButton CerrarButton = new JButton("Cerrar");
		CerrarButton.setBounds(10, 239, 150, 23);
		frame.getContentPane().add(CerrarButton);
		
		CerrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		JButton ComprarButton = new JButton("Comprar");
		ComprarButton.setBounds(274, 239, 150, 23);
		frame.getContentPane().add(ComprarButton);
		
		ComprarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
