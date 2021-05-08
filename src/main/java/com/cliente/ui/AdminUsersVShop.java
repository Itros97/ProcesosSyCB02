
package com.cliente.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cliente.jdo.Usuario;
import com.database.UsuarioDB;

public class AdminUsersVShop {

	private JFrame frame;
	
	private JTextField correo1;
	private JTextField nombre;
	private JTextField correo;
	private JTextField dir;
	private JTextField tarjeta;
	private JTextField nickname;
	private JTextField ape1;
	private JTextField ape2;
	private JPasswordField password;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUsersVShop window = new AdminUsersVShop();
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
	public AdminUsersVShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 379);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("AdminsUsersVShop");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 554, 481);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelCrear = new JPanel();
		tabbedPane.addTab("Crear", null, panelCrear, null);
		panelCrear.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(10, 11, 93, 24);
		panelCrear.add(labelNombre);
		
		JLabel labelCorreo = new JLabel("Correo");
		labelCorreo.setBounds(256, 16, 93, 24);
		panelCrear.add(labelCorreo);
		
		JLabel labelContrasenya = new JLabel("Contraseña");
		labelContrasenya.setBounds(10, 72, 93, 24);
		panelCrear.add(labelContrasenya);
		
		JLabel labelDireccion = new JLabel("Direccion");
		labelDireccion.setBounds(256, 77, 93, 24);
		panelCrear.add(labelDireccion);
		
		JLabel labelApe1 = new JLabel("Apellido 1");
		labelApe1.setBounds(10, 139, 93, 24);
		panelCrear.add(labelApe1);
		
		JLabel labelApe2 = new JLabel("Apellido 2");
		labelApe2.setBounds(10, 211, 93, 24);
		panelCrear.add(labelApe2);
		
		JLabel labelTarjeta = new JLabel("Tarjeta Credito");
		labelTarjeta.setBounds(256, 139, 93, 24);
		panelCrear.add(labelTarjeta);
		
		JLabel labelNickname = new JLabel("Nickname");
		labelNickname.setBounds(256, 211, 93, 24);
		panelCrear.add(labelNickname);
		
		nombre = new JTextField();
		nombre.setBounds(10, 41, 213, 20);
		panelCrear.add(nombre);
		nombre.setColumns(10);
		
		correo = new JTextField();
		correo.setColumns(10);
		correo.setBounds(256, 41, 213, 20);
		panelCrear.add(correo);
		
		dir = new JTextField();
		dir.setColumns(10);
		dir.setBounds(256, 108, 213, 20);
		panelCrear.add(dir);
		
		tarjeta = new JTextField();
		tarjeta.setColumns(10);
		tarjeta.setBounds(256, 174, 213, 20);
		panelCrear.add(tarjeta);
		
		nickname = new JTextField();
		nickname.setColumns(10);
		nickname.setBounds(256, 246, 213, 20);
		panelCrear.add(nickname);
		
		ape1 = new JTextField();
		ape1.setColumns(10);
		ape1.setBounds(10, 174, 213, 20);
		panelCrear.add(ape1);
		
		ape2 = new JTextField();
		ape2.setColumns(10);
		ape2.setBounds(10, 246, 213, 20);
		panelCrear.add(ape2);
		
		password = new JPasswordField();
		password.setBounds(10, 108, 213, 20);
		panelCrear.add(password);
		
		JButton botonCrearUsuario = new JButton("CREAR USUARIO");
		botonCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c, n, ni, pa, a1, a2, d;
				int ta;
				boolean ad;
				
				c = correo.getText();
				n = nombre.getText();
				ni = nickname.getText();
				pa = password.getText();
				a1 = ape1.getText();
				a2 = ape2.getText();
				d = dir.getText();
				ta = Integer.parseInt(tarjeta.getText());
				ad = false;
				
				Usuario u = new Usuario(n, ni, pa, a1, a2, c, d, ta, ad);
				UsuarioDB.insertarUsuarios(u);
			}
		});
		botonCrearUsuario.setBounds(10, 280, 459, 23);
		panelCrear.add(botonCrearUsuario);
		
		JPanel panelEliminar = new JPanel();
		tabbedPane.addTab("Eliminar", null, panelEliminar, null);
		panelEliminar.setLayout(null);
		
		JLabel labelId = new JLabel("CORREO:");
		labelId.setBounds(10, 11, 85, 42);
		panelEliminar.add(labelId);
		
		correo1 = new JTextField();
		correo1.setBounds(70, 17, 378, 31);
		panelEliminar.add(correo1);
		correo1.setColumns(10);
		
		JButton botonEliminar = new JButton("ELIMINAR CORREO");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c;
				
				c = correo1.getText();
				
				UsuarioDB.eliminarUsuario(c);
			}
		});
		botonEliminar.setBounds(70, 64, 378, 31);
		panelEliminar.add(botonEliminar);
		
		JPanel panelModificar = new JPanel();
		tabbedPane.addTab("Modificar", null, panelModificar, null);
		panelModificar.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 456, 290);
		panelModificar.add(table);
	}
}
