package com.cliente.ui;

import com.cliente.jdo.Carrito;
import com.database.CompraDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    private ArrayList<Carrito> carrito = new ArrayList<>();

    public CompraVShop(){

        table.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

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
                //CompraDB.insertarCompra(); faltan insertar los parametros
                JOptionPane.showMessageDialog(null, "Compra Realizada", null, JOptionPane.INFORMATION_MESSAGE);

                printTicket(carrito); // ticket vacio ya que no hay productos

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

    private void printTicket(ArrayList<Carrito> carro) {
        try {
            double precio =0;
            FileWriter writter = new FileWriter("ticket/Ticket.txt");
            for (int i = 0; i < carro.size(); i++) {
                writter.write("Datos prod: \n");
                writter.write(carro.get(i).toString());
                precio =+carro.get(i).getPrecioCarrito();
                System.out.println(precio);
                writter.write("\n");
                if(carro.size()-i > 1 ) {
                    writter.write("-----");
                    writter.write("\n");
                }
            }
            writter.write("--------------- \n");
            writter.write("Precio Total: \n");

            writter.write((int) precio);
            writter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CompraVShop window = new CompraVShop();
        window.setContentPane(new CompraVShop().mainPanel);
        window.setBounds(100, 100, 1000, 600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setTitle("Compra");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
