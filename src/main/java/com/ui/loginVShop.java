package com.ui;

import javax.swing.*;

public class loginVShop extends JFrame {

    private JPanel mainPanel;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JLabel labelUsuario;
    private JLabel labelPassword;
    private JButton buttonIngresar;

    public loginVShop(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JFrame frame = new loginVShop();
        frame.setVisible(true);
        frame.setSize(500,500);
    }
}
