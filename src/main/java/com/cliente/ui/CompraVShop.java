package com.cliente.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cliente.jdo.Carrito;
import com.cliente.jdo.Producto;

public class CompraVShop {

	private JFrame frame;
	private JTextField codDes;
	private JTextField textField;

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
		botonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTicket(MainVShop.carrito);
				
				
			}
		});
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
		
		final DefaultListModel<Producto> productListModel = new DefaultListModel<>();
		JList<Producto> list = new JList<>(productListModel);
		list.setBounds(216, 37, 427, 243);
		frame.getContentPane().add(list);
		
		for (int i = 0; i < MainVShop.carrito.size(); i++) {
			productListModel.add(i, MainVShop.carrito.get(i));
		}
		
	}

	private void printTicket(List<Producto> carro) {
        try {
            double precio =0;
            FileWriter writter = new FileWriter("ticket/Ticket.txt");
            for (int i = 0; i < carro.size(); i++) {
                writter.write("Datos prod: \n");
                writter.write(carro.get(i).toString());
                precio =+carro.get(i).getPrecio();
                System.out.println(precio);
                writter.write("\n");
                if(carro.size()-i > 1 ) {
                    writter.write("-----");
                    writter.write("\n");
                }
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

	
}
