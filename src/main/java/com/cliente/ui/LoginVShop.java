package com.cliente.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.database.UsuarioDB;

import javax.swing.JButton;
import javax.swing.JLabel;

public class LoginVShop {

	private JFrame frame;
	private JTextField usuariotf;
	private JTextField passwordtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVShop window = new LoginVShop();
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
	public LoginVShop() {
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
		
		usuariotf = new JTextField();
		usuariotf.setBounds(137, 67, 163, 20);
		frame.getContentPane().add(usuariotf);
		usuariotf.setColumns(10);
		
		passwordtf = new JTextField();
		passwordtf.setBounds(137, 154, 163, 20);
		frame.getContentPane().add(passwordtf);
		passwordtf.setColumns(10);
		
		JButton Ingresar = new JButton("New button");
		Ingresar.setBounds(176, 227, 89, 23);
		frame.getContentPane().add(Ingresar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(193, 42, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(193, 129, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		Ingresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioDB.LoginUsuario(usuariotf.getText(), passwordtf.getText());
				
			}
		});
		
	}
	
}
