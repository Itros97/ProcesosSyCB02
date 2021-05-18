package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.miscelaneus.Codigo;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class CodigosVShop {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodigosVShop window = new CodigosVShop();
					window.frame.setVisible(true);
					window.frame.setTitle("Administración : Generar códigos de descuento");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CodigosVShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("Borrar");
		btnNewButton_2.setBounds(176, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Elimino los códigos");
			}
		});
		final JLabel lblNewLabel_0 = new JLabel("New label");
		lblNewLabel_0.setBounds(10, 11, 227, 14);
		frame.getContentPane().add(lblNewLabel_0);
		
		final JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 36, 227, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 61, 227, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		final JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 86, 227, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		final JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 111, 227, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Guardar/Guardar en txt");
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Guardo en la bd y txt");
				
					try {
						FileWriter writter = new FileWriter("Codigos/Codigos.txt");
						writter.write("--------------- \n");
						writter.write(lblNewLabel_0.getText());
						writter.write("\n--------------- \n");
						writter.write(lblNewLabel_1.getText());
						writter.write("\n--------------- \n");
						writter.write(lblNewLabel_2.getText());
						writter.write("\n--------------- \n");
						writter.write(lblNewLabel_3.getText());
						writter.write("\n--------------- \n");
						writter.write(lblNewLabel_4.getText());
						writter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Generar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 6; i++) {
					Codigo cod = new Codigo();
					if(i==0) 
					{
					lblNewLabel_0.setText(cod.generarcodigo(0, 10));
					}
					if(i==1) 
					{
					lblNewLabel_1.setText(cod.generarcodigo(0, 10));
					}
					if(i==2) 
					{
					lblNewLabel_2.setText(cod.generarcodigo(0, 10));
					}
					if(i==3) 
					{
					lblNewLabel_3.setText(cod.generarcodigo(0, 10));
					}
					if(i==4) 
					{
					lblNewLabel_4.setText(cod.generarcodigo(0, 10));
					}
					cod.setCodigo("");
					
				}
			
			}
		});
		btnNewButton_3.setBounds(10, 193, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
