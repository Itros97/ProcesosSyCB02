package com.cliente.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class CompraVShop extends JFrame{
    private JTable table;
    private JPanel mainPanel;
    private JButton deleteCarritoButton;
    private JButton deleteProductoButton;
    private JTextField descuentoTextField;
    private JTextField precioTotalTextField;
    private JButton compraButton;
    private JButton closeButton;
    private JPanel buttonPanel;
    private JLabel precioTotalLabel;
    private JLabel descuentoLabel;

    public CompraVShop(){
        initialize();
        add(mainPanel);

        table.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
    public void initialize(){
        deleteCarritoButton.addActionListener(new ActionListener() {
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
                //window.dispose();
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        CompraVShop window = new CompraVShop();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setTitle("Compra");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 1000, 600);

    }
}
