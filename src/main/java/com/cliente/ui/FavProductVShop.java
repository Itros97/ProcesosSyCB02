package com.cliente.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.cliente.jdo.Producto;
import com.database.FavoritoDB;
import com.database.UsuarioDB;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class FavProductVShop {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FavProductVShop window = new FavProductVShop();
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
	public FavProductVShop() {
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
		frame.setTitle("Productos Favoritos");
		
		JButton backButton = new JButton("Atras");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		backButton.setBounds(136, 194, 150, 23);
		frame.getContentPane().add(backButton);
		
		final DefaultListModel<Producto> favProductListModel = new DefaultListModel<>();
		JList<Producto> list = new JList<>(favProductListModel);
		//FavoritoDB.getAllFavoritos(UsuarioDB.u.getNickname(), JList<Producto>);
		list.setBounds(10, 11, 414, 169);
		frame.getContentPane().add(list);
		
		for (int i = 0; i < MainVShop.favorito.size(); i++) {
			favProductListModel.add(i, MainVShop.favorito.get(i));
		}
	}
}
