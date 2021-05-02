package com.cliente.ui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import com.cliente.jdo.Producto;

import javax.swing.JList;

public class CarritoVShop {

	private JFrame frame;

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
		
		final DefaultListModel<Producto> productListModel = new DefaultListModel<>();
		JList<Producto> list = new JList<>(productListModel);
		list.setBounds(10, 11, 414, 217);
		frame.getContentPane().add(list);
		
		
		for (int i = 0; i < MainVShop.carrito.size(); i++) {
			productListModel.add(i, MainVShop.carrito.get(i));
		}
		
		ComprarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CompraVShop.main(null);
				frame.dispose();
			}
		});
	}
}
