package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cliente.jdo.Carrito;

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
            String query = " INSERT INTO CARRITO (IDCARRITO,NICKNAME,NOMBRE,PRECIOCARRITO)"
                    + " VALUES (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, carro.getIdCarrito());
            preparedStatement.setString(2, carro.getNickname());
            preparedStatement.setString(3, carro.getNombre());
            preparedStatement.setDouble(4, carro.getPrecioCarrito());

            preparedStatement.execute();

            System.out.println("Operacion existosa");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un ERROR");
            System.out.println(e);
        }
    }

    public static void deleteCarrito(int idCarrito) {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM CARRITO WHERE IDCARRITO = '" + idCarrito + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar el carrito");
            System.out.println(e);
        }
    }
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM CARRITO";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
              count++;
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return count;
    }
}

