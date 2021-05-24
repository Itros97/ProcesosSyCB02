package com.cliente.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cliente.jdo.Carrito;
import com.cliente.jdo.Codigoobj;
import com.cliente.jdo.Compra;
import com.cliente.jdo.Producto;
import com.database.CarritoDB;
import com.database.CodigoBD;
import com.database.CompraDB;
import com.database.ConexionDB;
import com.database.ProductoDB;
import com.database.UsuarioDB;
import com.miscelaneus.Codigo;

public class CompraVShop {

	private JFrame frame;
	private JTextField codDes;
	private JTextField textField;
	static int preciofinal = 0;

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
		
		final DefaultListModel<Producto> productListModel = new DefaultListModel<>();
		final JList<Producto> list = new JList<>(productListModel);

		list.setBounds(216, 37, 427, 243);
		frame.getContentPane().add(list);
		
		for (int i = 0; i < MainVShop.carrito.size(); i++) {
			productListModel.add(i, MainVShop.carrito.get(i));
		}
		
		JButton botonEliminarCarrito = new JButton("ELIMINAR CARRITO");
		botonEliminarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainVShop.carrito.clear();
				frame.dispose();
			}
		});
		botonEliminarCarrito.setBounds(21, 110, 170, 62);
		frame.getContentPane().add(botonEliminarCarrito);
		
		JButton botonCerrar = new JButton("CERRAR");
		botonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		botonCerrar.setBounds(10, 470, 139, 43);
		frame.getContentPane().add(botonCerrar);
		
		JButton botonComprar = new JButton("COMPRAR");
		botonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTicket(MainVShop.carrito);
				
				for (int i = 0; i <= MainVShop.carrito.size(); i++) {
					Compra c1 = new Compra(UsuarioDB.u.getNickname(), MainVShop.carrito.get(i).getIdProducto());
					CompraDB.insertarCompra(c1);
				}
				
			}
		});
		botonComprar.setBounds(529, 470, 129, 43);
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
		
		JButton bdescuento = new JButton("APLICAR DESCUENTO");
		bdescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activardescuento(codDes.getText());
			}
		});
		bdescuento.setBounds(137, 343, 139, 43);
		frame.getContentPane().add(bdescuento);
		/*
		JButton bvisualizar = new JButton("VISUALIZAR PRECIO");
		bvisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	textField.setText(String.valueOf(preciofinal));
			}
		});
		bvisualizar.setBounds(471, 343, 139, 43);
		frame.getContentPane().add(bvisualizar);
		*/
		
	}
	private void printTicket(List<Producto> carro) {
        try {
            double precio =0;
            FileWriter writter = new FileWriter("ticket/Ticket.txt");           
            for (Producto p : carro) {
            	writter.write("Datos prod: \n");
                writter.write(p.toString());
                precio =+p.getPrecio();
                System.out.println(precio);
                writter.write("\n");
                
			}                  
            writter.write("--------------- \n");
            writter.write("Precio Total: \n");

            writter.write((int) precio);
            writter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
	
	private static void activardescuento (String code) {
			int i=0;
			PreparedStatement preparedStatement = null;
			Connection con = ConexionDB.Conexion();
		
	        try {
	        	String query ="SELECT CODE FROM CODIGOOBJ";
			
	        	Statement statement = con.createStatement();
	        	ResultSet resultSet = statement.executeQuery(query);
          
	        	while (resultSet.next()) {
	        		if(resultSet.getString("CODE").equals(code)) {
	        			JOptionPane.showMessageDialog(null, "Codigo verficado, aplicando descuento");
	        			CodigoBD.eliminarCodigo(code);
	        			
	        			
	        			
	        			break;
	        			}
	        		else{
	        			if(i==0)
	        			{
	        				JOptionPane.showMessageDialog(null, "Codigo incorrecto");
	        				i++;
	        			}
				 }
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*
	private void getallcarritoprecio(List<Producto> carro) 
	{
		     preciofinal=0;
		for (Producto p : carro){
			 System.out.println(preciofinal);
			 preciofinal =(int) +p.getPrecio();
		}
		
		
	}
	*/
}
