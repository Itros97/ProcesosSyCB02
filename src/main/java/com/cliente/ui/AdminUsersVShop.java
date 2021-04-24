package com.cliente.ui;

import com.cliente.jdo.Usuario;
import com.database.UsuarioDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUsersVShop extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel MainPanel;
    private JButton bcrear;
    private JFormattedTextField ftfapellido2;
    private JFormattedTextField ftfapellido1;
    private JFormattedTextField ftfpassword;
    private JFormattedTextField ftfnombre;
    private JFormattedTextField ftfcorreo;
    private JFormattedTextField ftfdireccion;
    private JFormattedTextField ftftarjeta;
    private JFormattedTextField tfteliminarcorreo;
    private JButton beliminarusuario;
    private JFormattedTextField ftfNickname;

    public AdminUsersVShop()
    {
        initialize();
        add(MainPanel);
    }
    private void initialize() {
       bcrear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //Falta verificar si existe el usuario
               Usuario n1 = new Usuario();
               n1.setNombre(ftfnombre.getText());
               n1.setNickname(ftfNickname.getText());
               n1.setApellido1(ftfapellido1.getText());
               n1.setApellido2(ftfapellido2.getText());
               n1.setCorreo(ftfcorreo.getText());
               n1.setDireccion(ftfdireccion.getText());
               n1.setPassword(ftfpassword.getText());
               n1.setTarjetaCredito(Integer.parseInt(ftftarjeta.getText()));
               n1.setAdmin(false);
               UsuarioDB.insertarUsuarios(n1);
               System.out.println("Creo user");
           }
       });
        beliminarusuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = tfteliminarcorreo.getText();
                UsuarioDB.eliminarUsuario(value);
            }
        });
    }

    //Para prueba unitarias

    public static void main(String[] args) {
        AdminUsersVShop va1 = new AdminUsersVShop();
        va1.setVisible(true);
        va1.setTitle("Admin View");
        va1.pack();
        va1.setLocationRelativeTo(null);
    }
}