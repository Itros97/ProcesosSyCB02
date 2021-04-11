package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

import com.jdo.Producto;
import com.util.ProductoDB;


public class ConexionDB {


    public void ReiniciarBasesDeDatos() {
        Connection con = Conexion();
        BorrarBasesDeDatos(con);
        CrearBasesDeDatos(con);

    }

    //CODIGO PARA LA CONEXION CON LA BASE DE DATOS
    public static Connection Conexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Conexion con la BD de XAMPP(EN MI CASO USO EL PUERTO 3307 EN VEZ DEL 3306 YA QUE NO ME DEJA ACCEDER A ESTE PRIMERO)
            //Lo que esta entre parentesis igual que el  datanuclus, user, password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EStoreDB", "root", "root");
            System.out.printf("Conexion lograda");

        } catch (Exception e) {

            System.out.println("Fallo crítico");

        }

        return con;
    }

    //CREACION DE LA BASE DE DATOS
    private void CrearBasesDeDatos(Connection con) {
        UsuarioDB.crearTablaUsuario(con);
        ProductoDB.crearTablaProducto(con);
        CompraDB.crearTablaCompra(con);

    }

    //ELIMINACION DE LA BASE DE DATOS
    private void BorrarBasesDeDatos(Connection con) {
        CompraDB.eliminarTablaCompra(con);
        UsuarioDB.eliminarTablaUsuario(con);
        ProductoDB.eliminarTablaProducto(con);

    }

    //INSERT PRODUCTOS
    public void InsertarProducto(Producto nuevoProducto) {
        ProductoDB.insertarProducto(nuevoProducto);
    }
}
