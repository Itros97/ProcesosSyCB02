package com.util;

import com.jdo.Carrito;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarritoDB {

    //CREAR TABLA
    protected static void crearTablaCarrito(Connection con) {

        PreparedStatement preparedStatement = null;

        String createcarrito = "CREATE TABLE CARRITO(" +
                "IDCARRITO INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "NICKNAME VARCHAR(50),"+
                "NOMBRE VARCHAR(50),"+
                "PRECIOCARRITO DOUBLE);";
        try {

            preparedStatement = con.prepareStatement(createcarrito);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error al crear la tabla");
        }
    }
    //ELIMINAR TABLA
    protected static void eliminarTablaCarrito(Connection con) {

        PreparedStatement preparedStatement = null;

        String eliminarCarrito= "DROP TABLE IF EXISTS CARRITO";
        try {
            preparedStatement = con.prepareStatement(eliminarCarrito);
            preparedStatement.executeUpdate();

            System.out.println("Tabla CARRITO eliminada correctamente");

        } catch (Exception e) {
            System.err.println("Tabla CARRITO no ha podido eliminarse");
        }
    }

    public static void insertarCarrito(Carrito carro) {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO CARRITO (NICKNAME,NOMBRE,PRECIO)"
                    + " VALUES (?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, carro.getNickname());
            preparedStatement.setString(2, carro.getNombre());
            preparedStatement.setLong(3, (long) carro.getPrecioCarrito());

            preparedStatement.execute();

            System.out.println("Operacion existosa");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un ERROR");
            System.out.println(e);
        }
    }
}

