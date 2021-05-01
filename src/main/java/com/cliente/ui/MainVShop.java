package com.cliente.ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.cliente.jdo.Producto;


import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MainVShop {

	private JFrame frame;
	private JTextField buscar;
	
	private Client client;
	
	

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
		
		client = ClientBuilder.newClient();
		
		final WebTarget appTarget = client.target("http://localhost:8080/myapp");
        final WebTarget productosTarget = appTarget.path("producto");
        
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("MainVShop");
		
		
		
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
		botonHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistorialVShop.main(null);
			}
		});
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
		
	    final DefaultListModel<Producto> productListModel = new DefaultListModel<>();
        JList<Producto> productList = new JList<>(productListModel);
		productList.setBounds(170, 65, 464, 381);

		
		JButton botonTienda = new JButton("TIENDA");
		botonTienda.setBounds(10, 51, 150, 45);
		frame.getContentPane().add(botonTienda);
		frame.getContentPane().add(productList);
		frame.setLocationRelativeTo(null);
		
		botonTienda.addActionListener(new ActionListener() {
			   @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    GenericType<List<Producto>> genericType = new GenericType<List<Producto>>() {};
	                    List<Producto> productos = productosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	                    productListModel.clear();
	                    for (Producto p1 : productos) {
	                    	productListModel.addElement(p1);
	                    }
	                } catch (ProcessingException ex) {
	                    JOptionPane.showInputDialog(MainVShop.this);
	                }
	            }
	            
	        });
	}
}
