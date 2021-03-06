package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;

import com.database.CarritoDB;
import com.database.UsuarioDB;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerCarritoVShop {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerCarritoVShop window = new VerCarritoVShop();
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
	public VerCarritoVShop() {
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
		list.setBounds(10, 11, 197, 202);
		frame.getContentPane().add(list);
		
		JButton seleccionarUsuario = new JButton("Seleccionar Usuario");
		seleccionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDB.getUsuario(null);
			}
		});
		seleccionarUsuario.setBounds(10, 227, 197, 23);
		frame.getContentPane().add(seleccionarUsuario);
		
		table = new JTable();
		table.setBounds(227, 215, 197, -202);
		frame.getContentPane().add(table);
		
		JButton cargarCarritos = new JButton("Cargar Carritos");
		cargarCarritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarritoDB.recogerCarrito(null);
			}
		});
		cargarCarritos.setBounds(227, 227, 200, 23);
		frame.getContentPane().add(cargarCarritos);
		
	}
}