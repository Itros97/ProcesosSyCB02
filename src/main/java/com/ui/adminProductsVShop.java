package com.ui;

import com.jdo.Producto;
import com.util.ProductoDB;
import com.util.UsuarioDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminProductsVShop {
    private JTabbedPane tabbedPane1;
    private JButton bcrear;
    private JFormattedTextField ftfprecio;
    private JFormattedTextField ftfnombre;
    private JFormattedTextField ftfmarca;
    private JFormattedTextField ftfdescripcion;
    private JFormattedTextField tftproducto;
    private JButton beliminarusuario;

    public adminProductsVShop() {
        initialize();
    }

    private void initialize() {
        bcrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto p1 = new Producto();
                p1.setNombre(ftfnombre.getText());
                p1.setMarca(ftfmarca.getText());
                p1.setPrecio(Float.parseFloat(ftfprecio.getText()));
                p1.setDescripcion(ftfdescripcion.getText());
                ProductoDB.insertarProducto(p1);
                System.out.println("Creo Producto");
            }
        });
        beliminarusuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoDB.eliminarProducto(Integer.parseInt(tftproducto.getText()));
            }
        });
    }
}
