package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompraVShop {

	private JFrame frame;
	private JTextField codDes;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraVShop window = new CompraVShop();
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
	public CompraVShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 563);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CompraVShop");
		
		JButton botonEliminarCarrito = new JButton("ELIMINAR CARRITO");
		botonEliminarCarrito.setBounds(10, 37, 170, 62);
		frame.getContentPane().add(botonEliminarCarrito);
		
		JButton botonEliminarProducto = new JButton("ELIMINAR PRODUCTO");
		botonEliminarProducto.setBounds(10, 144, 170, 62);
		frame.getContentPane().add(botonEliminarProducto);
		
		JButton botonCerrar = new JButton("CERRAR");
		botonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		botonCerrar.setBounds(137, 425, 129, 43);
		frame.getContentPane().add(botonCerrar);
		
		JButton botonComprar = new JButton("COMPRAR");
		botonComprar.setBounds(370, 380, 117, 43);
		frame.getContentPane().add(botonComprar);
		
		JLabel labelDescuento = new JLabel("Código Descuento:");
		labelDescuento.setBounds(10, 308, 129, 24);
		frame.getContentPane().add(labelDescuento);
		
		codDes = new JTextField();
		codDes.setBounds(137, 310, 195, 22);
		frame.getContentPane().add(codDes);
		codDes.setColumns(10);
		
		JLabel precioTotal = new JLabel("Precio Total:");
		precioTotal.setBounds(348, 308, 117, 24);
		frame.getContentPane().add(precioTotal);
		
		textField = new JTextField();
		textField.setBounds(471, 310, 187, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(216, 37, 427, 243);
		frame.getContentPane().add(table);
	}

}
