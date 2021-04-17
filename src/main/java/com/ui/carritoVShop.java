package com.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class carritoVShop extends JFrame{
    private JTable tabla;
    private JButton botonAtras;
    private JButton botonCesta;
    private JPanel panelPrincipal;
    private JPanel panelBotones;

    private DefaultTableModel modelo;


    public carritoVShop() {
        initialize();


        add(panelPrincipal);
    }

    public void initialize() {
        String[] nombresColumnas = { "NICKNAME", "NOMBRE", "PRECIO CARRITO" };
        modelo = new DefaultTableModel(null, nombresColumnas);

        //tabla = new JTable(modelo);
        tabla.setModel(modelo);

    }

    public static void main(String[] args) {
        carritoVShop frame = new carritoVShop();
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Carrito");

    }


}
