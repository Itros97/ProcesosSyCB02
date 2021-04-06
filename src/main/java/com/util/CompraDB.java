package com.util;

import com.db.ConexionDB;
import com.jdo.Compra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraDB {

    //INSERTAR COMPRA

    public static void insertarCompra(Compra nuevaCompra)
    {
        //Puede que sea necesarario efectuar algunos cambios en estas sentencias
        //ya que esto es SQL puro y estamos trabajando con JDO
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO COMPRA (IDCOMPRA,IDUSUARIOCOMPRA,IDPRODUCTOCOMPRA)"
                    + " VALUES (?, ?, ?)";

            preparedStatement = con.prepareStatement(query);


            preparedStatement.setInt(1, nuevaCompra.getIdCompra());
            preparedStatement.setInt(2, nuevaCompra.getIdUsuarioCompra());
            preparedStatement.setInt(3, nuevaCompra.getIdProductoCompra());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar la compra");
            System.out.println(e);
        }
    }



    //ELIMINAR COMPRA
    public void eliminarCompra(int idCompra) {

        PreparedStatement preparedStatement= null;
        Connection con = null;

        try {

            String query = "DELETE FROM COMPRA WHERE ID = '" + idCompra + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar la compra");
            System.out.println(e);
        }

    }


}
