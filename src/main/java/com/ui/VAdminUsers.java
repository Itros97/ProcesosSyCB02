package com.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VAdminUsers extends JFrame{
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

    public VAdminUsers()
    {
        initialize();
        add(MainPanel);
    }
    private void initialize() {
       bcrear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("Creouser");
           }
       });
    }
    //Para prueba unitarias

    public static void main(String[] args) {
        VAdminUsers va1 = new VAdminUsers();
        va1.setVisible(true);
        va1.setTitle("Admin View");
        va1.pack();
        va1.setLocationRelativeTo(null);
    }
}
