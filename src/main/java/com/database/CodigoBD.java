package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cliente.jdo.Codigoobj;
import com.cliente.jdo.Compra;

public class CodigoBD {
	
	 //ELIMINAR COMPRA
    public static void eliminarCodigo(int idCodigo) {

        PreparedStatement preparedStatement= null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM CODIGO WHERE IDCOMPRA = '" + idCodigo + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar el codigo");
            System.out.println(e);
        }   

    }
    public static void insertarCodigo(Codigoobj ncodigo)
    {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO CODIGO (CODE)"
                    + " VALUES (?)";

            preparedStatement = con.prepareStatement(query);


            preparedStatement.setString(1, ncodigo.getCodigo());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar el codigo");
            System.out.println(e);
        }
    }
}
