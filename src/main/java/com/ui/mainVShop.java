package com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import com.db.ConexionDB;
import com.jdo.Compra;
import com.jdo.Producto;
import net.proteanit.sql.DbUtils;


public class mainVShop extends JFrame{
    private JButton tiendaButton;
    private JButton carritoButton;
    private JButton historialButton;
    private JButton añadirCarritoButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JTable table;

    Connection con = ConexionDB.Conexion();

    public mainVShop()
    {
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
        tiendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "SELECT NOMBRE, MARCA, PRECIO, DESCRIPCION FROM PRODUCTO";
                    PreparedStatement pst = con.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();


                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setDefaultEditor(Object.class, null);
                } catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        añadirCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelCuenta = new JPanel();
                panelCuenta.setBounds(0, 0, 360, 900);
                panelCuenta.setLayout(null);
            }
        });

        carritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelCarrito = new JPanel();
                panelCarrito.setBounds(0, 0, 360, 900);
                panelCarrito.setLayout(null);
            }
        });

        historialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelHistorial = new JPanel();
                panelHistorial.setBounds(0, 0, 360, 900);
                panelHistorial.setLayout(null);

                //ResultSet rs = anadir aqui metodo que devuelva historial de compras desde base de datos

//                table.setModel(DbUtils.resultSetToTableModel(rs));
//                table.setDefaultEditor(Object.class, null);

            }
        });
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
