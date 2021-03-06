package com.cliente.ui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


import com.cliente.jdo.Carrito;
import com.cliente.jdo.Favorito;
import com.cliente.jdo.Producto;
import com.database.FavoritoDB;
import com.database.ProductoDB;
import com.database.UsuarioDB;


public class MainVShop {

	private JFrame frame;
	public JTextField buscar;
	
	private Client client;
	
	public static List<Producto> carrito = new ArrayList<>();
	public static List<Producto> favorito = new ArrayList<>();
	
	JComboBox comboFiltro;

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
        final WebTarget productosOrdenadoMarca = appTarget.path("productoMarca");
        final WebTarget productosOrdenadoPrecio = appTarget.path("productoPrecio");
        final WebTarget productosOrdenadoNombre = appTarget.path("productoNombre");
        
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("MainVShop");
		
		
		
		
		
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
				AdminVShop.main(null);
			}
		});
		botonAdmin.setBounds(10, 401, 150, 45);
		frame.getContentPane().add(botonAdmin);
		
		buscar = new JTextField();
		buscar.setBounds(177, 11, 457, 34);
		frame.getContentPane().add(buscar);
		buscar.setColumns(10);
			
		
		
	    final DefaultListModel<Producto> productListModel = new DefaultListModel<>();
        final JList<Producto> productList = new JList<>(productListModel);
		productList.setBounds(170, 65, 464, 381);
		
		JButton botonAnyadirCarrito = new JButton("A??ADIR CARRITO");
		botonAnyadirCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(productList.getSelectedValue());
				carrito.add(productList.getSelectedValue());
			}
		});
		botonAnyadirCarrito.setBounds(10, 148, 150, 45);
		frame.getContentPane().add(botonAnyadirCarrito);

		
		JButton botonTienda = new JButton("TIENDA");
		botonTienda.setBounds(10, 51, 150, 45);
		frame.getContentPane().add(botonTienda);
		frame.getContentPane().add(productList);
		
		JButton botonAnyadirFavorito = new JButton("A??ADIR FAVORITO");
		botonAnyadirFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Favorito nuevoFavorito = new Favorito(); 
				nuevoFavorito.setIdProducto(2);
				nuevoFavorito.setNickname(UsuarioDB.u.getNickname());
				favorito.add(productList.getSelectedValue());
				FavoritoDB.insertarFavorito(nuevoFavorito);
			}
		});
		botonAnyadirFavorito.setBounds(244, 469, 150, 45);
		frame.getContentPane().add(botonAnyadirFavorito);
		
		JButton botonFavorito = new JButton("FAVORITOS");
		botonFavorito.setBounds(404, 469, 150, 45);
		frame.getContentPane().add(botonFavorito);
		botonFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavProductVShop.main(null);
			}
		});
		
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
		
		
		JButton botonBuscar = new JButton("BUSCAR");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre;
				nombre = buscar.getText();
				final WebTarget productosSeleccionado = appTarget.path("productoSeleccionado/"+nombre);
				try {
                    GenericType<List<Producto>> genericType = new GenericType<List<Producto>>() {};
                    List<Producto> productos = productosSeleccionado.request(MediaType.APPLICATION_JSON).get(genericType);
                    productListModel.clear();
                    System.out.println(productos.toString());
                    for (Producto p1 : productos) {
                    	productListModel.addElement(p1);
                    }
                } catch (ProcessingException ex) {
                    JOptionPane.showInputDialog(MainVShop.this);
                }
			}
		});
		botonBuscar.setBounds(642, 11, 89, 34);
		frame.getContentPane().add(botonBuscar);
		
		comboFiltro = new JComboBox();
		comboFiltro.setBounds(644, 90, 87, 39);
		comboFiltro.addItem("Filtro");
		comboFiltro.addItem("Nombre");
		comboFiltro.addItem("Marca");
		comboFiltro.addItem("Precio");
		frame.getContentPane().add(comboFiltro);
		
		JButton botonBuscarFiltro = new JButton("APLICAR");
		botonBuscarFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboFiltro.getSelectedItem().equals("Nombre")) {
					try {
	                    GenericType<List<Producto>> genericType = new GenericType<List<Producto>>() {};
	                    List<Producto> productos = productosOrdenadoNombre.request(MediaType.APPLICATION_JSON).get(genericType);
	                    productListModel.clear();
	                    System.out.println(productos.toString());
	                    for (Producto p1 : productos) {
	                    	productListModel.addElement(p1);
	                    }
	                } catch (ProcessingException ex) {
	                    JOptionPane.showInputDialog(MainVShop.this);
	                }
				}
				
				//
				
				
				if (comboFiltro.getSelectedItem().equals("Marca")) {
					try {
	                    GenericType<List<Producto>> genericType = new GenericType<List<Producto>>() {};
	                    List<Producto> productos = productosOrdenadoMarca.request(MediaType.APPLICATION_JSON).get(genericType);
	                    productListModel.clear();
	                    System.out.println(productos.toString());
	                    for (Producto p1 : productos) {
	                    	productListModel.addElement(p1);
	                    }
	                } catch (ProcessingException ex) {
	                    JOptionPane.showInputDialog(MainVShop.this);
	                }
				}
				
				//
				
				if (comboFiltro.getSelectedItem().equals("Precio")) {
					try {
	                    GenericType<List<Producto>> genericType = new GenericType<List<Producto>>() {};
	                    List<Producto> productos = productosOrdenadoPrecio.request(MediaType.APPLICATION_JSON).get(genericType);
	                    productListModel.clear();
	                    System.out.println(productos.toString());
	                    for (Producto p1 : productos) {
	                    	productListModel.addElement(p1);
	                    }
	                } catch (ProcessingException ex) {
	                    JOptionPane.showInputDialog(MainVShop.this);
	                }
				}
				
				//
			}
		});
		botonBuscarFiltro.setBounds(644, 159, 87, 34);
		frame.getContentPane().add(botonBuscarFiltro);
	}
}
