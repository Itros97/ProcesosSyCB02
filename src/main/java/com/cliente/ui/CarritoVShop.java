package com.cliente.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarritoVShop extends JFrame{
    private JTable tabla;
    private JButton botonAtras;
    private JButton botonComprar;
    private JPanel panelPrincipal;
    private JPanel panelBotones;

    private DefaultTableModel modelo;


    public CarritoVShop() {

        String[] nombresColumnas = { "NICKNAME", "NOMBRE", "PRECIO CARRITO" };
        modelo = new DefaultTableModel(null, nombresColumnas);

        //tabla = new JTable(modelo);
        tabla.setModel(modelo);

        botonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        botonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // compraVShop.main(null);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        CarritoVShop frame = new CarritoVShop();
        frame.setContentPane(new CarritoVShop().panelPrincipal);
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Carrito");

    }


}
