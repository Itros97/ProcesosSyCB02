package com.ui;

import com.util.CarritoDB;
import com.util.ProductoDB;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;


public class compraVShop extends JFrame{
    private JPanel compraMainPanel;
    private JTable productoTable;
    private JTextField descuentoTextField;
    private JLabel descuentoLabel;
    private JTextField precioTotalTextField;
    private JButton compraButton;
    private JButton deleteCestaButton;
    private JButton deleteProductoButton;
    private JPanel precioPanel;
    private JLabel precioLabel;
    private JPanel buttonPanel;
    private JPanel pagoPanel;
    private JButton closeButton;

    static Connection conn = null;

    public compraVShop(){
        initialize();
        add(compraMainPanel);

        productoTable.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void initialize(){

        deleteCestaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CarritoDB.deleteCarrito(); Falta insertar carrito
            }
        });

        deleteProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ProductoDB.eliminarProducto(); Faltan insertar productos
            }
        });

        compraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Compra Realizada");

            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        compraVShop window = new compraVShop();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setTitle("Compra");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(100, 100 , 1000, 600);
    }
}
