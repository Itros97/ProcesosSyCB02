package com.ui;

import com.jdo.Usuario;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class modificarUsuarioVShop extends JFrame{

    private JPanel modU;
    private JTextField txfnombre;
    private JTextField txfcorreo;
    private JTextField txfpassword;
    private JTextField txfdireccion;
    private JTextField txfapellido1;
    private JTextField txftarjetaCredito;
    private JTextField txfapellido2;
    private JButton modificarUsuarioButton;
    private Usuario u;

    public modificarUsuarioVShop() {
        add(modU);
    }

    public Usuario getUser() {
        return u;
    }

    public void setUser(Usuario u) {
        this.u = u;
    }

    public void main(String[] args){
        modificarUsuarioVShop window = new modificarUsuarioVShop();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setTitle("ModUsuario");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 1280, 720);
        Usuario u = new Usuario();
        u.setNombre("Prueba Nombre");
        setUser(u);
        loadUser();

    }

    public void loadUser() {
        txfnombre.setText(getUser().getNombre());
        txfcorreo.setText(getUser().getCorreo());
        txfpassword.setText(getUser().getPassword());
        txfdireccion.setText(getUser().getDireccion());
        txfapellido1.setText(getUser().getApellido1());
        txftarjetaCredito.setText(String.valueOf(getUser().getTarjetaCredito()));
        txfapellido2.setText(getUser().getApellido2());
    }

    public modificarUsuarioVShop(final Usuario u) {
        modificarUsuarioButton.addActionListener(new ActionListener() {
            private Label txftarjeta;

            @Override
            public void actionPerformed(ActionEvent e) {
                u.setNombre(txfnombre.getText());
                u.setCorreo(txfcorreo.getText());
                u.setPassword(txfpassword.getText());
                u.setDireccion(txfdireccion.getText());
                u.setApellido1(txfapellido1.getText());
                u.setTarjetaCredito(Integer.parseInt(txftarjeta.getText()));
                u.setApellido2(txfapellido2.getText());

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
