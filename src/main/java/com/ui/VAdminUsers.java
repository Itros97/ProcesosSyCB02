package com.ui;

import javax.swing.*;

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

    public VAdminUsers()
    {
        add(MainPanel);
    }
    //Para prueba unitaria
    public static void main(String[] args) {
        VAdminUsers va1 = new VAdminUsers();
        va1.setVisible(true);
        va1.setTitle("Admin View");
        va1.pack();
        va1.setLocationRelativeTo(null);
    }
}
