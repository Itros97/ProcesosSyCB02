package com.ui;

import javax.swing.*;

public class loginVShop extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ingresarButton;
    private JButton bcrear;
    private JFormattedTextField ftfapellido2;
    private JFormattedTextField ftfapellido1;
    private JFormattedTextField ftfpassword;
    private JFormattedTextField ftfnombre;
    private JFormattedTextField ftfcorreo;
    private JFormattedTextField ftfdireccion;
    private JFormattedTextField ftftarjeta;

    public loginVShop(){
        initialize();
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initialize(){

    }

    public static void main(String[] args){
        JFrame frame = new loginVShop();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setTitle("Login");
    }
}
