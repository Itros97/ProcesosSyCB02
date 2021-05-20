package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cliente.jdo.Carrito;

public class CarritoDB {

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
    
	public static void recogerCarrito(Carrito carro) {
		PreparedStatement preparedStatement = null;
		Connection con = ConexionDB.Conexion();
		try {
			String query = " SELECT * FROM CARRITO ORDER BY NOMBRE ASC";

			preparedStatement = con.prepareStatement(query);

			preparedStatement.execute();
			preparedStatement.close();

			System.out.println("Operacion existosa");

		} catch (SQLException e) {
			System.out.println("No se ha podido ordenar el carrito");
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

