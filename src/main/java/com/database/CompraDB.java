package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cliente.jdo.Compra;

public class CompraDB {

   /**
    * This is the method that inserts Compra in the database
    * @param nuevaCompra
    */
    public static void insertarCompra(Compra nuevaCompra) {
        
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO COMPRA (IDCOMPRA,CORREOUSUARIO,IDPRODUCTOCOMPRA)"
                    + " VALUES (?, ?, ?)";

            preparedStatement = con.prepareStatement(query);


            preparedStatement.setInt(1, nuevaCompra.getIdCompra());
            preparedStatement.setString(2, nuevaCompra.getCorreoUsuario());
            preparedStatement.setInt(3, nuevaCompra.getIdProductoCompra());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar la compra");
            System.out.println(e);
        }
    }

    /**
     * This is the method that deletes a certain Compra in the database
     * @param idCompra
     */
    public static void eliminarCompra(int idCompra) {

        PreparedStatement preparedStatement= null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM COMPRA WHERE IDCOMPRA = '" + idCompra + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar la compra");
            System.out.println(e);
        }

    }
    
    /**
     * This is the method that shows the quantity of Compra items of the database
     * @return
     */
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM COMPRA";
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
