package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistorialVShop {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistorialVShop window = new HistorialVShop();
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
	public HistorialVShop() {
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
		
		JList list = new JList();
		list.setBounds(10, 11, 207, 239);
		frame.getContentPane().add(list);
		
		table = new JTable();
		table.setBounds(227, 215, 197, -202);
		frame.getContentPane().add(table);
		
		JButton cargarCompras = new JButton("Cargar Compras");
		cargarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Falta insertar las compras desde la base de datos e insertarlas en la lista
			}
		});
		cargarCompras.setBounds(227, 227, 200, 23);
		frame.getContentPane().add(cargarCompras);
	}
}