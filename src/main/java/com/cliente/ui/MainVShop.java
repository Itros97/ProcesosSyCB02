package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainVShop {

	private JFrame frame;
	private JTextField buscar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainVShop window = new MainVShop();
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
	public MainVShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("MainVShop");
		
		JButton botonTienda = new JButton("TIENDA");
		botonTienda.setBounds(10, 51, 150, 45);
		frame.getContentPane().add(botonTienda);
		botonTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraVShop.main(null);
			}
		});
		
		JButton botonAnyadirCarrito = new JButton("AÑADIR CARRITO");
		botonAnyadirCarrito.setBounds(10, 148, 150, 45);
		frame.getContentPane().add(botonAnyadirCarrito);
		
		JButton botonCarrito = new JButton("CARRITO");
		botonCarrito.setBounds(10, 237, 150, 45);
		frame.getContentPane().add(botonCarrito);
		botonCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarritoVShop.main(null);
			}
		});
		
		JButton botonHistorial = new JButton("HISTORIAL");
		botonHistorial.setBounds(10, 318, 150, 45);
		frame.getContentPane().add(botonHistorial);
		
		JButton botonAdmin = new JButton("ADMINISTRADOR");
		botonAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUsersVShop.main(null);
			}
		});
		botonAdmin.setBounds(10, 401, 150, 45);
		frame.getContentPane().add(botonAdmin);
		
		buscar = new JTextField();
		buscar.setBounds(177, 11, 457, 34);
		frame.getContentPane().add(buscar);
		buscar.setColumns(10);
		
		JButton botonBuscar = new JButton("BUSCAR");
		botonBuscar.setBounds(642, 11, 89, 34);
		frame.getContentPane().add(botonBuscar);
		
		table = new JTable();
		table.setBounds(187, 51, 442, 397);
		frame.getContentPane().add(table);
		frame.setLocationRelativeTo(null);
	}
}
