package com.cliente.ui;

import com.cliente.jdo.Usuario;
import com.database.UsuarioDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginVShop extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField contrasenyatf;
    private JTextField usuariotf;
    private JButton ingresarButton;
    private JButton crearButton;
    private JFormattedTextField ftfapellido2;
    private JFormattedTextField ftfapellido1;
    private JFormattedTextField ftfpassword;
    private JFormattedTextField ftfnombre;
    private JFormattedTextField ftfcorreo;
    private JFormattedTextField ftfdireccion;
    private JFormattedTextField ftftarjeta;
    private JFormattedTextField ftfnickname;

    public LoginVShop() {

        //  JButton ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Conexion");
                UsuarioDB.LoginUsuario(usuariotf.getText(), contrasenyatf.getText());
            }
        });
        //    JButton crearButton = new JButton("Crear");
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario u = new Usuario();
                u.setNombre(ftfnombre.getText());
                u.setApellido1(ftfapellido1.getText());
                u.setApellido2(ftfapellido2.getText());
                u.setCorreo(ftfcorreo.getText());
                u.setDireccion(ftfdireccion.getText());
                u.setPassword(ftfpassword.getText());
                u.setTarjetaCredito(Integer.parseInt(ftftarjeta.getText()));
                u.setNickname(ftfnickname.getText());
                u.setAdmin(false);
                UsuarioDB.insertarUsuarios(u);
            }
        });

    }



    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setContentPane(new LoginVShop().mainPanel);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setTitle("Login");
    }
}

