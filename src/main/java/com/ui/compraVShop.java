package com.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;

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
