package com.util;

import com.db.ConexionDB;
import com.jdo.Producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDB {

    //INSERTAR PRODUCTO

    public static void insertarProducto(Producto nuevoProducto)
    {
        //Puede que sea necesarario efectuar algunos cambios en estas sentencias
        //ya que esto es SQL puro y estamos trabajando con JDO
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO PRODUCTO (NOMBRE,MARCA,PRECIO,DESCRIPCION)"
                    + " VALUES (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);


            preparedStatement.setString(1, nuevoProducto.getNombre());
            preparedStatement.setString(2, nuevoProducto.getMarca());
            preparedStatement.setFloat(3, nuevoProducto.getPrecio());
            preparedStatement.setString(4, nuevoProducto.getDescripcion());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar el producto");
            System.out.println(e);
        }
    }

    //SELECCIONAR PRODUCTO
    public static void seleccionarProducto(String nombre){
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            String query = "SELECT * FROM PRODUCTO ";

            preparedStatement = con.prepareStatement(query);



            preparedStatement.execute();

            System.out.println("Select existoso");

        } catch (Exception e) {
            System.out.println("ERROR al seleccionar el producto");
            System.out.println(e);
        }


    }


    //ELIMINAR PRODUCTO
    public void eliminarProducto(String nombre) {

        PreparedStatement preparedStatement= null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM PRODUCTO WHERE NOMBRE = '" + nombre + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar el producto");
            System.out.println(e);
        }

    }

}
