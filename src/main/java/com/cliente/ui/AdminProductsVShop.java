package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.cliente.jdo.Producto;
import com.database.ProductoDB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminProductsVShop {

	private JFrame frame;
	private JTextField nombre;
	private JTextField marca;
	private JTextField precio;
	private JTextField descripcion;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminProductsVShop window = new AdminProductsVShop();
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
	public AdminProductsVShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 414);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("AdminProductsVShop");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 554, 481);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelCrear = new JPanel();
		tabbedPane.addTab("Crear", null, panelCrear, null);
		panelCrear.setLayout(null);
		
		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setBounds(10, 23, 112, 26);
		panelCrear.add(labelNombre);
		
		JLabel labelMarcar = new JLabel("MARCA");
		labelMarcar.setBounds(269, 23, 112, 26);
		panelCrear.add(labelMarcar);
		
		JLabel labelPrecio = new JLabel("PRECIO");
		labelPrecio.setBounds(10, 142, 112, 26);
		panelCrear.add(labelPrecio);
		
		JLabel labelDescripcion = new JLabel("DESCRIPCION");
		labelDescripcion.setBounds(269, 142, 112, 26);
		panelCrear.add(labelDescripcion);
		
		JLabel labelImagen = new JLabel("IMAGEN");
		labelImagen.setBounds(10, 248, 112, 26);
		panelCrear.add(labelImagen);
		
		JButton botonImagen = new JButton("Agregar imagen");
		botonImagen.setBounds(269, 248, 219, 26);
		panelCrear.add(botonImagen);
		
		JButton botonCrear = new JButton("CREAR PRODUCTO");
		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto p = new Producto(2,nombre.getText(), marca.getText(), Float.parseFloat(precio.getText()), descripcion.getText());
				ProductoDB.insertarProducto(p);
			}
		});
		botonCrear.setBounds(10, 313, 529, 34);
		panelCrear.add(botonCrear);
		
		nombre = new JTextField();
		nombre.setBounds(10, 74, 219, 26);
		panelCrear.add(nombre);
		nombre.setColumns(10);
		
		marca = new JTextField();
		marca.setBounds(269, 74, 219, 26);
		panelCrear.add(marca);
		marca.setColumns(10);
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(10, 179, 219, 26);
		panelCrear.add(precio);
		
		descripcion = new JTextField();
		descripcion.setColumns(10);
		descripcion.setBounds(269, 179, 219, 26);
		panelCrear.add(descripcion);
		
		JPanel panelEliminar = new JPanel();
		tabbedPane.addTab("Eliminar", null, panelEliminar, null);
		panelEliminar.setLayout(null);
		
		JLabel labelId = new JLabel("ID:");
		labelId.setBounds(10, 11, 85, 42);
		panelEliminar.add(labelId);
		
		id = new JTextField();
		id.setBounds(70, 17, 378, 31);
		panelEliminar.add(id);
		id.setColumns(10);
		
		JButton botonEliminar = new JButton("ELIMINAR PRODUCTO");
		botonEliminar.setBounds(70, 64, 378, 31);
		panelEliminar.add(botonEliminar);
		
		JPanel panelModificar = new JPanel();
		tabbedPane.addTab("Modificar", null, panelModificar, null);
		panelModificar.setLayout(null);
	}

}
