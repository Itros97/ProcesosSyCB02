package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class HistorialVShop {

	private JFrame frame;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

//package com.cliente.ui;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//
//public class HistorialVShop extends JFrame {
//private JPanel mainPanel;
//private JTable table;
//private JTable table1;
//private JButton cargarCompras;
//
//
//public HistorialVShop(){
//initialize();
//add(mainPanel);
//
//table.addMouseListener(new java.awt.event.MouseAdapter(){
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        super.mouseClicked(e);
//    }
//});
//}
//public void initialize(){
//cargarCompras.addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        //Falta insertar compra
//    }
//});
//
//}
//
//public static void main(String[] args) {
//HistorialVShop window = new HistorialVShop();
//window.setVisible(true);
//window.setLocationRelativeTo(null);
//window.pack();
//window.setTitle("Historial");
//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//window.setBounds(100, 100, 1000, 600);
//
//}
//}