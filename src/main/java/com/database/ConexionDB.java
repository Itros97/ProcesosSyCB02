package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cliente.jdo.Producto;


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
            //Lo que esta entre parentesis igual que el  datanuclus, user, password (Si uso puerto )
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EStoreDB", "spq", "spq");
            System.out.printf("Conexion lograda");

        } catch (Exception e) {

            System.out.println("Fallo crítico");

        }

        return con;
    }
    public int executeQuery(String query) throws ClassNotFoundException, SQLException {
    	Connection con = Conexion();
    	return con.createStatement().executeUpdate(query);
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
