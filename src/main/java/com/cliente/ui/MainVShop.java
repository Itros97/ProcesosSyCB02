package com.cliente.ui;

import com.database.ConexionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.*;




public class MainVShop extends JFrame {
    private JButton tiendaButton;
    private JButton carritoButton;
    private JButton historialButton;
    private JButton añadirCarritoButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JTable table;
    private JButton adminButton;
    private JButton searchButton;
    private JPanel searchPanel;
    private JFormattedTextField searchTextField;

    Connection con = ConexionDB.Conexion();

    public MainVShop() {
        initialize();
        add(mainPanel);
        
        table.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

    }

    public void initialize() {

        añadirCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelCuenta = new JPanel();
                panelCuenta.setBounds(0, 0, 360, 900);
                panelCuenta.setLayout(null);
            }
        });

        carritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CarritoVShop.main(null);
            }
        });

        historialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelHistorial = new JPanel();
                panelHistorial.setBounds(0, 0, 360, 900);
                panelHistorial.setLayout(null);
            }
        });

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              AdminUsersVShop.main(null);
            }
        });
    }

    public static void main(String[] args) {
        MainVShop window = new MainVShop();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setTitle("VShop");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1280, 720);

    }

}
