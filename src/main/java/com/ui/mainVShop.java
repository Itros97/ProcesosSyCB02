package com.ui;

import javax.swing.*;

public class mainVShop extends JFrame{
    private JButton tiendaButton;
    private JButton carritoButton;
    private JButton historialButton;
    private JButton añadirCarritoButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    public mainVShop()
    {
        add(mainPanel);
    }

    public static void main(String[] args){
        mainVShop window = new mainVShop();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setTitle("VShop");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 1280, 720);

    }

}
